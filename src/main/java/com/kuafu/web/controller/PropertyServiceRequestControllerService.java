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
import com.kuafu.web.entity.PropertyServiceRequest;
import com.kuafu.web.service.IPropertyServiceRequestService;
import com.kuafu.web.vo.PropertyServiceRequestPageVO;
import com.kuafu.web.vo.PropertyServiceRequestVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 物业请求 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("PropertyServiceRequestControllerService")
@RequiredArgsConstructor
public class PropertyServiceRequestControllerService  {

    private final IPropertyServiceRequestService propertyServiceRequestService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( PropertyServiceRequestPageVO pageVO){
        IPage<PropertyServiceRequest> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<PropertyServiceRequest> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<PropertyServiceRequest> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(PropertyServiceRequest::getPropertyServiceRequestId);

            if(pageVO.getPropertyServiceRequestId() != null){
                queryWrapper.eq(PropertyServiceRequest::getPropertyServiceRequestId, pageVO.getPropertyServiceRequestId());
            }


            if(pageVO.getRequestTypeEnumRequestTypeEnumId1() != null){
                queryWrapper.eq(PropertyServiceRequest::getRequestTypeEnumRequestTypeEnumId1, pageVO.getRequestTypeEnumRequestTypeEnumId1());
            }


            if(pageVO.getRequestStatusEnumRequestStatusEnumId1() != null){
                queryWrapper.eq(PropertyServiceRequest::getRequestStatusEnumRequestStatusEnumId1, pageVO.getRequestStatusEnumRequestStatusEnumId1());
            }


            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(PropertyServiceRequest::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }


        if(StringUtils.isNotEmpty(pageVO.getDescription())) {
                queryWrapper.eq(PropertyServiceRequest::getDescription, pageVO.getDescription());
            }


            if(pageVO.getCreateTime() != null){
                queryWrapper.eq(PropertyServiceRequest::getCreateTime, pageVO.getCreateTime());
            }


        if(StringUtils.isNotEmpty(pageVO.getProcessProgress())) {
                queryWrapper.eq(PropertyServiceRequest::getProcessProgress, pageVO.getProcessProgress());
            }

            return ResultUtils.success(propertyServiceRequestService.page(page, queryWrapper));
        }


        public BaseResponse list(  PropertyServiceRequestVO vo){
            LambdaQueryWrapper<PropertyServiceRequest> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getRequestTypeEnumRequestTypeEnumId1() != null){
                    queryWrapper.eq(PropertyServiceRequest::getRequestTypeEnumRequestTypeEnumId1, vo.getRequestTypeEnumRequestTypeEnumId1());
                }
                if(vo.getRequestStatusEnumRequestStatusEnumId1() != null){
                    queryWrapper.eq(PropertyServiceRequest::getRequestStatusEnumRequestStatusEnumId1, vo.getRequestStatusEnumRequestStatusEnumId1());
                }
                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(PropertyServiceRequest::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
            if(StringUtils.isNotEmpty(vo.getDescription())) {
                    queryWrapper.eq(PropertyServiceRequest::getDescription, vo.getDescription());
                }
                if(vo.getCreateTime() != null){
                    queryWrapper.eq(PropertyServiceRequest::getCreateTime, vo.getCreateTime());
                }
            if(StringUtils.isNotEmpty(vo.getProcessProgress())) {
                    queryWrapper.eq(PropertyServiceRequest::getProcessProgress, vo.getProcessProgress());
                }
                return ResultUtils.success(propertyServiceRequestService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  PropertyServiceRequestVO vo) {
                PropertyServiceRequest entity =  PropertyServiceRequest.builder()
                    .requestTypeEnumRequestTypeEnumId1(vo.getRequestTypeEnumRequestTypeEnumId1())
                    .requestStatusEnumRequestStatusEnumId1(vo.getRequestStatusEnumRequestStatusEnumId1())
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .description(vo.getDescription())
                    .processProgress(vo.getProcessProgress())
                .build();








                boolean flag =this.propertyServiceRequestService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("property_service_request").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getPropertyServiceRequestId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( PropertyServiceRequestVO vo) {
                PropertyServiceRequest entity =  PropertyServiceRequest.builder()
                    .propertyServiceRequestId(vo.getPropertyServiceRequestId())
                    .requestTypeEnumRequestTypeEnumId1(vo.getRequestTypeEnumRequestTypeEnumId1())
                    .requestStatusEnumRequestStatusEnumId1(vo.getRequestStatusEnumRequestStatusEnumId1())
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .description(vo.getDescription())
                    .processProgress(vo.getProcessProgress())
                .build();



                        boolean flag = this.propertyServiceRequestService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getPropertyServiceRequestId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( PropertyServiceRequestVO vo ) {
                PropertyServiceRequest entity = this.propertyServiceRequestService.getById(vo.getPropertyServiceRequestId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( PropertyServiceRequestVO vo) {
                boolean flag = this.propertyServiceRequestService.removeById(vo.getPropertyServiceRequestId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
