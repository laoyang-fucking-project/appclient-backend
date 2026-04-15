package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.kuafu.common.entity.StaticResource;
import java.util.List;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import com.kuafu.common.entity.BaseEntity;
/**
 * <p>智能家居设备表</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmartHomeDeviceVO  extends BaseEntity {

    @JsonProperty("smartDeviceId")
    private Integer smartDeviceId;
    @JsonProperty("deviceName")
    private String deviceName;
    @JsonProperty("smartDeviceTypeEnumSmartDeviceTypeEnumId1")
    private Integer smartDeviceTypeEnumSmartDeviceTypeEnumId1;
    @JsonProperty("smartDeviceStatusEnumSmartDeviceStatusEnumId1")
    private Integer smartDeviceStatusEnumSmartDeviceStatusEnumId1;
    @JsonProperty("roomName")
    private String roomName;
    @JsonProperty("currentValue")
    private String currentValue;
    @JsonProperty("isOn")
    private Integer isOn;
    @JsonProperty("brightness")
    private Integer brightness;
    @JsonDeserialize(using = MultiDateDeserializer.class)
    @JsonProperty("lastUpdateTime")
    private Date lastUpdateTime;
    @JsonProperty("userInfoUserInfoId1")
    private Integer userInfoUserInfoId1;




}
