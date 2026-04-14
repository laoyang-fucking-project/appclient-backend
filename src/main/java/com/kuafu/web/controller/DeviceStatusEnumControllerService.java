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
import com.kuafu.web.entity.DeviceStatusEnum;
import com.kuafu.web.service.IDeviceStatusEnumService;
import com.kuafu.web.vo.DeviceStatusEnumPageVO;
import com.kuafu.web.vo.DeviceStatusEnumVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 设备状态 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("DeviceStatusEnumControllerService")
@RequiredArgsConstructor
public class DeviceStatusEnumControllerService  {

    private final IDeviceStatusEnumService deviceStatusEnumService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( DeviceStatusEnumPageVO pageVO){
        IPage<DeviceStatusEnum> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<DeviceStatusEnum> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<DeviceStatusEnum> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(DeviceStatusEnum::getDeviceStatusEnumId);

            if(pageVO.getDeviceStatusEnumId() != null){
                queryWrapper.eq(DeviceStatusEnum::getDeviceStatusEnumId, pageVO.getDeviceStatusEnumId());
            }


        if(StringUtils.isNotEmpty(pageVO.getStatusName())) {
//                        queryWrapper.like(DeviceStatusEnum::getStatusName, pageVO.getStatusName());
                        String s_string = pageVO.getStatusName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(DeviceStatusEnum::getStatusName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

            return ResultUtils.success(deviceStatusEnumService.page(page, queryWrapper));
        }


        public BaseResponse list(  DeviceStatusEnumVO vo){
            LambdaQueryWrapper<DeviceStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                            queryWrapper.like(DeviceStatusEnum::getStatusName, vo.getStatusName());
                }
                return ResultUtils.success(deviceStatusEnumService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  DeviceStatusEnumVO vo) {
                DeviceStatusEnum entity =  DeviceStatusEnum.builder()
                    .statusName(vo.getStatusName())
                .build();








                boolean flag =this.deviceStatusEnumService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("device_status_enum").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getDeviceStatusEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( DeviceStatusEnumVO vo) {
                DeviceStatusEnum entity =  DeviceStatusEnum.builder()
                    .deviceStatusEnumId(vo.getDeviceStatusEnumId())
                    .statusName(vo.getStatusName())
                .build();



                        boolean flag = this.deviceStatusEnumService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getDeviceStatusEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( DeviceStatusEnumVO vo ) {
                DeviceStatusEnum entity = this.deviceStatusEnumService.getById(vo.getDeviceStatusEnumId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( DeviceStatusEnumVO vo) {
                boolean flag = this.deviceStatusEnumService.removeById(vo.getDeviceStatusEnumId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
