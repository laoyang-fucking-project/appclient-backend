package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.kuafu.common.entity.StaticResource;
import java.util.List;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import com.kuafu.common.entity.BaseEntity;
/**
 * <p>用户</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO  extends BaseEntity {

    @JsonProperty("userInfoId")
    private Integer userInfoId;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("roleEnumRoleEnumId1")
    private Integer roleEnumRoleEnumId1;




}
