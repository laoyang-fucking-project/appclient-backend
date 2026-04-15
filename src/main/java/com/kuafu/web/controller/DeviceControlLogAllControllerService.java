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
import com.kuafu.web.entity.DeviceControlLogAll;
import com.kuafu.web.service.IDeviceControlLogAllService;
import com.kuafu.web.vo.DeviceControlLogAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.ISmartHomeDeviceService;
import com.kuafu.web.entity.SmartHomeDevice;
import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 设备控制记录表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("DeviceControlLogAllControllerService")
public class DeviceControlLogAllControllerService implements IControllerService<DeviceControlLogAll> {


@Autowired
    private  IDeviceControlLogAllService deviceControlLogAllService;








    public BaseResponse page( DeviceControlLogAllPageVO pageVO){
        IPage<DeviceControlLogAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<DeviceControlLogAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("dcl.device_control_log_id");
        LambdaQueryWrapper<DeviceControlLogAll> queryWrapper = objectQueryWrapper.lambda();


            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(DeviceControlLogAll::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }
            if(pageVO.getCreateTime() != null){
                queryWrapper.eq(DeviceControlLogAll::getCreateTime, pageVO.getCreateTime());
            }
        if(StringUtils.isNotEmpty(pageVO.getActionType())) {
                queryWrapper.like(DeviceControlLogAll::getActionType, pageVO.getActionType());
            }
            if(pageVO.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                queryWrapper.eq(DeviceControlLogAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, pageVO.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
            }
            if(pageVO.getIsOn() != null){
                queryWrapper.eq(DeviceControlLogAll::getIsOn, pageVO.getIsOn());
            }
            if(pageVO.getRoleEnumRoleEnumId1() != null){
                queryWrapper.eq(DeviceControlLogAll::getRoleEnumRoleEnumId1, pageVO.getRoleEnumRoleEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getCurrentValue())) {
                queryWrapper.like(DeviceControlLogAll::getCurrentValue, pageVO.getCurrentValue());
            }
        if(StringUtils.isNotEmpty(pageVO.getRoomName())) {

                        String s_string = pageVO.getRoomName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(DeviceControlLogAll::getRoomName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getLastUpdateTime() != null){
                queryWrapper.eq(DeviceControlLogAll::getLastUpdateTime, pageVO.getLastUpdateTime());
            }
            if(pageVO.getSmartHomeDeviceSmartDeviceId1() != null){
                queryWrapper.eq(DeviceControlLogAll::getSmartHomeDeviceSmartDeviceId1, pageVO.getSmartHomeDeviceSmartDeviceId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getDeviceName())) {

                        String s_string = pageVO.getDeviceName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(DeviceControlLogAll::getDeviceName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
                queryWrapper.like(DeviceControlLogAll::getPassword, pageVO.getPassword());
            }
            if(pageVO.getBrightness() != null){
                queryWrapper.eq(DeviceControlLogAll::getBrightness, pageVO.getBrightness());
            }
            if(pageVO.getDeviceControlLogId() != null){
                queryWrapper.eq(DeviceControlLogAll::getDeviceControlLogId, pageVO.getDeviceControlLogId());
            }
            if(pageVO.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                queryWrapper.eq(DeviceControlLogAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, pageVO.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getActionValue())) {
                queryWrapper.like(DeviceControlLogAll::getActionValue, pageVO.getActionValue());
            }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
                queryWrapper.like(DeviceControlLogAll::getPhoneNumber, pageVO.getPhoneNumber());
            }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {

                        String s_string = pageVO.getUsername();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(DeviceControlLogAll::getUsername, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

                    deviceControlLogAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(DeviceControlLogAllPageVO vo){
            LambdaQueryWrapper<DeviceControlLogAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(DeviceControlLogAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
                if(vo.getCreateTime() != null){
                    queryWrapper.eq(DeviceControlLogAll::getCreateTime, vo.getCreateTime());
                }
            if(StringUtils.isNotEmpty(vo.getActionType())) {
                    queryWrapper.eq(DeviceControlLogAll::getActionType, vo.getActionType());
                }
                if(vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                    queryWrapper.eq(DeviceControlLogAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
                }
                if(vo.getIsOn() != null){
                    queryWrapper.eq(DeviceControlLogAll::getIsOn, vo.getIsOn());
                }
                if(vo.getRoleEnumRoleEnumId1() != null){
                    queryWrapper.eq(DeviceControlLogAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getCurrentValue())) {
                    queryWrapper.eq(DeviceControlLogAll::getCurrentValue, vo.getCurrentValue());
                }
            if(StringUtils.isNotEmpty(vo.getRoomName())) {
                            queryWrapper.like(DeviceControlLogAll::getRoomName, vo.getRoomName());
                }
                if(vo.getLastUpdateTime() != null){
                    queryWrapper.eq(DeviceControlLogAll::getLastUpdateTime, vo.getLastUpdateTime());
                }
                if(vo.getSmartHomeDeviceSmartDeviceId1() != null){
                    queryWrapper.eq(DeviceControlLogAll::getSmartHomeDeviceSmartDeviceId1, vo.getSmartHomeDeviceSmartDeviceId1());
                }
            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                            queryWrapper.like(DeviceControlLogAll::getDeviceName, vo.getDeviceName());
                }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
                    queryWrapper.eq(DeviceControlLogAll::getPassword, vo.getPassword());
                }
                if(vo.getBrightness() != null){
                    queryWrapper.eq(DeviceControlLogAll::getBrightness, vo.getBrightness());
                }
                if(vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                    queryWrapper.eq(DeviceControlLogAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getActionValue())) {
                    queryWrapper.eq(DeviceControlLogAll::getActionValue, vo.getActionValue());
                }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                    queryWrapper.eq(DeviceControlLogAll::getPhoneNumber, vo.getPhoneNumber());
                }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
                            queryWrapper.like(DeviceControlLogAll::getUsername, vo.getUsername());
                }
                return ResultUtils.success(deviceControlLogAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(DeviceControlLogAllPageVO vo) {


                LambdaQueryWrapper<DeviceControlLogAll> queryWrapper = new LambdaQueryWrapper<>();


                                if(vo.getUserInfoUserInfoId1() != null){
                                    queryWrapper.eq(DeviceControlLogAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                                }


                                if(vo.getCreateTime() != null){
                                    queryWrapper.eq(DeviceControlLogAll::getCreateTime, vo.getCreateTime());
                                }


                            if(StringUtils.isNotEmpty(vo.getActionType())) {
                                    queryWrapper.eq(DeviceControlLogAll::getActionType, vo.getActionType());
                                }


                                if(vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                                    queryWrapper.eq(DeviceControlLogAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
                                }


                                if(vo.getIsOn() != null){
                                    queryWrapper.eq(DeviceControlLogAll::getIsOn, vo.getIsOn());
                                }


                                if(vo.getRoleEnumRoleEnumId1() != null){
                                    queryWrapper.eq(DeviceControlLogAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getCurrentValue())) {
                                    queryWrapper.eq(DeviceControlLogAll::getCurrentValue, vo.getCurrentValue());
                                }


                            if(StringUtils.isNotEmpty(vo.getRoomName())) {
                                            queryWrapper.like(DeviceControlLogAll::getRoomName, vo.getRoomName());
                                }


                                if(vo.getLastUpdateTime() != null){
                                    queryWrapper.eq(DeviceControlLogAll::getLastUpdateTime, vo.getLastUpdateTime());
                                }


                                if(vo.getSmartHomeDeviceSmartDeviceId1() != null){
                                    queryWrapper.eq(DeviceControlLogAll::getSmartHomeDeviceSmartDeviceId1, vo.getSmartHomeDeviceSmartDeviceId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                                            queryWrapper.like(DeviceControlLogAll::getDeviceName, vo.getDeviceName());
                                }


                            if(StringUtils.isNotEmpty(vo.getPassword())) {
                                    queryWrapper.eq(DeviceControlLogAll::getPassword, vo.getPassword());
                                }


                                if(vo.getBrightness() != null){
                                    queryWrapper.eq(DeviceControlLogAll::getBrightness, vo.getBrightness());
                                }


                                if(vo.getDeviceControlLogId() != null){
                                    queryWrapper.eq(DeviceControlLogAll::getDeviceControlLogId, vo.getDeviceControlLogId());
                                }


                                if(vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                                    queryWrapper.eq(DeviceControlLogAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getActionValue())) {
                                    queryWrapper.eq(DeviceControlLogAll::getActionValue, vo.getActionValue());
                                }


                            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                                    queryWrapper.eq(DeviceControlLogAll::getPhoneNumber, vo.getPhoneNumber());
                                }


                            if(StringUtils.isNotEmpty(vo.getUsername())) {
                                            queryWrapper.like(DeviceControlLogAll::getUsername, vo.getUsername());
                                }

                // DeviceControlLogAll entity = this.deviceControlLogAllService.getById(deviceControlLogId);
                    final Page<DeviceControlLogAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    deviceControlLogAllService.pageNew(page, vo, queryWrapper);
                    final List<DeviceControlLogAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public DeviceControlLogAll getById(Serializable deviceControlLogId) {

                    LambdaQueryWrapper<DeviceControlLogAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(DeviceControlLogAll::getDeviceControlLogId, deviceControlLogId);

                    final Page<DeviceControlLogAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    deviceControlLogAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<DeviceControlLogAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
