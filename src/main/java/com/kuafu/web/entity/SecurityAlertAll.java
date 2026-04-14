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
 * <p>  安全预警 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecurityAlertAll {
    @TableField(value="sa.alert_status_enum_alert_status_enum_id_1")
    @JsonProperty("alert_status_enum_alert_status_enum_id_1")
    private Integer alertStatusEnumAlertStatusEnumId1;
    @TableField(value="ate.type_name")
    @JsonProperty("type_name")
    private String typeName;
    @TableField(value="sa.create_time")
    @JsonProperty("create_time")
    private Date createTime;
    @TableField(value="ase.status_name")
    @JsonProperty("status_name")
    private String statusName;
    @TableField(value="sa.description")
    @JsonProperty("description")
    private String description;
    @TableField(value="ui.role_enum_role_enum_id_1")
    @JsonProperty("role_enum_role_enum_id_1")
    private Integer roleEnumRoleEnumId1;
    @TableField(value="sa.security_alert_id")
    @JsonProperty("security_alert_id")
    private Integer securityAlertId;
    @TableField(value="sa.report_user_info_user_info_id_1")
    @JsonProperty("report_user_info_user_info_id_1")
    private Integer reportUserInfoUserInfoId1;
    @TableField(value="sa.alert_level_enum_alert_level_enum_id_1")
    @JsonProperty("alert_level_enum_alert_level_enum_id_1")
    private Integer alertLevelEnumAlertLevelEnumId1;
    @TableField(value="ui.password")
    @JsonProperty("password")
    private String password;
    @TableField(value="ale.level_name")
    @JsonProperty("level_name")
    private String levelName;
    @TableField(value="sa.alert_type_enum_alert_type_enum_id_1")
    @JsonProperty("alert_type_enum_alert_type_enum_id_1")
    private Integer alertTypeEnumAlertTypeEnumId1;
    @TableField(value="ui.phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;
    @TableField(value="sa.process_progress")
    @JsonProperty("process_progress")
    private String processProgress;
    @TableField(value="ui.username")
    @JsonProperty("username")
    private String username;










}
