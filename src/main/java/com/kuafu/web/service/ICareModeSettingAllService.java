package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.CareModeSettingAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  关怀模式 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
public interface ICareModeSettingAllService extends IService<CareModeSettingAll> {
        List<CareModeSettingAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<CareModeSettingAll> queryWrapper);
        List<CareModeSettingAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<CareModeSettingAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<CareModeSettingAll> queryWrapper);

        IPage pageNew(IPage<CareModeSettingAll> page, PageRequest pageRequest, LambdaQueryWrapper<CareModeSettingAll> queryWrapper);
        }
