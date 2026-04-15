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
 * <p>传感器数据记录表-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SensorDataRecordAllPageVO extends BaseEntity {

@JsonProperty("userInfoUserInfoId1")
    private Integer userInfoUserInfoId1;
@JsonProperty("sensorDataRecordId")
    private Integer sensorDataRecordId;
@JsonProperty("smartDeviceTypeEnumSmartDeviceTypeEnumId1")
    private Integer smartDeviceTypeEnumSmartDeviceTypeEnumId1;
@JsonProperty("isOn")
    private Integer isOn;
@JsonProperty("sensorValue")
    private String sensorValue;
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
@JsonProperty("smartDeviceStatusEnumSmartDeviceStatusEnumId1")
    private Integer smartDeviceStatusEnumSmartDeviceStatusEnumId1;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("recordTime")
    private Date recordTime;

}
