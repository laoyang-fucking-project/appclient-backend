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
import com.kuafu.web.entity.SmartHomeDevice;
import com.kuafu.web.service.ISmartHomeDeviceService;
import com.kuafu.web.vo.SmartHomeDevicePageVO;
import com.kuafu.web.vo.SmartHomeDeviceVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 智能家居设备表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("SmartHomeDeviceControllerService")
@RequiredArgsConstructor
public class SmartHomeDeviceControllerService  {

    private final ISmartHomeDeviceService smartHomeDeviceService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( SmartHomeDevicePageVO pageVO){
        IPage<SmartHomeDevice> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<SmartHomeDevice> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<SmartHomeDevice> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(SmartHomeDevice::getSmartDeviceId);

            if(pageVO.getSmartDeviceId() != null){
                queryWrapper.eq(SmartHomeDevice::getSmartDeviceId, pageVO.getSmartDeviceId());
            }


        if(StringUtils.isNotEmpty(pageVO.getDeviceName())) {
//                        queryWrapper.like(SmartHomeDevice::getDeviceName, pageVO.getDeviceName());
                        String s_string = pageVO.getDeviceName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SmartHomeDevice::getDeviceName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }


            if(pageVO.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                queryWrapper.eq(SmartHomeDevice::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, pageVO.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
            }


            if(pageVO.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                queryWrapper.eq(SmartHomeDevice::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, pageVO.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
            }


        if(StringUtils.isNotEmpty(pageVO.getRoomName())) {
//                        queryWrapper.like(SmartHomeDevice::getRoomName, pageVO.getRoomName());
                        String s_string = pageVO.getRoomName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SmartHomeDevice::getRoomName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }


        if(StringUtils.isNotEmpty(pageVO.getCurrentValue())) {
                queryWrapper.eq(SmartHomeDevice::getCurrentValue, pageVO.getCurrentValue());
            }


            if(pageVO.getIsOn() != null){
                queryWrapper.eq(SmartHomeDevice::getIsOn, pageVO.getIsOn());
            }


            if(pageVO.getBrightness() != null){
                queryWrapper.eq(SmartHomeDevice::getBrightness, pageVO.getBrightness());
            }


            if(pageVO.getLastUpdateTime() != null){
                queryWrapper.eq(SmartHomeDevice::getLastUpdateTime, pageVO.getLastUpdateTime());
            }


            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(SmartHomeDevice::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }

            return ResultUtils.success(smartHomeDeviceService.page(page, queryWrapper));
        }


        public BaseResponse list(  SmartHomeDeviceVO vo){
            LambdaQueryWrapper<SmartHomeDevice> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                            queryWrapper.like(SmartHomeDevice::getDeviceName, vo.getDeviceName());
                }
                if(vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1() != null){
                    queryWrapper.eq(SmartHomeDevice::getSmartDeviceTypeEnumSmartDeviceTypeEnumId1, vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1());
                }
                if(vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1() != null){
                    queryWrapper.eq(SmartHomeDevice::getSmartDeviceStatusEnumSmartDeviceStatusEnumId1, vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getRoomName())) {
                            queryWrapper.like(SmartHomeDevice::getRoomName, vo.getRoomName());
                }
            if(StringUtils.isNotEmpty(vo.getCurrentValue())) {
                    queryWrapper.eq(SmartHomeDevice::getCurrentValue, vo.getCurrentValue());
                }
                if(vo.getIsOn() != null){
                    queryWrapper.eq(SmartHomeDevice::getIsOn, vo.getIsOn());
                }
                if(vo.getBrightness() != null){
                    queryWrapper.eq(SmartHomeDevice::getBrightness, vo.getBrightness());
                }
                if(vo.getLastUpdateTime() != null){
                    queryWrapper.eq(SmartHomeDevice::getLastUpdateTime, vo.getLastUpdateTime());
                }
                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(SmartHomeDevice::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
                return ResultUtils.success(smartHomeDeviceService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  SmartHomeDeviceVO vo) {
                SmartHomeDevice entity =  SmartHomeDevice.builder()
                    .deviceName(vo.getDeviceName())
                    .smartDeviceTypeEnumSmartDeviceTypeEnumId1(vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1())
                    .smartDeviceStatusEnumSmartDeviceStatusEnumId1(vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1())
                    .roomName(vo.getRoomName())
                    .currentValue(vo.getCurrentValue())
                    .isOn(vo.getIsOn())
                    .brightness(vo.getBrightness())
                    .lastUpdateTime(vo.getLastUpdateTime())
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                .build();








                boolean flag =this.smartHomeDeviceService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("smart_home_device").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getSmartDeviceId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( SmartHomeDeviceVO vo) {
                SmartHomeDevice entity =  SmartHomeDevice.builder()
                    .smartDeviceId(vo.getSmartDeviceId())
                    .deviceName(vo.getDeviceName())
                    .smartDeviceTypeEnumSmartDeviceTypeEnumId1(vo.getSmartDeviceTypeEnumSmartDeviceTypeEnumId1())
                    .smartDeviceStatusEnumSmartDeviceStatusEnumId1(vo.getSmartDeviceStatusEnumSmartDeviceStatusEnumId1())
                    .roomName(vo.getRoomName())
                    .currentValue(vo.getCurrentValue())
                    .isOn(vo.getIsOn())
                    .brightness(vo.getBrightness())
                    .lastUpdateTime(vo.getLastUpdateTime())
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                .build();



                        boolean flag = this.smartHomeDeviceService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getSmartDeviceId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( SmartHomeDeviceVO vo ) {
                SmartHomeDevice entity = this.smartHomeDeviceService.getById(vo.getSmartDeviceId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( SmartHomeDeviceVO vo) {
                boolean flag = this.smartHomeDeviceService.removeById(vo.getSmartDeviceId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
