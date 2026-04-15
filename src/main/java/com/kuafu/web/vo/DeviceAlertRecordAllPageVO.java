package com.kuafu.web.vo;

import com.kuafu.common.domin.PageRequest;
import com.kuafu.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import com.kuafu.common.entity.StaticResource;

/**
 * <p>设备告警记录表-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DeviceAlertRecordAllPageVO extends BaseEntity {

@JsonProperty("deviceAlertRecordId")
    private Integer deviceAlertRecordId;
@JsonProperty("userInfoUserInfoId1")
    private Integer userInfoUserInfoId1;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("createTime")
    private Date createTime;
@JsonProperty("alertMessage")
    private String alertMessage;
@JsonProperty("smartDeviceTypeEnumSmartDeviceTypeEnumId1")
    private Integer smartDeviceTypeEnumSmartDeviceTypeEnumId1;
@JsonProperty("isOn")
    private Integer isOn;
@JsonProperty("alertType")
    private String alertType;
@JsonProperty("currentValue")
    private String currentValue;
@JsonProperty("roomName")
    private String roomName;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("lastUpdateTime")
    private Date lastUpdateTime;
@JsonProperty("smartHomeDeviceSmartDeviceId1")
    private Integer smartHomeDeviceSmartDeviceId1;
@JsonProperty("deviceName")
    private String deviceName;
@JsonProperty("brightness")
    private Integer brightness;
@JsonProperty("isResolved")
    private Integer isResolved;
@JsonProperty("smartDeviceStatusEnumSmartDeviceStatusEnumId1")
    private Integer smartDeviceStatusEnumSmartDeviceStatusEnumId1;
@JsonProperty("alertLevel")
    private String alertLevel;

}
