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
import com.kuafu.web.entity.RequestStatusEnum;
import com.kuafu.web.service.IRequestStatusEnumService;
import com.kuafu.web.vo.RequestStatusEnumPageVO;
import com.kuafu.web.vo.RequestStatusEnumVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 请求状态 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("RequestStatusEnumControllerService")
@RequiredArgsConstructor
public class RequestStatusEnumControllerService  {

    private final IRequestStatusEnumService requestStatusEnumService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( RequestStatusEnumPageVO pageVO){
        IPage<RequestStatusEnum> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<RequestStatusEnum> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<RequestStatusEnum> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(RequestStatusEnum::getRequestStatusEnumId);

            if(pageVO.getRequestStatusEnumId() != null){
                queryWrapper.eq(RequestStatusEnum::getRequestStatusEnumId, pageVO.getRequestStatusEnumId());
            }


        if(StringUtils.isNotEmpty(pageVO.getStatusName())) {
//                        queryWrapper.like(RequestStatusEnum::getStatusName, pageVO.getStatusName());
                        String s_string = pageVO.getStatusName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(RequestStatusEnum::getStatusName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

            return ResultUtils.success(requestStatusEnumService.page(page, queryWrapper));
        }


        public BaseResponse list(  RequestStatusEnumVO vo){
            LambdaQueryWrapper<RequestStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                            queryWrapper.like(RequestStatusEnum::getStatusName, vo.getStatusName());
                }
                return ResultUtils.success(requestStatusEnumService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  RequestStatusEnumVO vo) {
                RequestStatusEnum entity =  RequestStatusEnum.builder()
                    .statusName(vo.getStatusName())
                .build();








                boolean flag =this.requestStatusEnumService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("request_status_enum").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getRequestStatusEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( RequestStatusEnumVO vo) {
                RequestStatusEnum entity =  RequestStatusEnum.builder()
                    .requestStatusEnumId(vo.getRequestStatusEnumId())
                    .statusName(vo.getStatusName())
                .build();



                        boolean flag = this.requestStatusEnumService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getRequestStatusEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( RequestStatusEnumVO vo ) {
                RequestStatusEnum entity = this.requestStatusEnumService.getById(vo.getRequestStatusEnumId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( RequestStatusEnumVO vo) {
                boolean flag = this.requestStatusEnumService.removeById(vo.getRequestStatusEnumId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
