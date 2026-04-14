package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.SecurityAlertAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  安全预警 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
public interface ISecurityAlertAllService extends IService<SecurityAlertAll> {
        List<SecurityAlertAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<SecurityAlertAll> queryWrapper);
        List<SecurityAlertAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<SecurityAlertAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<SecurityAlertAll> queryWrapper);

        IPage pageNew(IPage<SecurityAlertAll> page, PageRequest pageRequest, LambdaQueryWrapper<SecurityAlertAll> queryWrapper);
        }
