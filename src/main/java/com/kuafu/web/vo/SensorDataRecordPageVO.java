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
 * <p>传感器数据记录表-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SensorDataRecordPageVO extends BaseEntity {

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
