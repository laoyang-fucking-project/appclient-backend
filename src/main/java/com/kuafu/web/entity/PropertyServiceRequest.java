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
 * <p>  物业请求 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("property_service_request")
public class PropertyServiceRequest  {
    @TableId(value = "property_service_request_id", type = IdType.AUTO)
    @JsonProperty("property_service_request_id")
    
    
    
    private Integer propertyServiceRequestId;
    @JsonProperty("request_type_enum_request_type_enum_id_1")
    @IsNotNullField(description = "请求类型")
    
    
    @TableField("request_type_enum_request_type_enum_id_1")
    private Integer requestTypeEnumRequestTypeEnumId1;
    @JsonProperty("request_status_enum_request_status_enum_id_1")
    @IsNotNullField(description = "请求状态")
    
    
    @TableField("request_status_enum_request_status_enum_id_1")
    private Integer requestStatusEnumRequestStatusEnumId1;
    @JsonProperty("user_info_user_info_id_1")
    @IsNotNullField(description = "申请用户")
    
    
    @TableField("user_info_user_info_id_1")
    private Integer userInfoUserInfoId1;
    @JsonProperty("description")
    @IsNotNullField(description = "请求详情")
    
    
    @TableField("description")
    private String description;
    @JsonProperty("create_time")
    @TableField(fill = FieldFill.INSERT)
    
    
    private Date createTime;
    @JsonProperty("process_progress")
    
    
    @TableField("process_progress")
    private String processProgress;





}
