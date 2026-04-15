package com.kuafu.web.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * <p>  设备控制记录表 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceControlLogAll {
    @TableField(value="dcl.user_info_user_info_id_1")
    @JsonProperty("user_info_user_info_id_1")
    private Integer userInfoUserInfoId1;
    @TableField(value="dcl.create_time")
    @JsonProperty("create_time")
    private Date createTime;
    @TableField(value="dcl.action_type")
    @JsonProperty("action_type")
    private String actionType;
    @TableField(value="shd.smart_device_type_enum_smart_device_type_enum_id_1")
    @JsonProperty("smart_device_type_enum_smart_device_type_enum_id_1")
    private Integer smartDeviceTypeEnumSmartDeviceTypeEnumId1;
    @TableField(value="shd.is_on")
    @JsonProperty("is_on")
    private Integer isOn;
    @TableField(value="ui.role_enum_role_enum_id_1")
    @JsonProperty("role_enum_role_enum_id_1")
    private Integer roleEnumRoleEnumId1;
    @TableField(value="shd.current_value")
    @JsonProperty("current_value")
    private String currentValue;
    @TableField(value="shd.room_name")
    @JsonProperty("room_name")
    private String roomName;
    @TableField(value="shd.last_update_time")
    @JsonProperty("last_update_time")
    private Date lastUpdateTime;
    @TableField(value="dcl.smart_home_device_smart_device_id_1")
    @JsonProperty("smart_home_device_smart_device_id_1")
    private Integer smartHomeDeviceSmartDeviceId1;
    @TableField(value="shd.device_name")
    @JsonProperty("device_name")
    private String deviceName;
    @TableField(value="ui.password")
    @JsonProperty("password")
    private String password;
    @TableField(value="shd.brightness")
    @JsonProperty("brightness")
    private Integer brightness;
    @TableField(value="dcl.device_control_log_id")
    @JsonProperty("device_control_log_id")
    private Integer deviceControlLogId;
    @TableField(value="shd.smart_device_status_enum_smart_device_status_enum_id_1")
    @JsonProperty("smart_device_status_enum_smart_device_status_enum_id_1")
    private Integer smartDeviceStatusEnumSmartDeviceStatusEnumId1;
    @TableField(value="dcl.action_value")
    @JsonProperty("action_value")
    private String actionValue;
    @TableField(value="ui.phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;
    @TableField(value="ui.username")
    @JsonProperty("username")
    private String username;










}
