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
import com.kuafu.web.entity.DeviceStatusAll;
import com.kuafu.web.service.IDeviceStatusAllService;
import com.kuafu.web.vo.DeviceStatusAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.IDeviceTypeEnumService;
import com.kuafu.web.entity.DeviceTypeEnum;
import com.kuafu.web.service.IDeviceStatusEnumService;
import com.kuafu.web.entity.DeviceStatusEnum;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 设备状态 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("DeviceStatusAllControllerService")
public class DeviceStatusAllControllerService implements IControllerService<DeviceStatusAll> {


@Autowired
    private  IDeviceStatusAllService deviceStatusAllService;








    public BaseResponse page( DeviceStatusAllPageVO pageVO){
        IPage<DeviceStatusAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<DeviceStatusAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("ds.device_status_id");
        LambdaQueryWrapper<DeviceStatusAll> queryWrapper = objectQueryWrapper.lambda();


            if(pageVO.getLastUpdateTime() != null){
                queryWrapper.eq(DeviceStatusAll::getLastUpdateTime, pageVO.getLastUpdateTime());
            }
            if(pageVO.getDeviceStatusId() != null){
                queryWrapper.eq(DeviceStatusAll::getDeviceStatusId, pageVO.getDeviceStatusId());
            }
        if(StringUtils.isNotEmpty(pageVO.getDeviceName())) {

                        String s_string = pageVO.getDeviceName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(DeviceStatusAll::getDeviceName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
        if(StringUtils.isNotEmpty(pageVO.getTypeName())) {

                        String s_string = pageVO.getTypeName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(DeviceStatusAll::getTypeName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
        if(StringUtils.isNotEmpty(pageVO.getStatusName())) {

                        String s_string = pageVO.getStatusName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(DeviceStatusAll::getStatusName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getDeviceTypeEnumDeviceTypeEnumId1() != null){
                queryWrapper.eq(DeviceStatusAll::getDeviceTypeEnumDeviceTypeEnumId1, pageVO.getDeviceTypeEnumDeviceTypeEnumId1());
            }
            if(pageVO.getDeviceStatusEnumDeviceStatusEnumId1() != null){
                queryWrapper.eq(DeviceStatusAll::getDeviceStatusEnumDeviceStatusEnumId1, pageVO.getDeviceStatusEnumDeviceStatusEnumId1());
            }

                    deviceStatusAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(DeviceStatusAllPageVO vo){
            LambdaQueryWrapper<DeviceStatusAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getLastUpdateTime() != null){
                    queryWrapper.eq(DeviceStatusAll::getLastUpdateTime, vo.getLastUpdateTime());
                }
            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                            queryWrapper.like(DeviceStatusAll::getDeviceName, vo.getDeviceName());
                }
            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                            queryWrapper.like(DeviceStatusAll::getTypeName, vo.getTypeName());
                }
            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                            queryWrapper.like(DeviceStatusAll::getStatusName, vo.getStatusName());
                }
                if(vo.getDeviceTypeEnumDeviceTypeEnumId1() != null){
                    queryWrapper.eq(DeviceStatusAll::getDeviceTypeEnumDeviceTypeEnumId1, vo.getDeviceTypeEnumDeviceTypeEnumId1());
                }
                if(vo.getDeviceStatusEnumDeviceStatusEnumId1() != null){
                    queryWrapper.eq(DeviceStatusAll::getDeviceStatusEnumDeviceStatusEnumId1, vo.getDeviceStatusEnumDeviceStatusEnumId1());
                }
                return ResultUtils.success(deviceStatusAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(DeviceStatusAllPageVO vo) {


                LambdaQueryWrapper<DeviceStatusAll> queryWrapper = new LambdaQueryWrapper<>();


                                if(vo.getLastUpdateTime() != null){
                                    queryWrapper.eq(DeviceStatusAll::getLastUpdateTime, vo.getLastUpdateTime());
                                }


                                if(vo.getDeviceStatusId() != null){
                                    queryWrapper.eq(DeviceStatusAll::getDeviceStatusId, vo.getDeviceStatusId());
                                }


                            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                                            queryWrapper.like(DeviceStatusAll::getDeviceName, vo.getDeviceName());
                                }


                            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                                            queryWrapper.like(DeviceStatusAll::getTypeName, vo.getTypeName());
                                }


                            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                                            queryWrapper.like(DeviceStatusAll::getStatusName, vo.getStatusName());
                                }


                                if(vo.getDeviceTypeEnumDeviceTypeEnumId1() != null){
                                    queryWrapper.eq(DeviceStatusAll::getDeviceTypeEnumDeviceTypeEnumId1, vo.getDeviceTypeEnumDeviceTypeEnumId1());
                                }


                                if(vo.getDeviceStatusEnumDeviceStatusEnumId1() != null){
                                    queryWrapper.eq(DeviceStatusAll::getDeviceStatusEnumDeviceStatusEnumId1, vo.getDeviceStatusEnumDeviceStatusEnumId1());
                                }

                // DeviceStatusAll entity = this.deviceStatusAllService.getById(deviceStatusId);
                    final Page<DeviceStatusAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    deviceStatusAllService.pageNew(page, vo, queryWrapper);
                    final List<DeviceStatusAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public DeviceStatusAll getById(Serializable deviceStatusId) {

                    LambdaQueryWrapper<DeviceStatusAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(DeviceStatusAll::getDeviceStatusId, deviceStatusId);

                    final Page<DeviceStatusAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    deviceStatusAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<DeviceStatusAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
