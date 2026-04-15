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
 * <p>设备告警记录表</p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceAlertRecordVO  extends BaseEntity {

    @JsonProperty("deviceAlertRecordId")
    private Integer deviceAlertRecordId;
    @JsonProperty("smartHomeDeviceSmartDeviceId1")
    private Integer smartHomeDeviceSmartDeviceId1;
    @JsonProperty("alertType")
    private String alertType;
    @JsonProperty("alertLevel")
    private String alertLevel;
    @JsonProperty("alertMessage")
    private String alertMessage;
    @JsonProperty("isResolved")
    private Integer isResolved;
    @JsonDeserialize(using = MultiDateDeserializer.class)
    @JsonProperty("createTime")
    private Date createTime;




}
