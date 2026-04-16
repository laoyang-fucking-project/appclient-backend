package com.kuafu.common.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.dynamic_config.domain.SystemConfig;
import com.kuafu.common.dynamic_config.service.SystemConfigService;
import com.kuafu.common.util.IdUtils;
import com.kuafu.common.util.ServletUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.login.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class CompatibilityBridgeController {

    private static final String DEFAULT_RECTANGLE = "116.368904,39.923423;116.457767,39.971256";
    private static final String AMAP_IP_API = "https://restapi.amap.com/v3/ip";
    private static final Logger LOGGER = LoggerFactory.getLogger(CompatibilityBridgeController.class);

    @Resource
    private SystemConfigService systemConfigService;

    @IgnoreAuth
    @GetMapping("/admin/app/publish/result")
    public BaseResponse getPublishResult(@RequestParam(value = "app_id", required = false) String appId) {
        Map<String, Object> data = new HashMap<>();
        data.put("app_id", appId);
        data.put("h5_is_expired", getBooleanConfig("app_h5_is_expired", false));
        data.put("wx_is_expired", getBooleanConfig("app_wx_is_expired", false));
        data.put("apk_is_expired", getBooleanConfig("app_apk_is_expired", false));
        data.put("harmonyOS_is_expired", getBooleanConfig("app_harmony_is_expired", false));
        data.put("url", getStringConfig("app_restart_url", ""));
        data.put("message", getStringConfig("app_pause_message", ""));
        return ResultUtils.success(data);
    }

    @IgnoreAuth
    @PostMapping("/admin/app/send/creator")
    public BaseResponse sendCreator(@RequestBody(required = false) Map<String, Object> body) {
        String traceId = IdUtils.fastSimpleUUID();
        String appId = extractString(body, "app_id", "");

        LOGGER.warn("app restart reminder, traceId={}, appId={}, payload={}", traceId, appId, body);

        Map<String, Object> data = new HashMap<>();
        data.put("trace_id", traceId);
        data.put("accepted", true);
        data.put("app_id", appId);
        data.put("message", "提醒已受理");
        return ResultUtils.success(data);
    }

    @IgnoreAuth
    @PostMapping("/error/report")
    public BaseResponse reportError(@RequestBody(required = false) Map<String, Object> body) {
        String traceId = IdUtils.fastSimpleUUID();
        String path = extractString(body, "path", "");
        String type = extractString(body, "type", "");
        String subSource = extractString(body, "sub_source", "");
        String message = extractString(body, "error_message", "");
        String appId = extractString(body, "app_id", "");

        LOGGER.error("frontend error report, traceId={}, appId={}, ip={}, type={}, subSource={}, path={}, message={}",
                traceId,
                appId,
                ServletUtils.getClientIp(),
                type,
                subSource,
                path,
                message);

        Map<String, Object> data = new HashMap<>();
        data.put("trace_id", traceId);
        data.put("accepted", true);
        return ResultUtils.success(data);
    }

    @IgnoreAuth
    @PostMapping("/api/amap_ip_location")
    public BaseResponse amapIpLocation() {
        Map<String, Object> data = new HashMap<>();
        String rectangle = resolveRectangle();
        data.put("rectangle", rectangle);
        data.put("city", getStringConfig("amap_default_city", ""));
        data.put("province", getStringConfig("amap_default_province", ""));
        return ResultUtils.success(data);
    }

    private String resolveRectangle() {
        String rectangle = getStringConfig("amap_ip_location_rectangle", "");
        if (isValidRectangle(rectangle)) {
            return rectangle;
        }

        String amapKey = getStringConfig("amap_web_key", "");
        if (StringUtils.isEmpty(amapKey)) {
            return DEFAULT_RECTANGLE;
        }

        try {
            Map<String, Object> query = new HashMap<>();
            query.put("key", amapKey);
            query.put("ip", ServletUtils.getClientIp());
            String body = HttpUtil.get(AMAP_IP_API, query);
            JSONObject json = JSONUtil.parseObj(body);
            if ("1".equals(json.getStr("status"))) {
                String resolved = json.getStr("rectangle");
                if (isValidRectangle(resolved)) {
                    return resolved;
                }
            }
        } catch (Exception e) {
            LOGGER.warn("resolve amap ip location failed: {}", e.getMessage());
        }

        return DEFAULT_RECTANGLE;
    }

    private boolean isValidRectangle(String rectangle) {
        return StringUtils.isNotEmpty(rectangle) && rectangle.contains(";") && rectangle.contains(",");
    }

    private String getStringConfig(String name, String defaultValue) {
        if (StringUtils.isEmpty(name)) {
            return defaultValue;
        }
        try {
            QueryWrapper<SystemConfig> wrapper = new QueryWrapper<>();
            wrapper.eq("name", name);
            wrapper.last("limit 1");
            List<Map<String, Object>> records = systemConfigService.listMaps(wrapper);
            if (records == null || records.isEmpty() || records.get(0) == null) {
                return defaultValue;
            }
            Object contentObject = records.get(0).get("content");
            String content = contentObject == null ? null : String.valueOf(contentObject);
            return StringUtils.isNotEmpty(content) ? content : defaultValue;
        } catch (Exception e) {
            LOGGER.warn("read system config failed for key {}: {}", name, e.getMessage());
            return defaultValue;
        }
    }

    private boolean getBooleanConfig(String name, boolean defaultValue) {
        String value = getStringConfig(name, String.valueOf(defaultValue));
        if (StringUtils.isEmpty(value)) {
            return defaultValue;
        }
        if ("1".equals(value)) {
            return true;
        }
        if ("0".equals(value)) {
            return false;
        }
        return "true".equalsIgnoreCase(value)
                || "yes".equalsIgnoreCase(value)
                || "on".equalsIgnoreCase(value);
    }

    private String extractString(Map<String, Object> body, String key, String defaultValue) {
        if (body == null || key == null || !body.containsKey(key)) {
            return defaultValue;
        }
        Object value = body.get(key);
        return value == null ? defaultValue : String.valueOf(value);
    }
}