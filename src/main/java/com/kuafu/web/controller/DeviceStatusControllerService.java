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
import com.kuafu.web.entity.DeviceStatus;
import com.kuafu.web.service.IDeviceStatusService;
import com.kuafu.web.vo.DeviceStatusPageVO;
import com.kuafu.web.vo.DeviceStatusVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 设备状态 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("DeviceStatusControllerService")
@RequiredArgsConstructor
public class DeviceStatusControllerService  {

    private final IDeviceStatusService deviceStatusService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( DeviceStatusPageVO pageVO){
        IPage<DeviceStatus> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<DeviceStatus> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<DeviceStatus> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(DeviceStatus::getDeviceStatusId);

            if(pageVO.getDeviceStatusId() != null){
                queryWrapper.eq(DeviceStatus::getDeviceStatusId, pageVO.getDeviceStatusId());
            }


        if(StringUtils.isNotEmpty(pageVO.getDeviceName())) {
//                        queryWrapper.like(DeviceStatus::getDeviceName, pageVO.getDeviceName());
                        String s_string = pageVO.getDeviceName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(DeviceStatus::getDeviceName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }


            if(pageVO.getDeviceTypeEnumDeviceTypeEnumId1() != null){
                queryWrapper.eq(DeviceStatus::getDeviceTypeEnumDeviceTypeEnumId1, pageVO.getDeviceTypeEnumDeviceTypeEnumId1());
            }


            if(pageVO.getDeviceStatusEnumDeviceStatusEnumId1() != null){
                queryWrapper.eq(DeviceStatus::getDeviceStatusEnumDeviceStatusEnumId1, pageVO.getDeviceStatusEnumDeviceStatusEnumId1());
            }


            if(pageVO.getLastUpdateTime() != null){
                queryWrapper.eq(DeviceStatus::getLastUpdateTime, pageVO.getLastUpdateTime());
            }

            return ResultUtils.success(deviceStatusService.page(page, queryWrapper));
        }


        public BaseResponse list(  DeviceStatusVO vo){
            LambdaQueryWrapper<DeviceStatus> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getDeviceName())) {
                            queryWrapper.like(DeviceStatus::getDeviceName, vo.getDeviceName());
                }
                if(vo.getDeviceTypeEnumDeviceTypeEnumId1() != null){
                    queryWrapper.eq(DeviceStatus::getDeviceTypeEnumDeviceTypeEnumId1, vo.getDeviceTypeEnumDeviceTypeEnumId1());
                }
                if(vo.getDeviceStatusEnumDeviceStatusEnumId1() != null){
                    queryWrapper.eq(DeviceStatus::getDeviceStatusEnumDeviceStatusEnumId1, vo.getDeviceStatusEnumDeviceStatusEnumId1());
                }
                if(vo.getLastUpdateTime() != null){
                    queryWrapper.eq(DeviceStatus::getLastUpdateTime, vo.getLastUpdateTime());
                }
                return ResultUtils.success(deviceStatusService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  DeviceStatusVO vo) {
                DeviceStatus entity =  DeviceStatus.builder()
                    .deviceName(vo.getDeviceName())
                    .deviceTypeEnumDeviceTypeEnumId1(vo.getDeviceTypeEnumDeviceTypeEnumId1())
                    .deviceStatusEnumDeviceStatusEnumId1(vo.getDeviceStatusEnumDeviceStatusEnumId1())
                    .lastUpdateTime(vo.getLastUpdateTime())
                .build();








                boolean flag =this.deviceStatusService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("device_status").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getDeviceStatusId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( DeviceStatusVO vo) {
                DeviceStatus entity =  DeviceStatus.builder()
                    .deviceStatusId(vo.getDeviceStatusId())
                    .deviceName(vo.getDeviceName())
                    .deviceTypeEnumDeviceTypeEnumId1(vo.getDeviceTypeEnumDeviceTypeEnumId1())
                    .deviceStatusEnumDeviceStatusEnumId1(vo.getDeviceStatusEnumDeviceStatusEnumId1())
                    .lastUpdateTime(vo.getLastUpdateTime())
                .build();



                        boolean flag = this.deviceStatusService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getDeviceStatusId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( DeviceStatusVO vo ) {
                DeviceStatus entity = this.deviceStatusService.getById(vo.getDeviceStatusId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( DeviceStatusVO vo) {
                boolean flag = this.deviceStatusService.removeById(vo.getDeviceStatusId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
