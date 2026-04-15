package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.DeviceAlertRecordAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  设备告警记录表 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
public interface IDeviceAlertRecordAllService extends IService<DeviceAlertRecordAll> {
        List<DeviceAlertRecordAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<DeviceAlertRecordAll> queryWrapper);
        List<DeviceAlertRecordAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<DeviceAlertRecordAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<DeviceAlertRecordAll> queryWrapper);

        IPage pageNew(IPage<DeviceAlertRecordAll> page, PageRequest pageRequest, LambdaQueryWrapper<DeviceAlertRecordAll> queryWrapper);
        }
