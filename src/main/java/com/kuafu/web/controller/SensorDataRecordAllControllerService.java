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
import com.kuafu.web.entity.SensorDataRecordAll;
import com.kuafu.web.service.ISensorDataRecordAllService;
import com.kuafu.web.vo.SensorDataRecordAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.ISmartHomeDeviceService;
import com.kuafu.web.entity.SmartHomeDevice;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 传感器数据记录表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("SensorDataRecordAllControllerService")
public class SensorDataRecordAllControllerService implements IControllerService<SensorDataRecordAll> {


@Autowired
    private  ISensorDataRecordAllService sensorDataRecordAllService;








    public BaseResponse page( SensorDataRecordAllPageVO pageVO){
        IPage<SensorDataRecordAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<SensorDataRecordAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("sdr.sensor_data_record_id");
        LambdaQueryWrapper<SensorDataRecordAll> queryWrapper = objectQueryWrapper.lambda();


            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(SensorDataRecordAll::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }
            if(pageVO.getSensorDataRecordId() != null){
                queryWrapper.eq(SensorDataRecordAll::getSensorDataRecordId, pageVO.getSensorDataRecordId());
            }
            if(pageVO.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                queryWrapper.eq(SensorDataRecordAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, pageVO.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
            }
            if(pageVO.getIsOn() != null){
                queryWrapper.eq(SensorDataRecordAll::getIsOn, pageVO.getIsOn());
            }
        if(StringUtils.isNotEmpty(pageVO.getSensorValue())) {
                queryWrapper.like(SensorDataRecordAll::getSensorValue, pageVO.getSensorValue());
            }
        if(StringUtils.isNotEmpty(pageVO.getCurrentValue())) {
                queryWrapper.like(SensorDataRecordAll::getCurrentValue, pageVO.getCurrentValue());
            }
        if(StringUtils.isNotEmpty(pageVO.getRoomName())) {

                        String s_string = pageVO.getRoomName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SensorDataRecordAll::getRoomName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getLastUpdateTime() != null){
                queryWrapper.eq(SensorDataRecordAll::getLastUpdateTime, pageVO.getLastUpdateTime());
            }
            if(pageVO.getSmartHomeDeviceSmartDeviceId1() != null){
                queryWrapper.eq(SensorDataRecordAll::getSmartHomeDeviceSmartDeviceId1, pageVO.getSmartHomeDeviceSmartDeviceId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getDeviceName())) {

                        String s_string = pageVO.getDeviceName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SensorDataRecordAll::getDeviceName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getBrightness() != null){
                queryWrapper.eq(SensorDataRecordAll::getBrightness, pageVO.getBrightness());
            }
            if(pageVO.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                queryWrapper.eq(SensorDataRecordAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, pageVO.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
            }
            if(pageVO.getRecordTime() != null){
                queryWrapper.eq(SensorDataRecordAll::getRecordTime, pageVO.getRecordTime());
            }

                    sensorDataRecordAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(SensorDataRecordAllPageVO vo){
            LambdaQueryWrapper<SensorDataRecordAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(SensorDataRecordAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
                if(vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                    queryWrapper.eq(SensorDataRecordAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
                }
                if(vo.getIsOn() != null){
                    queryWrapper.eq(SensorDataRecordAll::getIsOn, vo.getIsOn());
                }
            if(StringUtils.isNotEmpty(vo.getSensorValue())) {
                    queryWrapper.eq(SensorDataRecordAll::getSensorValue, vo.getSensorValue());
                }
            if(StringUtils.isNotEmpty(vo.getCurrentValue())) {
                    queryWrapper.eq(SensorDataRecordAll::getCurrentValue, vo.getCurrentValue());
                }
            if(StringUtils.isNotEmpty(vo.getRoomName())) {
                            queryWrapper.like(SensorDataRecordAll::getRoomName, vo.getRoomName());
                }
                if(vo.getLastUpdateTime() != null){
                    queryWrapper.eq(SensorDataRecordAll::getLastUpdateTime, vo.getLastUpdateTime());
                }
                if(vo.getSmartHomeDeviceSmartDeviceId1() != null){
                    queryWrapper.eq(SensorDataRecordAll::getSmartHomeDeviceSmartDeviceId1, vo.getSmartHomeDeviceSmartDeviceId1());
                }
            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                            queryWrapper.like(SensorDataRecordAll::getDeviceName, vo.getDeviceName());
                }
                if(vo.getBrightness() != null){
                    queryWrapper.eq(SensorDataRecordAll::getBrightness, vo.getBrightness());
                }
                if(vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                    queryWrapper.eq(SensorDataRecordAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
                }
                if(vo.getRecordTime() != null){
                    queryWrapper.eq(SensorDataRecordAll::getRecordTime, vo.getRecordTime());
                }
                return ResultUtils.success(sensorDataRecordAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(SensorDataRecordAllPageVO vo) {


                LambdaQueryWrapper<SensorDataRecordAll> queryWrapper = new LambdaQueryWrapper<>();


                                if(vo.getUserInfoUserInfoId1() != null){
                                    queryWrapper.eq(SensorDataRecordAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                                }


                                if(vo.getSensorDataRecordId() != null){
                                    queryWrapper.eq(SensorDataRecordAll::getSensorDataRecordId, vo.getSensorDataRecordId());
                                }


                                if(vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                                    queryWrapper.eq(SensorDataRecordAll::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
                                }


                                if(vo.getIsOn() != null){
                                    queryWrapper.eq(SensorDataRecordAll::getIsOn, vo.getIsOn());
                                }


                            if(StringUtils.isNotEmpty(vo.getSensorValue())) {
                                    queryWrapper.eq(SensorDataRecordAll::getSensorValue, vo.getSensorValue());
                                }


                            if(StringUtils.isNotEmpty(vo.getCurrentValue())) {
                                    queryWrapper.eq(SensorDataRecordAll::getCurrentValue, vo.getCurrentValue());
                                }


                            if(StringUtils.isNotEmpty(vo.getRoomName())) {
                                            queryWrapper.like(SensorDataRecordAll::getRoomName, vo.getRoomName());
                                }


                                if(vo.getLastUpdateTime() != null){
                                    queryWrapper.eq(SensorDataRecordAll::getLastUpdateTime, vo.getLastUpdateTime());
                                }


                                if(vo.getSmartHomeDeviceSmartDeviceId1() != null){
                                    queryWrapper.eq(SensorDataRecordAll::getSmartHomeDeviceSmartDeviceId1, vo.getSmartHomeDeviceSmartDeviceId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                                            queryWrapper.like(SensorDataRecordAll::getDeviceName, vo.getDeviceName());
                                }


                                if(vo.getBrightness() != null){
                                    queryWrapper.eq(SensorDataRecordAll::getBrightness, vo.getBrightness());
                                }


                                if(vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                                    queryWrapper.eq(SensorDataRecordAll::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
                                }


                                if(vo.getRecordTime() != null){
                                    queryWrapper.eq(SensorDataRecordAll::getRecordTime, vo.getRecordTime());
                                }

                // SensorDataRecordAll entity = this.sensorDataRecordAllService.getById(sensorDataRecordId);
                    final Page<SensorDataRecordAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    sensorDataRecordAllService.pageNew(page, vo, queryWrapper);
                    final List<SensorDataRecordAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public SensorDataRecordAll getById(Serializable sensorDataRecordId) {

                    LambdaQueryWrapper<SensorDataRecordAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(SensorDataRecordAll::getSensorDataRecordId, sensorDataRecordId);

                    final Page<SensorDataRecordAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    sensorDataRecordAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<SensorDataRecordAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
