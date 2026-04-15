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
 * <p>  设备告警记录表 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("device_alert_record")
public class DeviceAlertRecord  {
    @TableId(value = "device_alert_record_id", type = IdType.AUTO)
    @JsonProperty("device_alert_record_id")
    
    
    
    private Integer deviceAlertRecordId;
    @JsonProperty("smart_home_device_smart_device_id_1")
    @IsNotNullField(description = "设备ID")
    
    
    @TableField("smart_home_device_smart_device_id_1")
    private Integer smartHomeDeviceSmartDeviceId1;
    @JsonProperty("alert_type")
    
    
    @TableField("alert_type")
    private String alertType;
    @JsonProperty("alert_level")
    
    
    @TableField("alert_level")
    private String alertLevel;
    @JsonProperty("alert_message")
    
    
    @TableField("alert_message")
    private String alertMessage;
    @JsonProperty("is_resolved")
    
    
    @TableField("is_resolved")
    private Integer isResolved;
    @JsonProperty("create_time")
    @TableField(fill = FieldFill.INSERT)
    
    
    private Date createTime;





}
