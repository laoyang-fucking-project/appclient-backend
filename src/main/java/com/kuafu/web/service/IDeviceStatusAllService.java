package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.DeviceStatusAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  设备状态 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
public interface IDeviceStatusAllService extends IService<DeviceStatusAll> {
        List<DeviceStatusAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<DeviceStatusAll> queryWrapper);
        List<DeviceStatusAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<DeviceStatusAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<DeviceStatusAll> queryWrapper);

        IPage pageNew(IPage<DeviceStatusAll> page, PageRequest pageRequest, LambdaQueryWrapper<DeviceStatusAll> queryWrapper);
        }
