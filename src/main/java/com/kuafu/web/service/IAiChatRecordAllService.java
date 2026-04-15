package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.AiChatRecordAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  AI问答 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
public interface IAiChatRecordAllService extends IService<AiChatRecordAll> {
        List<AiChatRecordAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<AiChatRecordAll> queryWrapper);
        List<AiChatRecordAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<AiChatRecordAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<AiChatRecordAll> queryWrapper);

        IPage pageNew(IPage<AiChatRecordAll> page, PageRequest pageRequest, LambdaQueryWrapper<AiChatRecordAll> queryWrapper);
        }
