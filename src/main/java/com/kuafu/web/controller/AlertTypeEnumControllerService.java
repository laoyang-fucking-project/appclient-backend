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
import com.kuafu.web.entity.AlertTypeEnum;
import com.kuafu.web.service.IAlertTypeEnumService;
import com.kuafu.web.vo.AlertTypeEnumPageVO;
import com.kuafu.web.vo.AlertTypeEnumVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 预警类型 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("AlertTypeEnumControllerService")
@RequiredArgsConstructor
public class AlertTypeEnumControllerService  {

    private final IAlertTypeEnumService alertTypeEnumService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( AlertTypeEnumPageVO pageVO){
        IPage<AlertTypeEnum> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<AlertTypeEnum> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<AlertTypeEnum> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(AlertTypeEnum::getAlertTypeEnumId);

            if(pageVO.getAlertTypeEnumId() != null){
                queryWrapper.eq(AlertTypeEnum::getAlertTypeEnumId, pageVO.getAlertTypeEnumId());
            }


        if(StringUtils.isNotEmpty(pageVO.getTypeName())) {
//                        queryWrapper.like(AlertTypeEnum::getTypeName, pageVO.getTypeName());
                        String s_string = pageVO.getTypeName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(AlertTypeEnum::getTypeName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

            return ResultUtils.success(alertTypeEnumService.page(page, queryWrapper));
        }


        public BaseResponse list(  AlertTypeEnumVO vo){
            LambdaQueryWrapper<AlertTypeEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                            queryWrapper.like(AlertTypeEnum::getTypeName, vo.getTypeName());
                }
                return ResultUtils.success(alertTypeEnumService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  AlertTypeEnumVO vo) {
                AlertTypeEnum entity =  AlertTypeEnum.builder()
                    .typeName(vo.getTypeName())
                .build();








                boolean flag =this.alertTypeEnumService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("alert_type_enum").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getAlertTypeEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( AlertTypeEnumVO vo) {
                AlertTypeEnum entity =  AlertTypeEnum.builder()
                    .alertTypeEnumId(vo.getAlertTypeEnumId())
                    .typeName(vo.getTypeName())
                .build();



                        boolean flag = this.alertTypeEnumService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getAlertTypeEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( AlertTypeEnumVO vo ) {
                AlertTypeEnum entity = this.alertTypeEnumService.getById(vo.getAlertTypeEnumId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( AlertTypeEnumVO vo) {
                boolean flag = this.alertTypeEnumService.removeById(vo.getAlertTypeEnumId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
