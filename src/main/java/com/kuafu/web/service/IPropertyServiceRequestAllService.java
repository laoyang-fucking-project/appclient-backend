package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.PropertyServiceRequestAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  物业请求 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
public interface IPropertyServiceRequestAllService extends IService<PropertyServiceRequestAll> {
        List<PropertyServiceRequestAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper);
        List<PropertyServiceRequestAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper);

        IPage pageNew(IPage<PropertyServiceRequestAll> page, PageRequest pageRequest, LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper);
        }
