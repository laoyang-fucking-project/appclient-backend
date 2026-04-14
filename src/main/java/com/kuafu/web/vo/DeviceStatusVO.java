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
 * <p>设备状态</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceStatusVO  extends BaseEntity {

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
