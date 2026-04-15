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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleEnumRoleEnumId1() {
        return roleEnumRoleEnumId1;
    }

    public void setRoleEnumRoleEnumId1(Integer roleEnumRoleEnumId1) {
        this.roleEnumRoleEnumId1 = roleEnumRoleEnumId1;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }










}
