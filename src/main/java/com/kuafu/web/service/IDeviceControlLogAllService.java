package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.DeviceControlLogAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  设备控制记录表 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
public interface IDeviceControlLogAllService extends IService<DeviceControlLogAll> {
        List<DeviceControlLogAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<DeviceControlLogAll> queryWrapper);
        List<DeviceControlLogAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<DeviceControlLogAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<DeviceControlLogAll> queryWrapper);

        IPage pageNew(IPage<DeviceControlLogAll> page, PageRequest pageRequest, LambdaQueryWrapper<DeviceControlLogAll> queryWrapper);
        }
