package com.kuafu.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import java.io.Serializable;
import com.kuafu.common.login.IControllerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.kuafu.login.annotation.*;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.AiChatRecordAll;
import com.kuafu.web.service.IAiChatRecordAllService;
import com.kuafu.web.vo.AiChatRecordAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> AI问答 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("AiChatRecordAllControllerService")
public class AiChatRecordAllControllerService implements IControllerService<AiChatRecordAll> {


@Autowired
    private  IAiChatRecordAllService aiChatRecordAllService;








    public BaseResponse page( AiChatRecordAllPageVO pageVO){
        IPage<AiChatRecordAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<AiChatRecordAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("acr.ai_chat_record_id");
        LambdaQueryWrapper<AiChatRecordAll> queryWrapper = objectQueryWrapper.lambda();


        if(StringUtils.isNotEmpty(pageVO.getQuestionText())) {
                queryWrapper.like(AiChatRecordAll::getQuestionText, pageVO.getQuestionText());
            }
        if(StringUtils.isNotEmpty(pageVO.getAnswerText())) {
                queryWrapper.like(AiChatRecordAll::getAnswerText, pageVO.getAnswerText());
            }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
                queryWrapper.like(AiChatRecordAll::getPassword, pageVO.getPassword());
            }
            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(AiChatRecordAll::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }
            if(pageVO.getCreateTime() != null){
                queryWrapper.eq(AiChatRecordAll::getCreateTime, pageVO.getCreateTime());
            }
            if(pageVO.getRoleEnumRoleEnumId1() != null){
                queryWrapper.eq(AiChatRecordAll::getRoleEnumRoleEnumId1, pageVO.getRoleEnumRoleEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getAudioUrl())) {
                queryWrapper.like(AiChatRecordAll::getAudioUrl, pageVO.getAudioUrl());
            }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
                queryWrapper.like(AiChatRecordAll::getPhoneNumber, pageVO.getPhoneNumber());
            }
            if(pageVO.getAiChatRecordId() != null){
                queryWrapper.eq(AiChatRecordAll::getAiChatRecordId, pageVO.getAiChatRecordId());
            }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {

                        String s_string = pageVO.getUsername();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(AiChatRecordAll::getUsername, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

                    aiChatRecordAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(AiChatRecordAllPageVO vo){
            LambdaQueryWrapper<AiChatRecordAll> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getQuestionText())) {
                    queryWrapper.eq(AiChatRecordAll::getQuestionText, vo.getQuestionText());
                }
            if(StringUtils.isNotEmpty(vo.getAnswerText())) {
                    queryWrapper.eq(AiChatRecordAll::getAnswerText, vo.getAnswerText());
                }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
                    queryWrapper.eq(AiChatRecordAll::getPassword, vo.getPassword());
                }
                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(AiChatRecordAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
                if(vo.getCreateTime() != null){
                    queryWrapper.eq(AiChatRecordAll::getCreateTime, vo.getCreateTime());
                }
                if(vo.getRoleEnumRoleEnumId1() != null){
                    queryWrapper.eq(AiChatRecordAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getAudioUrl())) {
                    queryWrapper.eq(AiChatRecordAll::getAudioUrl, vo.getAudioUrl());
                }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                    queryWrapper.eq(AiChatRecordAll::getPhoneNumber, vo.getPhoneNumber());
                }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
                            queryWrapper.like(AiChatRecordAll::getUsername, vo.getUsername());
                }
                return ResultUtils.success(aiChatRecordAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(AiChatRecordAllPageVO vo) {


                LambdaQueryWrapper<AiChatRecordAll> queryWrapper = new LambdaQueryWrapper<>();


                            if(StringUtils.isNotEmpty(vo.getQuestionText())) {
                                    queryWrapper.eq(AiChatRecordAll::getQuestionText, vo.getQuestionText());
                                }


                            if(StringUtils.isNotEmpty(vo.getAnswerText())) {
                                    queryWrapper.eq(AiChatRecordAll::getAnswerText, vo.getAnswerText());
                                }


                            if(StringUtils.isNotEmpty(vo.getPassword())) {
                                    queryWrapper.eq(AiChatRecordAll::getPassword, vo.getPassword());
                                }


                                if(vo.getUserInfoUserInfoId1() != null){
                                    queryWrapper.eq(AiChatRecordAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                                }


                                if(vo.getCreateTime() != null){
                                    queryWrapper.eq(AiChatRecordAll::getCreateTime, vo.getCreateTime());
                                }


                                if(vo.getRoleEnumRoleEnumId1() != null){
                                    queryWrapper.eq(AiChatRecordAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getAudioUrl())) {
                                    queryWrapper.eq(AiChatRecordAll::getAudioUrl, vo.getAudioUrl());
                                }


                            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                                    queryWrapper.eq(AiChatRecordAll::getPhoneNumber, vo.getPhoneNumber());
                                }


                                if(vo.getAiChatRecordId() != null){
                                    queryWrapper.eq(AiChatRecordAll::getAiChatRecordId, vo.getAiChatRecordId());
                                }


                            if(StringUtils.isNotEmpty(vo.getUsername())) {
                                            queryWrapper.like(AiChatRecordAll::getUsername, vo.getUsername());
                                }

                // AiChatRecordAll entity = this.aiChatRecordAllService.getById(aiChatRecordId);
                    final Page<AiChatRecordAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    aiChatRecordAllService.pageNew(page, vo, queryWrapper);
                    final List<AiChatRecordAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public AiChatRecordAll getById(Serializable aiChatRecordId) {

                    LambdaQueryWrapper<AiChatRecordAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(AiChatRecordAll::getAiChatRecordId, aiChatRecordId);

                    final Page<AiChatRecordAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    aiChatRecordAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<AiChatRecordAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
