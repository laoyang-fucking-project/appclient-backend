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
 * <p>  设备状态 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("device_status")
public class DeviceStatus  {
    @TableId(value = "device_status_id", type = IdType.AUTO)
    @JsonProperty("device_status_id")
    
    
    
    private Integer deviceStatusId;
    @JsonProperty("device_name")
    @IsNotNullField(description = "设备名称")
    
    
    @TableField("device_name")
    private String deviceName;
    @JsonProperty("device_type_enum_device_type_enum_id_1")
    @IsNotNullField(description = "设备类型")
    
    
    @TableField("device_type_enum_device_type_enum_id_1")
    private Integer deviceTypeEnumDeviceTypeEnumId1;
    @JsonProperty("device_status_enum_device_status_enum_id_1")
    @IsNotNullField(description = "运行状态")
    
    
    @TableField("device_status_enum_device_status_enum_id_1")
    private Integer deviceStatusEnumDeviceStatusEnumId1;
    @JsonProperty("last_update_time")
    
    
    @TableField("last_update_time")
    private Date lastUpdateTime;





}
