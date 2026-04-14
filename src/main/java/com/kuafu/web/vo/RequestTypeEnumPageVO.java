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
 * <p>请求类型-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RequestTypeEnumPageVO extends BaseEntity {

@JsonProperty("requestTypeEnumId")
    private Integer requestTypeEnumId;
@JsonProperty("typeName")
    private String typeName;


}
