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
import com.kuafu.web.entity.DeviceAlertRecord;
import com.kuafu.web.service.IDeviceAlertRecordService;
import com.kuafu.web.vo.DeviceAlertRecordPageVO;
import com.kuafu.web.vo.DeviceAlertRecordVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 设备告警记录表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("DeviceAlertRecordControllerService")
@RequiredArgsConstructor
public class DeviceAlertRecordControllerService  {

    private final IDeviceAlertRecordService deviceAlertRecordService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( DeviceAlertRecordPageVO pageVO){
        IPage<DeviceAlertRecord> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<DeviceAlertRecord> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<DeviceAlertRecord> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(DeviceAlertRecord::getDeviceAlertRecordId);

            if(pageVO.getDeviceAlertRecordId() != null){
                queryWrapper.eq(DeviceAlertRecord::getDeviceAlertRecordId, pageVO.getDeviceAlertRecordId());
            }


            if(pageVO.getSmartHomeDeviceSmartDeviceId1() != null){
                queryWrapper.eq(DeviceAlertRecord::getSmartHomeDeviceSmartDeviceId1, pageVO.getSmartHomeDeviceSmartDeviceId1());
            }


        if(StringUtils.isNotEmpty(pageVO.getAlertType())) {
                queryWrapper.eq(DeviceAlertRecord::getAlertType, pageVO.getAlertType());
            }


        if(StringUtils.isNotEmpty(pageVO.getAlertLevel())) {
                queryWrapper.eq(DeviceAlertRecord::getAlertLevel, pageVO.getAlertLevel());
            }


        if(StringUtils.isNotEmpty(pageVO.getAlertMessage())) {
                queryWrapper.eq(DeviceAlertRecord::getAlertMessage, pageVO.getAlertMessage());
            }


            if(pageVO.getIsResolved() != null){
                queryWrapper.eq(DeviceAlertRecord::getIsResolved, pageVO.getIsResolved());
            }


            if(pageVO.getCreateTime() != null){
                queryWrapper.eq(DeviceAlertRecord::getCreateTime, pageVO.getCreateTime());
            }

            return ResultUtils.success(deviceAlertRecordService.page(page, queryWrapper));
        }


        public BaseResponse list(  DeviceAlertRecordVO vo){
            LambdaQueryWrapper<DeviceAlertRecord> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getSmartHomeDeviceSmartDeviceId1() != null){
                    queryWrapper.eq(DeviceAlertRecord::getSmartHomeDeviceSmartDeviceId1, vo.getSmartHomeDeviceSmartDeviceId1());
                }
            if(StringUtils.isNotEmpty(vo.getAlertType())) {
                    queryWrapper.eq(DeviceAlertRecord::getAlertType, vo.getAlertType());
                }
            if(StringUtils.isNotEmpty(vo.getAlertLevel())) {
                    queryWrapper.eq(DeviceAlertRecord::getAlertLevel, vo.getAlertLevel());
                }
            if(StringUtils.isNotEmpty(vo.getAlertMessage())) {
                    queryWrapper.eq(DeviceAlertRecord::getAlertMessage, vo.getAlertMessage());
                }
                if(vo.getIsResolved() != null){
                    queryWrapper.eq(DeviceAlertRecord::getIsResolved, vo.getIsResolved());
                }
                if(vo.getCreateTime() != null){
                    queryWrapper.eq(DeviceAlertRecord::getCreateTime, vo.getCreateTime());
                }
                return ResultUtils.success(deviceAlertRecordService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  DeviceAlertRecordVO vo) {
                DeviceAlertRecord entity =  DeviceAlertRecord.builder()
                    .smartHomeDeviceSmartDeviceId1(vo.getSmartHomeDeviceSmartDeviceId1())
                    .alertType(vo.getAlertType())
                    .alertLevel(vo.getAlertLevel())
                    .alertMessage(vo.getAlertMessage())
                    .isResolved(vo.getIsResolved())
                .build();








                boolean flag =this.deviceAlertRecordService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("device_alert_record").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getDeviceAlertRecordId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( DeviceAlertRecordVO vo) {
                DeviceAlertRecord entity =  DeviceAlertRecord.builder()
                    .deviceAlertRecordId(vo.getDeviceAlertRecordId())
                    .smartHomeDeviceSmartDeviceId1(vo.getSmartHomeDeviceSmartDeviceId1())
                    .alertType(vo.getAlertType())
                    .alertLevel(vo.getAlertLevel())
                    .alertMessage(vo.getAlertMessage())
                    .isResolved(vo.getIsResolved())
                .build();



                        boolean flag = this.deviceAlertRecordService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getDeviceAlertRecordId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( DeviceAlertRecordVO vo ) {
                DeviceAlertRecord entity = this.deviceAlertRecordService.getById(vo.getDeviceAlertRecordId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( DeviceAlertRecordVO vo) {
                boolean flag = this.deviceAlertRecordService.removeById(vo.getDeviceAlertRecordId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
