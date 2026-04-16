package com.kuafu.llm.controller;

import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.IdUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.login.annotation.IgnoreAuth;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("chat")
@ConditionalOnProperty(prefix = "llm", name = "enable", havingValue = "false", matchIfMissing = true)
public class ChatFallbackController {

    @IgnoreAuth
    @PostMapping("")
    public BaseResponse fallbackChat(@RequestBody(required = false) Map<String, Object> body) {
        String conversationId = extractConversationId(body);
        if (StringUtils.isEmpty(conversationId)) {
            conversationId = IdUtils.fastSimpleUUID();
        }

        Map<String, Object> data = new HashMap<>();
        data.put("answer", "当前AI能力暂未启用，请联系管理员开启LLM配置");
        data.put("conversationId", conversationId);
        data.put("conversation_id", conversationId);
        data.put("type", "text");
        return ResultUtils.success(data);
    }

    private String extractConversationId(Map<String, Object> body) {
        if (body == null) {
            return "";
        }
        Object conversationId = body.get("conversationId");
        if (conversationId != null && StringUtils.isNotEmpty(String.valueOf(conversationId))) {
            return String.valueOf(conversationId);
        }
        Object conversionId = body.get("conversionId");
        if (conversionId != null && StringUtils.isNotEmpty(String.valueOf(conversionId))) {
            return String.valueOf(conversionId);
        }
        return "";
    }
}