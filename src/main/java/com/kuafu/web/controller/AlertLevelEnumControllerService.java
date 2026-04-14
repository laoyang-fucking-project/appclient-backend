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
import com.kuafu.web.entity.AlertLevelEnum;
import com.kuafu.web.service.IAlertLevelEnumService;
import com.kuafu.web.vo.AlertLevelEnumPageVO;
import com.kuafu.web.vo.AlertLevelEnumVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 预警等级 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("AlertLevelEnumControllerService")
@RequiredArgsConstructor
public class AlertLevelEnumControllerService  {

    private final IAlertLevelEnumService alertLevelEnumService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( AlertLevelEnumPageVO pageVO){
        IPage<AlertLevelEnum> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<AlertLevelEnum> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<AlertLevelEnum> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(AlertLevelEnum::getAlertLevelEnumId);

            if(pageVO.getAlertLevelEnumId() != null){
                queryWrapper.eq(AlertLevelEnum::getAlertLevelEnumId, pageVO.getAlertLevelEnumId());
            }


        if(StringUtils.isNotEmpty(pageVO.getLevelName())) {
//                        queryWrapper.like(AlertLevelEnum::getLevelName, pageVO.getLevelName());
                        String s_string = pageVO.getLevelName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(AlertLevelEnum::getLevelName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

            return ResultUtils.success(alertLevelEnumService.page(page, queryWrapper));
        }


        public BaseResponse list(  AlertLevelEnumVO vo){
            LambdaQueryWrapper<AlertLevelEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getLevelName())) {
                            queryWrapper.like(AlertLevelEnum::getLevelName, vo.getLevelName());
                }
                return ResultUtils.success(alertLevelEnumService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  AlertLevelEnumVO vo) {
                AlertLevelEnum entity =  AlertLevelEnum.builder()
                    .levelName(vo.getLevelName())
                .build();








                boolean flag =this.alertLevelEnumService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("alert_level_enum").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getAlertLevelEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( AlertLevelEnumVO vo) {
                AlertLevelEnum entity =  AlertLevelEnum.builder()
                    .alertLevelEnumId(vo.getAlertLevelEnumId())
                    .levelName(vo.getLevelName())
                .build();



                        boolean flag = this.alertLevelEnumService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getAlertLevelEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( AlertLevelEnumVO vo ) {
                AlertLevelEnum entity = this.alertLevelEnumService.getById(vo.getAlertLevelEnumId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( AlertLevelEnumVO vo) {
                boolean flag = this.alertLevelEnumService.removeById(vo.getAlertLevelEnumId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
