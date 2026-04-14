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
 * <p>安全预警-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SecurityAlertPageVO extends BaseEntity {

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
