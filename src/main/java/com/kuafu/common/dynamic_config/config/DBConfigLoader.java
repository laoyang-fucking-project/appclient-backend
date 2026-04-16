package com.kuafu.common.dynamic_config.config;

import com.kuafu.common.dynamic_config.domain.SystemConfig;
import com.kuafu.common.dynamic_config.service.SystemConfigService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 初始化加载配置
 */
@Component
@Slf4j
//@DependsOn("flyway")
public class DBConfigLoader {

    @Autowired
    private SystemConfigService systemConfigService;

    @Autowired
    private ConfigurableEnvironment environment;

    @PostConstruct
    public void run() {

        RetryTemplate retryTemplate = RetryTemplate.builder()
                .maxAttempts(10)
                .exponentialBackoff(2000, 2, 20000)
                .retryOn(Exception.class)
                .build();

        try {
            retryTemplate.execute(ctx -> loading());
        } catch (Exception e) {
            // 环境初始化阶段允许降级启动，避免因动态配置表缺失导致服务不可用
            log.warn("动态配置加载失败，降级为默认配置启动: {}", e.getMessage());
        }
    }

    public boolean loading() {
        log.info("开始加载数据库配置...");
        List<SystemConfig> systemConfigs;
        try {
            systemConfigs = systemConfigService.list();
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null && message.contains("no such table: kf_system_config")) {
                log.warn("检测到缺失 kf_system_config 表，跳过数据库动态配置加载");
                return true;
            }
            throw e;
        }

        if (ObjectUtils.isEmpty(systemConfigs)) {
            return true;
        }
        Map<String, Object> props = new HashMap<>();
        for (SystemConfig p : systemConfigs) {
            props.put(p.getName(), p.getContent());
        }
        // 添加到环境中
        MapPropertySource propertySource = new MapPropertySource("dbConfig", props);

        environment.getPropertySources().addFirst(propertySource);

        log.info("结束加载数据库配置...");
        return true;
    }
}

