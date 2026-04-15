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
 * <p>安全预警</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityAlertVO  extends BaseEntity {

    @JsonProperty("securityAlertId")
    private Integer securityAlertId;
    @JsonProperty("alertTypeEnumAlertTypeEnumId1")
    private Integer alertTypeEnumAlertTypeEnumId1;
    @JsonProperty("alertLevelEnumAlertLevelEnumId1")
    private Integer alertLevelEnumAlertLevelEnumId1;
    @JsonProperty("alertStatusEnumAlertStatusEnumId1")
    private Integer alertStatusEnumAlertStatusEnumId1;
    @JsonProperty("description")
    private String description;
    @JsonProperty("reportUserInfoUserInfoId1")
    private Integer reportUserInfoUserInfoId1;
    @JsonProperty("processProgress")
    private String processProgress;
    @JsonDeserialize(using = MultiDateDeserializer.class)
    @JsonProperty("createTime")
    private Date createTime;




}
