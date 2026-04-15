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
 * <p>  设备类型 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("device_type_enum")
public class DeviceTypeEnum  {
    @TableId(value = "device_type_enum_id", type = IdType.AUTO)
    @JsonProperty("device_type_enum_id")
    
    
    
    private Integer deviceTypeEnumId;
    @JsonProperty("type_name")
    @IsNotNullField(description = "类型名")
    
    
    @TableField("type_name")
    private String typeName;





}
