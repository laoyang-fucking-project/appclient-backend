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
 * <p>物业请求</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyServiceRequestVO  extends BaseEntity {

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
