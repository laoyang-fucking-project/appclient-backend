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
 * <p>物业请求-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PropertyServiceRequestAllPageVO extends BaseEntity {

@JsonProperty("typeName")
    private String typeName;
@JsonProperty("userInfoUserInfoId1")
    private Integer userInfoUserInfoId1;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("createTime")
    private Date createTime;
@JsonProperty("requestStatusEnumRequestStatusEnumId1")
    private Integer requestStatusEnumRequestStatusEnumId1;
@JsonProperty("statusName")
    private String statusName;
@JsonProperty("propertyServiceRequestId")
    private Integer propertyServiceRequestId;
@JsonProperty("description")
    private String description;
@JsonProperty("roleEnumRoleEnumId1")
    private Integer roleEnumRoleEnumId1;
@JsonProperty("password")
    private String password;
@JsonProperty("requestTypeEnumRequestTypeEnumId1")
    private Integer requestTypeEnumRequestTypeEnumId1;
@JsonProperty("phoneNumber")
    private String phoneNumber;
@JsonProperty("processProgress")
    private String processProgress;
@JsonProperty("username")
    private String username;

}
