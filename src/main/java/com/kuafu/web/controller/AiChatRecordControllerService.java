package com.kuafu.web.controller;

import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.kuafu.common.resource.service.IStaticResourceService;
import com.kuafu.common.event.EventVo;
import com.kuafu.common.event.MyEventService;
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
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.transaction.support.TransactionTemplate;
import com.kuafu.common.sensitive.SensitiveFilter;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.AiChatRecord;
import com.kuafu.web.service.IAiChatRecordService;
import com.kuafu.web.vo.AiChatRecordPageVO;
import com.kuafu.web.vo.AiChatRecordVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> AI问答 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("AiChatRecordControllerService")
@RequiredArgsConstructor
public class AiChatRecordControllerService  {

    private final IAiChatRecordService aiChatRecordService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( AiChatRecordPageVO pageVO){
        IPage<AiChatRecord> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<AiChatRecord> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<AiChatRecord> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(AiChatRecord::getAiChatRecordId);

            if(pageVO.getAiChatRecordId() != null){
                queryWrapper.eq(AiChatRecord::getAiChatRecordId, pageVO.getAiChatRecordId());
            }


            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(AiChatRecord::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }


        if(StringUtils.isNotEmpty(pageVO.getQuestionText())) {
                queryWrapper.eq(AiChatRecord::getQuestionText, pageVO.getQuestionText());
            }


        if(StringUtils.isNotEmpty(pageVO.getAnswerText())) {
                queryWrapper.eq(AiChatRecord::getAnswerText, pageVO.getAnswerText());
            }


        if(StringUtils.isNotEmpty(pageVO.getAudioUrl())) {
                queryWrapper.eq(AiChatRecord::getAudioUrl, pageVO.getAudioUrl());
            }


            if(pageVO.getCreateTime() != null){
                queryWrapper.eq(AiChatRecord::getCreateTime, pageVO.getCreateTime());
            }

            return ResultUtils.success(aiChatRecordService.page(page, queryWrapper));
        }


        public BaseResponse list(  AiChatRecordVO vo){
            LambdaQueryWrapper<AiChatRecord> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(AiChatRecord::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
            if(StringUtils.isNotEmpty(vo.getQuestionText())) {
                    queryWrapper.eq(AiChatRecord::getQuestionText, vo.getQuestionText());
                }
            if(StringUtils.isNotEmpty(vo.getAnswerText())) {
                    queryWrapper.eq(AiChatRecord::getAnswerText, vo.getAnswerText());
                }
            if(StringUtils.isNotEmpty(vo.getAudioUrl())) {
                    queryWrapper.eq(AiChatRecord::getAudioUrl, vo.getAudioUrl());
                }
                if(vo.getCreateTime() != null){
                    queryWrapper.eq(AiChatRecord::getCreateTime, vo.getCreateTime());
                }
                return ResultUtils.success(aiChatRecordService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  AiChatRecordVO vo) {
                AiChatRecord entity =  AiChatRecord.builder()
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .questionText(vo.getQuestionText())
                    .answerText(vo.getAnswerText())
                    .audioUrl(vo.getAudioUrl())
                .build();








                boolean flag =this.aiChatRecordService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("ai_chat_record").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getAiChatRecordId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( AiChatRecordVO vo) {
                AiChatRecord entity =  AiChatRecord.builder()
                    .aiChatRecordId(vo.getAiChatRecordId())
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .questionText(vo.getQuestionText())
                    .answerText(vo.getAnswerText())
                    .audioUrl(vo.getAudioUrl())
                .build();



                        boolean flag = this.aiChatRecordService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getAiChatRecordId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( AiChatRecordVO vo ) {
                AiChatRecord entity = this.aiChatRecordService.getById(vo.getAiChatRecordId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( AiChatRecordVO vo) {
                boolean flag = this.aiChatRecordService.removeById(vo.getAiChatRecordId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
