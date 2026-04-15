package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.SmartHomeDeviceAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  智能家居设备表 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
public interface ISmartHomeDeviceAllService extends IService<SmartHomeDeviceAll> {
        List<SmartHomeDeviceAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<SmartHomeDeviceAll> queryWrapper);
        List<SmartHomeDeviceAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<SmartHomeDeviceAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<SmartHomeDeviceAll> queryWrapper);

        IPage pageNew(IPage<SmartHomeDeviceAll> page, PageRequest pageRequest, LambdaQueryWrapper<SmartHomeDeviceAll> queryWrapper);
        }
