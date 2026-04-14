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
public class UserInfoAll {
    @TableField(value="re.role_name")
    @JsonProperty("role_name")
    private String roleName;
    @TableField(value="ui.password")
    @JsonProperty("password")
    private String password;
    @TableField(value="ui.role_enum_role_enum_id_1")
    @JsonProperty("role_enum_role_enum_id_1")
    private Integer roleEnumRoleEnumId1;
    @TableField(value="ui.phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;
    @TableField(value="ui.user_info_id")
    @JsonProperty("user_info_id")
    private Integer userInfoId;
    @TableField(value="ui.username")
    @JsonProperty("username")
    private String username;










}
