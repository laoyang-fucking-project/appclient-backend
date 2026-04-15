package com.kuafu.web.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * <p>  设备状态 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceStatusAll {
    @TableField(value="ds.last_update_time")
    @JsonProperty("last_update_time")
    private Date lastUpdateTime;
    @TableField(value="ds.device_status_id")
    @JsonProperty("device_status_id")
    private Integer deviceStatusId;
    @TableField(value="ds.device_name")
    @JsonProperty("device_name")
    private String deviceName;
    @TableField(value="dte.type_name")
    @JsonProperty("type_name")
    private String typeName;
    @TableField(value="dse.status_name")
    @JsonProperty("status_name")
    private String statusName;
    @TableField(value="ds.device_type_enum_device_type_enum_id_1")
    @JsonProperty("device_type_enum_device_type_enum_id_1")
    private Integer deviceTypeEnumDeviceTypeEnumId1;
    @TableField(value="ds.device_status_enum_device_status_enum_id_1")
    @JsonProperty("device_status_enum_device_status_enum_id_1")
    private Integer deviceStatusEnumDeviceStatusEnumId1;










}
