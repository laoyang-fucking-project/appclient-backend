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
import com.kuafu.web.entity.PropertyServiceRequestAll;
import com.kuafu.web.service.IPropertyServiceRequestAllService;
import com.kuafu.web.vo.PropertyServiceRequestAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.IRequestTypeEnumService;
import com.kuafu.web.entity.RequestTypeEnum;
import com.kuafu.web.service.IRequestStatusEnumService;
import com.kuafu.web.entity.RequestStatusEnum;
import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 物业请求 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("PropertyServiceRequestAllControllerService")
public class PropertyServiceRequestAllControllerService implements IControllerService<PropertyServiceRequestAll> {


@Autowired
    private  IPropertyServiceRequestAllService propertyServiceRequestAllService;








    public BaseResponse page( PropertyServiceRequestAllPageVO pageVO){
        IPage<PropertyServiceRequestAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<PropertyServiceRequestAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("psr.property_service_request_id");
        LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper = objectQueryWrapper.lambda();


        if(StringUtils.isNotEmpty(pageVO.getTypeName())) {

                        String s_string = pageVO.getTypeName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(PropertyServiceRequestAll::getTypeName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(PropertyServiceRequestAll::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }
            if(pageVO.getCreateTime() != null){
                queryWrapper.eq(PropertyServiceRequestAll::getCreateTime, pageVO.getCreateTime());
            }
            if(pageVO.getRequestStatusEnumRequestStatusEnumId1() != null){
                queryWrapper.eq(PropertyServiceRequestAll::getRequestStatusEnumRequestStatusEnumId1, pageVO.getRequestStatusEnumRequestStatusEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getStatusName())) {

                        String s_string = pageVO.getStatusName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(PropertyServiceRequestAll::getStatusName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getPropertyServiceRequestId() != null){
                queryWrapper.eq(PropertyServiceRequestAll::getPropertyServiceRequestId, pageVO.getPropertyServiceRequestId());
            }
        if(StringUtils.isNotEmpty(pageVO.getDescription())) {
                queryWrapper.like(PropertyServiceRequestAll::getDescription, pageVO.getDescription());
            }
            if(pageVO.getRoleEnumRoleEnumId1() != null){
                queryWrapper.eq(PropertyServiceRequestAll::getRoleEnumRoleEnumId1, pageVO.getRoleEnumRoleEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
                queryWrapper.like(PropertyServiceRequestAll::getPassword, pageVO.getPassword());
            }
            if(pageVO.getRequestTypeEnumRequestTypeEnumId1() != null){
                queryWrapper.eq(PropertyServiceRequestAll::getRequestTypeEnumRequestTypeEnumId1, pageVO.getRequestTypeEnumRequestTypeEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
                queryWrapper.like(PropertyServiceRequestAll::getPhoneNumber, pageVO.getPhoneNumber());
            }
        if(StringUtils.isNotEmpty(pageVO.getProcessProgress())) {
                queryWrapper.like(PropertyServiceRequestAll::getProcessProgress, pageVO.getProcessProgress());
            }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {

                        String s_string = pageVO.getUsername();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(PropertyServiceRequestAll::getUsername, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

                    propertyServiceRequestAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(PropertyServiceRequestAllPageVO vo){
            LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                            queryWrapper.like(PropertyServiceRequestAll::getTypeName, vo.getTypeName());
                }
                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(PropertyServiceRequestAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
                if(vo.getCreateTime() != null){
                    queryWrapper.eq(PropertyServiceRequestAll::getCreateTime, vo.getCreateTime());
                }
                if(vo.getRequestStatusEnumRequestStatusEnumId1() != null){
                    queryWrapper.eq(PropertyServiceRequestAll::getRequestStatusEnumRequestStatusEnumId1, vo.getRequestStatusEnumRequestStatusEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                            queryWrapper.like(PropertyServiceRequestAll::getStatusName, vo.getStatusName());
                }
            if(StringUtils.isNotEmpty(vo.getDescription())) {
                    queryWrapper.eq(PropertyServiceRequestAll::getDescription, vo.getDescription());
                }
                if(vo.getRoleEnumRoleEnumId1() != null){
                    queryWrapper.eq(PropertyServiceRequestAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
                    queryWrapper.eq(PropertyServiceRequestAll::getPassword, vo.getPassword());
                }
                if(vo.getRequestTypeEnumRequestTypeEnumId1() != null){
                    queryWrapper.eq(PropertyServiceRequestAll::getRequestTypeEnumRequestTypeEnumId1, vo.getRequestTypeEnumRequestTypeEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                    queryWrapper.eq(PropertyServiceRequestAll::getPhoneNumber, vo.getPhoneNumber());
                }
            if(StringUtils.isNotEmpty(vo.getProcessProgress())) {
                    queryWrapper.eq(PropertyServiceRequestAll::getProcessProgress, vo.getProcessProgress());
                }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
                            queryWrapper.like(PropertyServiceRequestAll::getUsername, vo.getUsername());
                }
                return ResultUtils.success(propertyServiceRequestAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(PropertyServiceRequestAllPageVO vo) {


                LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper = new LambdaQueryWrapper<>();


                            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                                            queryWrapper.like(PropertyServiceRequestAll::getTypeName, vo.getTypeName());
                                }


                                if(vo.getUserInfoUserInfoId1() != null){
                                    queryWrapper.eq(PropertyServiceRequestAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                                }


                                if(vo.getCreateTime() != null){
                                    queryWrapper.eq(PropertyServiceRequestAll::getCreateTime, vo.getCreateTime());
                                }


                                if(vo.getRequestStatusEnumRequestStatusEnumId1() != null){
                                    queryWrapper.eq(PropertyServiceRequestAll::getRequestStatusEnumRequestStatusEnumId1, vo.getRequestStatusEnumRequestStatusEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                                            queryWrapper.like(PropertyServiceRequestAll::getStatusName, vo.getStatusName());
                                }


                                if(vo.getPropertyServiceRequestId() != null){
                                    queryWrapper.eq(PropertyServiceRequestAll::getPropertyServiceRequestId, vo.getPropertyServiceRequestId());
                                }


                            if(StringUtils.isNotEmpty(vo.getDescription())) {
                                    queryWrapper.eq(PropertyServiceRequestAll::getDescription, vo.getDescription());
                                }


                                if(vo.getRoleEnumRoleEnumId1() != null){
                                    queryWrapper.eq(PropertyServiceRequestAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getPassword())) {
                                    queryWrapper.eq(PropertyServiceRequestAll::getPassword, vo.getPassword());
                                }


                                if(vo.getRequestTypeEnumRequestTypeEnumId1() != null){
                                    queryWrapper.eq(PropertyServiceRequestAll::getRequestTypeEnumRequestTypeEnumId1, vo.getRequestTypeEnumRequestTypeEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                                    queryWrapper.eq(PropertyServiceRequestAll::getPhoneNumber, vo.getPhoneNumber());
                                }


                            if(StringUtils.isNotEmpty(vo.getProcessProgress())) {
                                    queryWrapper.eq(PropertyServiceRequestAll::getProcessProgress, vo.getProcessProgress());
                                }


                            if(StringUtils.isNotEmpty(vo.getUsername())) {
                                            queryWrapper.like(PropertyServiceRequestAll::getUsername, vo.getUsername());
                                }

                // PropertyServiceRequestAll entity = this.propertyServiceRequestAllService.getById(propertyServiceRequestId);
                    final Page<PropertyServiceRequestAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    propertyServiceRequestAllService.pageNew(page, vo, queryWrapper);
                    final List<PropertyServiceRequestAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public PropertyServiceRequestAll getById(Serializable propertyServiceRequestId) {

                    LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(PropertyServiceRequestAll::getPropertyServiceRequestId, propertyServiceRequestId);

                    final Page<PropertyServiceRequestAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    propertyServiceRequestAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<PropertyServiceRequestAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
