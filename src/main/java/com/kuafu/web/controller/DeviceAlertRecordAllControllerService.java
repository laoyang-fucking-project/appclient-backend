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
import com.kuafu.web.entity.DeviceAlertRecordAll;
import com.kuafu.web.service.IDeviceAlertRecordAllService;
import com.kuafu.web.vo.DeviceAlertRecordAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.ISmartHomeDeviceService;
import com.kuafu.web.entity.SmartHomeDevice;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 设备告警记录表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("DeviceAlertRecordAllControllerService")
public class DeviceAlertRecordAllControllerService implements IControllerService<DeviceAlertRecordAll> {


@Autowired
    private  IDeviceAlertRecordAllService deviceAlertRecordAllService;








    public BaseResponse page( DeviceAlertRecordAllPageVO pageVO){
        IPage<DeviceAlertRecordAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<DeviceAlertRecordAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("dar.device_alert_record_id");
        LambdaQueryWrapper<DeviceAlertRecordAll> queryWrapper = objectQueryWrapper.lambda();


            if(pageVO.getDeviceAlertRecordId() != null){
                queryWrapper.eq(DeviceAlertRecordAll::getDeviceAlertRecordId, pageVO.getDeviceAlertRecordId());
            }
            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(DeviceAlertRecordAll::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }
            if(pageVO.getCreateTime() != null){
                queryWrapper.eq(DeviceAlertRecordAll::getCreateTime, pageVO.getCreateTime());
            }
        if(StringUtils.isNotEmpty(pageVO.getAlertMessage())) {
                queryWrapper.like(DeviceAlertRecordAll::getAlertMessage, pageVO.getAlertMessage());
            }
            if(pageVO.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                queryWrapper.eq(DeviceAlertRecordAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, pageVO.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
            }
            if(pageVO.getIsOn() != null){
                queryWrapper.eq(DeviceAlertRecordAll::getIsOn, pageVO.getIsOn());
            }
        if(StringUtils.isNotEmpty(pageVO.getAlertType())) {
                queryWrapper.like(DeviceAlertRecordAll::getAlertType, pageVO.getAlertType());
            }
        if(StringUtils.isNotEmpty(pageVO.getCurrentValue())) {
                queryWrapper.like(DeviceAlertRecordAll::getCurrentValue, pageVO.getCurrentValue());
            }
        if(StringUtils.isNotEmpty(pageVO.getRoomName())) {

                        String s_string = pageVO.getRoomName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(DeviceAlertRecordAll::getRoomName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getLastUpdateTime() != null){
                queryWrapper.eq(DeviceAlertRecordAll::getLastUpdateTime, pageVO.getLastUpdateTime());
            }
            if(pageVO.getSmartHomeDeviceSmartDeviceId1() != null){
                queryWrapper.eq(DeviceAlertRecordAll::getSmartHomeDeviceSmartDeviceId1, pageVO.getSmartHomeDeviceSmartDeviceId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getDeviceName())) {

                        String s_string = pageVO.getDeviceName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(DeviceAlertRecordAll::getDeviceName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getBrightness() != null){
                queryWrapper.eq(DeviceAlertRecordAll::getBrightness, pageVO.getBrightness());
            }
            if(pageVO.getIsResolved() != null){
                queryWrapper.eq(DeviceAlertRecordAll::getIsResolved, pageVO.getIsResolved());
            }
            if(pageVO.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                queryWrapper.eq(DeviceAlertRecordAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, pageVO.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getAlertLevel())) {
                queryWrapper.like(DeviceAlertRecordAll::getAlertLevel, pageVO.getAlertLevel());
            }

                    deviceAlertRecordAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(DeviceAlertRecordAllPageVO vo){
            LambdaQueryWrapper<DeviceAlertRecordAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(DeviceAlertRecordAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
                if(vo.getCreateTime() != null){
                    queryWrapper.eq(DeviceAlertRecordAll::getCreateTime, vo.getCreateTime());
                }
            if(StringUtils.isNotEmpty(vo.getAlertMessage())) {
                    queryWrapper.eq(DeviceAlertRecordAll::getAlertMessage, vo.getAlertMessage());
                }
                if(vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                    queryWrapper.eq(DeviceAlertRecordAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
                }
                if(vo.getIsOn() != null){
                    queryWrapper.eq(DeviceAlertRecordAll::getIsOn, vo.getIsOn());
                }
            if(StringUtils.isNotEmpty(vo.getAlertType())) {
                    queryWrapper.eq(DeviceAlertRecordAll::getAlertType, vo.getAlertType());
                }
            if(StringUtils.isNotEmpty(vo.getCurrentValue())) {
                    queryWrapper.eq(DeviceAlertRecordAll::getCurrentValue, vo.getCurrentValue());
                }
            if(StringUtils.isNotEmpty(vo.getRoomName())) {
                            queryWrapper.like(DeviceAlertRecordAll::getRoomName, vo.getRoomName());
                }
                if(vo.getLastUpdateTime() != null){
                    queryWrapper.eq(DeviceAlertRecordAll::getLastUpdateTime, vo.getLastUpdateTime());
                }
                if(vo.getSmartHomeDeviceSmartDeviceId1() != null){
                    queryWrapper.eq(DeviceAlertRecordAll::getSmartHomeDeviceSmartDeviceId1, vo.getSmartHomeDeviceSmartDeviceId1());
                }
            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                            queryWrapper.like(DeviceAlertRecordAll::getDeviceName, vo.getDeviceName());
                }
                if(vo.getBrightness() != null){
                    queryWrapper.eq(DeviceAlertRecordAll::getBrightness, vo.getBrightness());
                }
                if(vo.getIsResolved() != null){
                    queryWrapper.eq(DeviceAlertRecordAll::getIsResolved, vo.getIsResolved());
                }
                if(vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                    queryWrapper.eq(DeviceAlertRecordAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getAlertLevel())) {
                    queryWrapper.eq(DeviceAlertRecordAll::getAlertLevel, vo.getAlertLevel());
                }
                return ResultUtils.success(deviceAlertRecordAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(DeviceAlertRecordAllPageVO vo) {


                LambdaQueryWrapper<DeviceAlertRecordAll> queryWrapper = new LambdaQueryWrapper<>();


                                if(vo.getDeviceAlertRecordId() != null){
                                    queryWrapper.eq(DeviceAlertRecordAll::getDeviceAlertRecordId, vo.getDeviceAlertRecordId());
                                }


                                if(vo.getUserInfoUserInfoId1() != null){
                                    queryWrapper.eq(DeviceAlertRecordAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                                }


                                if(vo.getCreateTime() != null){
                                    queryWrapper.eq(DeviceAlertRecordAll::getCreateTime, vo.getCreateTime());
                                }


                            if(StringUtils.isNotEmpty(vo.getAlertMessage())) {
                                    queryWrapper.eq(DeviceAlertRecordAll::getAlertMessage, vo.getAlertMessage());
                                }


                                if(vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                                    queryWrapper.eq(DeviceAlertRecordAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
                                }


                                if(vo.getIsOn() != null){
                                    queryWrapper.eq(DeviceAlertRecordAll::getIsOn, vo.getIsOn());
                                }


                            if(StringUtils.isNotEmpty(vo.getAlertType())) {
                                    queryWrapper.eq(DeviceAlertRecordAll::getAlertType, vo.getAlertType());
                                }


                            if(StringUtils.isNotEmpty(vo.getCurrentValue())) {
                                    queryWrapper.eq(DeviceAlertRecordAll::getCurrentValue, vo.getCurrentValue());
                                }


                            if(StringUtils.isNotEmpty(vo.getRoomName())) {
                                            queryWrapper.like(DeviceAlertRecordAll::getRoomName, vo.getRoomName());
                                }


                                if(vo.getLastUpdateTime() != null){
                                    queryWrapper.eq(DeviceAlertRecordAll::getLastUpdateTime, vo.getLastUpdateTime());
                                }


                                if(vo.getSmartHomeDeviceSmartDeviceId1() != null){
                                    queryWrapper.eq(DeviceAlertRecordAll::getSmartHomeDeviceSmartDeviceId1, vo.getSmartHomeDeviceSmartDeviceId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                                            queryWrapper.like(DeviceAlertRecordAll::getDeviceName, vo.getDeviceName());
                                }


                                if(vo.getBrightness() != null){
                                    queryWrapper.eq(DeviceAlertRecordAll::getBrightness, vo.getBrightness());
                                }


                                if(vo.getIsResolved() != null){
                                    queryWrapper.eq(DeviceAlertRecordAll::getIsResolved, vo.getIsResolved());
                                }


                                if(vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                                    queryWrapper.eq(DeviceAlertRecordAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getAlertLevel())) {
                                    queryWrapper.eq(DeviceAlertRecordAll::getAlertLevel, vo.getAlertLevel());
                                }

                // DeviceAlertRecordAll entity = this.deviceAlertRecordAllService.getById(deviceAlertRecordId);
                    final Page<DeviceAlertRecordAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    deviceAlertRecordAllService.pageNew(page, vo, queryWrapper);
                    final List<DeviceAlertRecordAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public DeviceAlertRecordAll getById(Serializable deviceAlertRecordId) {

                    LambdaQueryWrapper<DeviceAlertRecordAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(DeviceAlertRecordAll::getDeviceAlertRecordId, deviceAlertRecordId);

                    final Page<DeviceAlertRecordAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    deviceAlertRecordAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<DeviceAlertRecordAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
