package com.kuafu.login.domain;

import com.kuafu.login.domain.SelectVo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LoginReverence {

            kfSystemConfig("系统配置","kfSystemConfig"),
        userInfo("用户","userInfo"),
        roleEnum("角色","roleEnum"),
        alertTypeEnum("预警类型","alertTypeEnum"),
        alertLevelEnum("预警等级","alertLevelEnum"),
        alertStatusEnum("预警状态","alertStatusEnum"),
        securityAlert("安全预警","securityAlert"),
        requestTypeEnum("请求类型","requestTypeEnum"),
        requestStatusEnum("请求状态","requestStatusEnum"),
        propertyServiceRequest("物业请求","propertyServiceRequest"),
        aiChatRecord("AI问答","aiChatRecord"),
        deviceTypeEnum("设备类型","deviceTypeEnum"),
        deviceStatusEnum("设备状态","deviceStatusEnum"),
        deviceStatus("设备状态","deviceStatus"),
        careModeSetting("关怀模式","careModeSetting"),
        smartDeviceTypeEnum("设备类型枚举表","smartDeviceTypeEnum"),
        smartDeviceStatusEnum("设备状态枚举表","smartDeviceStatusEnum"),
        smartHomeDevice("智能家居设备表","smartHomeDevice"),
        deviceControlLog("设备控制记录表","deviceControlLog"),
        sensorDataRecord("传感器数据记录表","sensorDataRecord"),
        deviceAlertRecord("设备告警记录表","deviceAlertRecord"),
    ;


    private String label;
    private String value;

    LoginReverence(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public static List<SelectVo> all() {
        final LoginReverence[] values = LoginReverence.values();
        return Arrays.stream(values).map(r -> {
            return new SelectVo(r.getValue(), r.getLabel(),r.getLabel());
        }).collect(Collectors.toList());
    }
}
