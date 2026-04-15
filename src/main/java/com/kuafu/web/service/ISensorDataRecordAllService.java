package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.SensorDataRecordAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  传感器数据记录表 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
public interface ISensorDataRecordAllService extends IService<SensorDataRecordAll> {
        List<SensorDataRecordAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<SensorDataRecordAll> queryWrapper);
        List<SensorDataRecordAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<SensorDataRecordAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<SensorDataRecordAll> queryWrapper);

        IPage pageNew(IPage<SensorDataRecordAll> page, PageRequest pageRequest, LambdaQueryWrapper<SensorDataRecordAll> queryWrapper);
        }
