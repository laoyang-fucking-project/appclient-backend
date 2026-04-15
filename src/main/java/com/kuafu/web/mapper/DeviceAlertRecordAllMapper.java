package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.DeviceAlertRecordAll;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * <p> 设备告警记录表 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Mapper
public interface DeviceAlertRecordAllMapper extends BaseMapper<DeviceAlertRecordAll> {
    public List<DeviceAlertRecordAll> selectListNew(@Param("ew") Wrapper<DeviceAlertRecordAll> queryWrapper);
}
