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
import com.kuafu.web.entity.AlertStatusEnum;
import com.kuafu.web.service.IAlertStatusEnumService;
import com.kuafu.web.vo.AlertStatusEnumPageVO;
import com.kuafu.web.vo.AlertStatusEnumVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 预警状态 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("AlertStatusEnumControllerService")
@RequiredArgsConstructor
public class AlertStatusEnumControllerService  {

    private final IAlertStatusEnumService alertStatusEnumService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( AlertStatusEnumPageVO pageVO){
        IPage<AlertStatusEnum> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<AlertStatusEnum> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<AlertStatusEnum> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(AlertStatusEnum::getAlertStatusEnumId);

            if(pageVO.getAlertStatusEnumId() != null){
                queryWrapper.eq(AlertStatusEnum::getAlertStatusEnumId, pageVO.getAlertStatusEnumId());
            }


        if(StringUtils.isNotEmpty(pageVO.getStatusName())) {
//                        queryWrapper.like(AlertStatusEnum::getStatusName, pageVO.getStatusName());
                        String s_string = pageVO.getStatusName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(AlertStatusEnum::getStatusName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

            return ResultUtils.success(alertStatusEnumService.page(page, queryWrapper));
        }


        public BaseResponse list(  AlertStatusEnumVO vo){
            LambdaQueryWrapper<AlertStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                            queryWrapper.like(AlertStatusEnum::getStatusName, vo.getStatusName());
                }
                return ResultUtils.success(alertStatusEnumService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  AlertStatusEnumVO vo) {
                AlertStatusEnum entity =  AlertStatusEnum.builder()
                    .statusName(vo.getStatusName())
                .build();








                boolean flag =this.alertStatusEnumService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("alert_status_enum").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getAlertStatusEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( AlertStatusEnumVO vo) {
                AlertStatusEnum entity =  AlertStatusEnum.builder()
                    .alertStatusEnumId(vo.getAlertStatusEnumId())
                    .statusName(vo.getStatusName())
                .build();



                        boolean flag = this.alertStatusEnumService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getAlertStatusEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( AlertStatusEnumVO vo ) {
                AlertStatusEnum entity = this.alertStatusEnumService.getById(vo.getAlertStatusEnumId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( AlertStatusEnumVO vo) {
                boolean flag = this.alertStatusEnumService.removeById(vo.getAlertStatusEnumId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
