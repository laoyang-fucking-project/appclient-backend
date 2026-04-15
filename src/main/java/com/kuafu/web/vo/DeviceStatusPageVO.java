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
 * <p>设备状态-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DeviceStatusPageVO extends BaseEntity {

@JsonProperty("deviceStatusId")
    private Integer deviceStatusId;
@JsonProperty("deviceName")
    private String deviceName;
@JsonProperty("deviceTypeEnumDeviceTypeEnumId1")
    private Integer deviceTypeEnumDeviceTypeEnumId1;
@JsonProperty("deviceStatusEnumDeviceStatusEnumId1")
    private Integer deviceStatusEnumDeviceStatusEnumId1;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("lastUpdateTime")
    private Date lastUpdateTime;


}
