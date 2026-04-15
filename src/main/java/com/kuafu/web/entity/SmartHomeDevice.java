package com.kuafu.web.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.*;
import com.kuafu.common.entity.StaticResource;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kuafu.web.annotation.IsNotNullField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import com.kuafu.common.annotation.*;
/**
 * <p>  智能家居设备表 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("smart_home_device")
public class SmartHomeDevice  {
    @TableId(value = "smart_device_id", type = IdType.AUTO)
    @JsonProperty("smart_device_id")
    
    
    
    private Integer smartDeviceId;
    @JsonProperty("device_name")
    @IsNotNullField(description = "设备名称")
    
    
    @TableField("device_name")
    private String deviceName;
    @JsonProperty("smart_device_type_enum_smart_device_type_enum_id_1")
    @IsNotNullField(description = "设备类型")
    
    
    @TableField("smart_device_type_enum_smart_device_type_enum_id_1")
    private Integer smartDeviceTypeEnumSmartDeviceTypeEnumId1;
    @JsonProperty("smart_device_status_enum_smart_device_status_enum_id_1")
    @IsNotNullField(description = "设备状态")
    
    
    @TableField("smart_device_status_enum_smart_device_status_enum_id_1")
    private Integer smartDeviceStatusEnumSmartDeviceStatusEnumId1;
    @JsonProperty("room_name")
    @IsNotNullField(description = "所属房间")
    
    
    @TableField("room_name")
    private String roomName;
    @JsonProperty("current_value")
    
    
    @TableField("current_value")
    private String currentValue;
    @JsonProperty("is_on")
    
    
    @TableField("is_on")
    private Integer isOn;
    @JsonProperty("brightness")
    
    
    @TableField("brightness")
    private Integer brightness;
    @JsonProperty("last_update_time")
    
    
    @TableField("last_update_time")
    private Date lastUpdateTime;
    @JsonProperty("user_info_user_info_id_1")
    @IsNotNullField(description = "所属用户")
    
    
    @TableField("user_info_user_info_id_1")
    private Integer userInfoUserInfoId1;





}
