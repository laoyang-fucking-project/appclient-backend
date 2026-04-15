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
import com.kuafu.web.entity.SmartHomeDeviceAll;
import com.kuafu.web.service.ISmartHomeDeviceAllService;
import com.kuafu.web.vo.SmartHomeDeviceAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.ISmartDeviceTypeEnumService;
import com.kuafu.web.entity.SmartDeviceTypeEnum;
import com.kuafu.web.service.ISmartDeviceStatusEnumService;
import com.kuafu.web.entity.SmartDeviceStatusEnum;
import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 智能家居设备表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("SmartHomeDeviceAllControllerService")
public class SmartHomeDeviceAllControllerService implements IControllerService<SmartHomeDeviceAll> {


@Autowired
    private  ISmartHomeDeviceAllService smartHomeDeviceAllService;








    public BaseResponse page( SmartHomeDeviceAllPageVO pageVO){
        IPage<SmartHomeDeviceAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<SmartHomeDeviceAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("shd.smart_device_id");
        LambdaQueryWrapper<SmartHomeDeviceAll> queryWrapper = objectQueryWrapper.lambda();


        if(StringUtils.isNotEmpty(pageVO.getTypeName())) {

                        String s_string = pageVO.getTypeName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SmartHomeDeviceAll::getTypeName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(SmartHomeDeviceAll::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getStatusName())) {

                        String s_string = pageVO.getStatusName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SmartHomeDeviceAll::getStatusName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                queryWrapper.eq(SmartHomeDeviceAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, pageVO.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
            }
            if(pageVO.getIsOn() != null){
                queryWrapper.eq(SmartHomeDeviceAll::getIsOn, pageVO.getIsOn());
            }
            if(pageVO.getRoleEnumRoleEnumId1() != null){
                queryWrapper.eq(SmartHomeDeviceAll::getRoleEnumRoleEnumId1, pageVO.getRoleEnumRoleEnumId1());
            }
            if(pageVO.getSmartDeviceId() != null){
                queryWrapper.eq(SmartHomeDeviceAll::getSmartDeviceId, pageVO.getSmartDeviceId());
            }
        if(StringUtils.isNotEmpty(pageVO.getCurrentValue())) {
                queryWrapper.like(SmartHomeDeviceAll::getCurrentValue, pageVO.getCurrentValue());
            }
        if(StringUtils.isNotEmpty(pageVO.getRoomName())) {

                        String s_string = pageVO.getRoomName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SmartHomeDeviceAll::getRoomName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getLastUpdateTime() != null){
                queryWrapper.eq(SmartHomeDeviceAll::getLastUpdateTime, pageVO.getLastUpdateTime());
            }
        if(StringUtils.isNotEmpty(pageVO.getDeviceName())) {

                        String s_string = pageVO.getDeviceName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SmartHomeDeviceAll::getDeviceName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
                queryWrapper.like(SmartHomeDeviceAll::getPassword, pageVO.getPassword());
            }
            if(pageVO.getBrightness() != null){
                queryWrapper.eq(SmartHomeDeviceAll::getBrightness, pageVO.getBrightness());
            }
            if(pageVO.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                queryWrapper.eq(SmartHomeDeviceAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, pageVO.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
                queryWrapper.like(SmartHomeDeviceAll::getPhoneNumber, pageVO.getPhoneNumber());
            }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {

                        String s_string = pageVO.getUsername();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SmartHomeDeviceAll::getUsername, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

                    smartHomeDeviceAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(SmartHomeDeviceAllPageVO vo){
            LambdaQueryWrapper<SmartHomeDeviceAll> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                            queryWrapper.like(SmartHomeDeviceAll::getTypeName, vo.getTypeName());
                }
                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(SmartHomeDeviceAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                            queryWrapper.like(SmartHomeDeviceAll::getStatusName, vo.getStatusName());
                }
                if(vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                    queryWrapper.eq(SmartHomeDeviceAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
                }
                if(vo.getIsOn() != null){
                    queryWrapper.eq(SmartHomeDeviceAll::getIsOn, vo.getIsOn());
                }
                if(vo.getRoleEnumRoleEnumId1() != null){
                    queryWrapper.eq(SmartHomeDeviceAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getCurrentValue())) {
                    queryWrapper.eq(SmartHomeDeviceAll::getCurrentValue, vo.getCurrentValue());
                }
            if(StringUtils.isNotEmpty(vo.getRoomName())) {
                            queryWrapper.like(SmartHomeDeviceAll::getRoomName, vo.getRoomName());
                }
                if(vo.getLastUpdateTime() != null){
                    queryWrapper.eq(SmartHomeDeviceAll::getLastUpdateTime, vo.getLastUpdateTime());
                }
            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                            queryWrapper.like(SmartHomeDeviceAll::getDeviceName, vo.getDeviceName());
                }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
                    queryWrapper.eq(SmartHomeDeviceAll::getPassword, vo.getPassword());
                }
                if(vo.getBrightness() != null){
                    queryWrapper.eq(SmartHomeDeviceAll::getBrightness, vo.getBrightness());
                }
                if(vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                    queryWrapper.eq(SmartHomeDeviceAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                    queryWrapper.eq(SmartHomeDeviceAll::getPhoneNumber, vo.getPhoneNumber());
                }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
                            queryWrapper.like(SmartHomeDeviceAll::getUsername, vo.getUsername());
                }
                return ResultUtils.success(smartHomeDeviceAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(SmartHomeDeviceAllPageVO vo) {


                LambdaQueryWrapper<SmartHomeDeviceAll> queryWrapper = new LambdaQueryWrapper<>();


                            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                                            queryWrapper.like(SmartHomeDeviceAll::getTypeName, vo.getTypeName());
                                }


                                if(vo.getUserInfoUserInfoId1() != null){
                                    queryWrapper.eq(SmartHomeDeviceAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                                            queryWrapper.like(SmartHomeDeviceAll::getStatusName, vo.getStatusName());
                                }


                                if(vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                                    queryWrapper.eq(SmartHomeDeviceAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
                                }


                                if(vo.getIsOn() != null){
                                    queryWrapper.eq(SmartHomeDeviceAll::getIsOn, vo.getIsOn());
                                }


                                if(vo.getRoleEnumRoleEnumId1() != null){
                                    queryWrapper.eq(SmartHomeDeviceAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                                }


                                if(vo.getSmartDeviceId() != null){
                                    queryWrapper.eq(SmartHomeDeviceAll::getSmartDeviceId, vo.getSmartDeviceId());
                                }


                            if(StringUtils.isNotEmpty(vo.getCurrentValue())) {
                                    queryWrapper.eq(SmartHomeDeviceAll::getCurrentValue, vo.getCurrentValue());
                                }


                            if(StringUtils.isNotEmpty(vo.getRoomName())) {
                                            queryWrapper.like(SmartHomeDeviceAll::getRoomName, vo.getRoomName());
                                }


                                if(vo.getLastUpdateTime() != null){
                                    queryWrapper.eq(SmartHomeDeviceAll::getLastUpdateTime, vo.getLastUpdateTime());
                                }


                            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                                            queryWrapper.like(SmartHomeDeviceAll::getDeviceName, vo.getDeviceName());
                                }


                            if(StringUtils.isNotEmpty(vo.getPassword())) {
                                    queryWrapper.eq(SmartHomeDeviceAll::getPassword, vo.getPassword());
                                }


                                if(vo.getBrightness() != null){
                                    queryWrapper.eq(SmartHomeDeviceAll::getBrightness, vo.getBrightness());
                                }


                                if(vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                                    queryWrapper.eq(SmartHomeDeviceAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                                    queryWrapper.eq(SmartHomeDeviceAll::getPhoneNumber, vo.getPhoneNumber());
                                }


                            if(StringUtils.isNotEmpty(vo.getUsername())) {
                                            queryWrapper.like(SmartHomeDeviceAll::getUsername, vo.getUsername());
                                }

                // SmartHomeDeviceAll entity = this.smartHomeDeviceAllService.getById(smartDeviceId);
                    final Page<SmartHomeDeviceAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    smartHomeDeviceAllService.pageNew(page, vo, queryWrapper);
                    final List<SmartHomeDeviceAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public SmartHomeDeviceAll getById(Serializable smartDeviceId) {

                    LambdaQueryWrapper<SmartHomeDeviceAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(SmartHomeDeviceAll::getSmartDeviceId, smartDeviceId);

                    final Page<SmartHomeDeviceAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    smartHomeDeviceAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<SmartHomeDeviceAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
