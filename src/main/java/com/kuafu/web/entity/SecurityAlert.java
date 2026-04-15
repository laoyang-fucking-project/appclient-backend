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
 * <p>  安全预警 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("security_alert")
public class SecurityAlert  {
    @TableId(value = "security_alert_id", type = IdType.AUTO)
    @JsonProperty("security_alert_id")
    
    
    
    private Integer securityAlertId;
    @JsonProperty("alert_type_enum_alert_type_enum_id_1")
    @IsNotNullField(description = "预警类型")
    
    
    @TableField("alert_type_enum_alert_type_enum_id_1")
    private Integer alertTypeEnumAlertTypeEnumId1;
    @JsonProperty("alert_level_enum_alert_level_enum_id_1")
    @IsNotNullField(description = "预警等级")
    
    
    @TableField("alert_level_enum_alert_level_enum_id_1")
    private Integer alertLevelEnumAlertLevelEnumId1;
    @JsonProperty("alert_status_enum_alert_status_enum_id_1")
    @IsNotNullField(description = "预警状态")
    
    
    @TableField("alert_status_enum_alert_status_enum_id_1")
    private Integer alertStatusEnumAlertStatusEnumId1;
    @JsonProperty("description")
    
    
    @TableField("description")
    private String description;
    @JsonProperty("report_user_info_user_info_id_1")
    @IsNotNullField(description = "上报用户")
    
    
    @TableField("report_user_info_user_info_id_1")
    private Integer reportUserInfoUserInfoId1;
    @JsonProperty("process_progress")
    
    
    @TableField("process_progress")
    private String processProgress;
    @JsonProperty("create_time")
    @TableField(fill = FieldFill.INSERT)
    
    
    private Date createTime;





}
