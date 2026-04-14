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
 * <p>  用户 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_info")
public class UserInfo  {
    @TableId(value = "user_info_id", type = IdType.AUTO)
    @JsonProperty("user_info_id")
    
    
    
    private Integer userInfoId;
    @JsonProperty("phone_number")
    @IsNotNullField(description = "手机号")
    
    
    @TableField("phone_number")
    private String phoneNumber;
    @JsonProperty("username")
    
    
    @TableField("username")
    private String username;
    @JsonProperty("password")
    
    
    @TableField("password")
    private String password;
    @JsonProperty("role_enum_role_enum_id_1")
    @IsNotNullField(description = "角色")
    
    
    @TableField("role_enum_role_enum_id_1")
    private Integer roleEnumRoleEnumId1;





}
