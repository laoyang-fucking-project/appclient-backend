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
 * <p>  物业请求 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyServiceRequestAll {
    @TableField(value="rte.type_name")
    @JsonProperty("type_name")
    private String typeName;
    @TableField(value="psr.user_info_user_info_id_1")
    @JsonProperty("user_info_user_info_id_1")
    private Integer userInfoUserInfoId1;
    @TableField(value="psr.create_time")
    @JsonProperty("create_time")
    private Date createTime;
    @TableField(value="psr.request_status_enum_request_status_enum_id_1")
    @JsonProperty("request_status_enum_request_status_enum_id_1")
    private Integer requestStatusEnumRequestStatusEnumId1;
    @TableField(value="rse.status_name")
    @JsonProperty("status_name")
    private String statusName;
    @TableField(value="psr.property_service_request_id")
    @JsonProperty("property_service_request_id")
    private Integer propertyServiceRequestId;
    @TableField(value="psr.description")
    @JsonProperty("description")
    private String description;
    @TableField(value="ui.role_enum_role_enum_id_1")
    @JsonProperty("role_enum_role_enum_id_1")
    private Integer roleEnumRoleEnumId1;
    @TableField(value="ui.password")
    @JsonProperty("password")
    private String password;
    @TableField(value="psr.request_type_enum_request_type_enum_id_1")
    @JsonProperty("request_type_enum_request_type_enum_id_1")
    private Integer requestTypeEnumRequestTypeEnumId1;
    @TableField(value="ui.phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;
    @TableField(value="psr.process_progress")
    @JsonProperty("process_progress")
    private String processProgress;
    @TableField(value="ui.username")
    @JsonProperty("username")
    private String username;










}
