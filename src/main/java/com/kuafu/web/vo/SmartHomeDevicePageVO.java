package com.kuafu.web.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import com.kuafu.common.domin.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.kuafu.common.entity.BaseEntity;
/**
 * <p>智能家居设备表-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SmartHomeDevicePageVO extends BaseEntity {

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
