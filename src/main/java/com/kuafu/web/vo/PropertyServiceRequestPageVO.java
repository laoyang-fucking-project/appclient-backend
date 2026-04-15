package com.kuafu.web.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import com.kuafu.common.domin.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.kuafu.common.entity.BaseEntity;
/**
 * <p>物业请求-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PropertyServiceRequestPageVO extends BaseEntity {

@JsonProperty("propertyServiceRequestId")
    private Integer propertyServiceRequestId;
@JsonProperty("requestTypeEnumRequestTypeEnumId1")
    private Integer requestTypeEnumRequestTypeEnumId1;
@JsonProperty("requestStatusEnumRequestStatusEnumId1")
    private Integer requestStatusEnumRequestStatusEnumId1;
@JsonProperty("userInfoUserInfoId1")
    private Integer userInfoUserInfoId1;
@JsonProperty("description")
    private String description;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("createTime")
    private Date createTime;
@JsonProperty("processProgress")
    private String processProgress;


}
