package com.kuafu.web.vo;

import com.kuafu.common.domin.PageRequest;
import com.kuafu.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import com.kuafu.common.entity.StaticResource;

/**
 * <p>用户-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserInfoAllPageVO extends BaseEntity {

@JsonProperty("roleName")
    private String roleName;
@JsonProperty("password")
    private String password;
@JsonProperty("roleEnumRoleEnumId1")
    private Integer roleEnumRoleEnumId1;
@JsonProperty("phoneNumber")
    private String phoneNumber;
@JsonProperty("userInfoId")
    private Integer userInfoId;
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

    public long getCurrent() {
        return super.getCurrent();
    }

    public void setCurrent(long current) {
        super.setCurrent(current);
    }

    public long getPageSize() {
        return super.getPageSize();
    }

    public void setPageSize(long pageSize) {
        super.setPageSize(pageSize);
    }

}
