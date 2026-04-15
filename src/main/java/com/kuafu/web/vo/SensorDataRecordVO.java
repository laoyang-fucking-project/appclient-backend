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
 * <p>传感器数据记录表</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorDataRecordVO  extends BaseEntity {

    @JsonProperty("sensorDataRecordId")
    private Integer sensorDataRecordId;
    @JsonProperty("smartHomeDeviceSmartDeviceId1")
    private Integer smartHomeDeviceSmartDeviceId1;
    @JsonProperty("sensorValue")
    private String sensorValue;
    @JsonDeserialize(using = MultiDateDeserializer.class)
    @JsonProperty("recordTime")
    private Date recordTime;




}
