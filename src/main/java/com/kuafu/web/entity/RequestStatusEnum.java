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
 * <p>  请求状态 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("request_status_enum")
public class RequestStatusEnum  {
    @TableId(value = "request_status_enum_id", type = IdType.AUTO)
    @JsonProperty("request_status_enum_id")
    
    
    
    private Integer requestStatusEnumId;
    @JsonProperty("status_name")
    @IsNotNullField(description = "状态名")
    
    
    @TableField("status_name")
    private String statusName;





}
