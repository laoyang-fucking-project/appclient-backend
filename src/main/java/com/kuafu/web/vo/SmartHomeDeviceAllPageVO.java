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
public class SmartHomeDeviceAllPageVO extends BaseEntity {

@JsonProperty("typeName")
    private String typeName;
@JsonProperty("userInfoUserInfoId1")
    private Integer userInfoUserInfoId1;
@JsonProperty("statusName")
    private String statusName;
@JsonProperty("smartDeviceTypeEnumSmartDeviceTypeEnumId1")
    private Integer smartDeviceTypeEnumSmartDeviceTypeEnumId1;
@JsonProperty("isOn")
    private Integer isOn;
@JsonProperty("roleEnumRoleEnumId1")
    private Integer roleEnumRoleEnumId1;
@JsonProperty("smartDeviceId")
    private Integer smartDeviceId;
@JsonProperty("currentValue")
    private String currentValue;
@JsonProperty("roomName")
    private String roomName;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("lastUpdateTime")
    private Date lastUpdateTime;
@JsonProperty("deviceName")
    private String deviceName;
@JsonProperty("password")
    private String password;
@JsonProperty("brightness")
    private Integer brightness;
@JsonProperty("smartDeviceStatusEnumSmartDeviceStatusEnumId1")
    private Integer smartDeviceStatusEnumSmartDeviceStatusEnumId1;
@JsonProperty("phoneNumber")
    private String phoneNumber;
@JsonProperty("username")
    private String username;

}
