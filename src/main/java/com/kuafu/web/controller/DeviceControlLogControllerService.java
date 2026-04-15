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
import com.kuafu.web.entity.DeviceControlLog;
import com.kuafu.web.service.IDeviceControlLogService;
import com.kuafu.web.vo.DeviceControlLogPageVO;
import com.kuafu.web.vo.DeviceControlLogVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 设备控制记录表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("DeviceControlLogControllerService")
@RequiredArgsConstructor
public class DeviceControlLogControllerService  {

    private final IDeviceControlLogService deviceControlLogService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( DeviceControlLogPageVO pageVO){
        IPage<DeviceControlLog> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<DeviceControlLog> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<DeviceControlLog> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(DeviceControlLog::getDeviceControlLogId);

            if(pageVO.getDeviceControlLogId() != null){
                queryWrapper.eq(DeviceControlLog::getDeviceControlLogId, pageVO.getDeviceControlLogId());
            }


            if(pageVO.getSmartHomeDeviceSmartDeviceId1() != null){
                queryWrapper.eq(DeviceControlLog::getSmartHomeDeviceSmartDeviceId1, pageVO.getSmartHomeDeviceSmartDeviceId1());
            }


            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(DeviceControlLog::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }


        if(StringUtils.isNotEmpty(pageVO.getActionType())) {
                queryWrapper.eq(DeviceControlLog::getActionType, pageVO.getActionType());
            }


        if(StringUtils.isNotEmpty(pageVO.getActionValue())) {
                queryWrapper.eq(DeviceControlLog::getActionValue, pageVO.getActionValue());
            }


            if(pageVO.getCreateTime() != null){
                queryWrapper.eq(DeviceControlLog::getCreateTime, pageVO.getCreateTime());
            }

            return ResultUtils.success(deviceControlLogService.page(page, queryWrapper));
        }


        public BaseResponse list(  DeviceControlLogVO vo){
            LambdaQueryWrapper<DeviceControlLog> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getSmartHomeDeviceSmartDeviceId1() != null){
                    queryWrapper.eq(DeviceControlLog::getSmartHomeDeviceSmartDeviceId1, vo.getSmartHomeDeviceSmartDeviceId1());
                }
                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(DeviceControlLog::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
            if(StringUtils.isNotEmpty(vo.getActionType())) {
                    queryWrapper.eq(DeviceControlLog::getActionType, vo.getActionType());
                }
            if(StringUtils.isNotEmpty(vo.getActionValue())) {
                    queryWrapper.eq(DeviceControlLog::getActionValue, vo.getActionValue());
                }
                if(vo.getCreateTime() != null){
                    queryWrapper.eq(DeviceControlLog::getCreateTime, vo.getCreateTime());
                }
                return ResultUtils.success(deviceControlLogService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  DeviceControlLogVO vo) {
                DeviceControlLog entity =  DeviceControlLog.builder()
                    .smartHomeDeviceSmartDeviceId1(vo.getSmartHomeDeviceSmartDeviceId1())
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .actionType(vo.getActionType())
                    .actionValue(vo.getActionValue())
                .build();








                boolean flag =this.deviceControlLogService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("device_control_log").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getDeviceControlLogId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( DeviceControlLogVO vo) {
                DeviceControlLog entity =  DeviceControlLog.builder()
                    .deviceControlLogId(vo.getDeviceControlLogId())
                    .smartHomeDeviceSmartDeviceId1(vo.getSmartHomeDeviceSmartDeviceId1())
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .actionType(vo.getActionType())
                    .actionValue(vo.getActionValue())
                .build();



                        boolean flag = this.deviceControlLogService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getDeviceControlLogId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( DeviceControlLogVO vo ) {
                DeviceControlLog entity = this.deviceControlLogService.getById(vo.getDeviceControlLogId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( DeviceControlLogVO vo) {
                boolean flag = this.deviceControlLogService.removeById(vo.getDeviceControlLogId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
