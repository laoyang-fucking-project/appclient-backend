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
import com.kuafu.web.entity.DeviceTypeEnum;
import com.kuafu.web.service.IDeviceTypeEnumService;
import com.kuafu.web.vo.DeviceTypeEnumPageVO;
import com.kuafu.web.vo.DeviceTypeEnumVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 设备类型 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("DeviceTypeEnumControllerService")
@RequiredArgsConstructor
public class DeviceTypeEnumControllerService  {

    private final IDeviceTypeEnumService deviceTypeEnumService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( DeviceTypeEnumPageVO pageVO){
        IPage<DeviceTypeEnum> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<DeviceTypeEnum> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<DeviceTypeEnum> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(DeviceTypeEnum::getDeviceTypeEnumId);

            if(pageVO.getDeviceTypeEnumId() != null){
                queryWrapper.eq(DeviceTypeEnum::getDeviceTypeEnumId, pageVO.getDeviceTypeEnumId());
            }


        if(StringUtils.isNotEmpty(pageVO.getTypeName())) {
//                        queryWrapper.like(DeviceTypeEnum::getTypeName, pageVO.getTypeName());
                        String s_string = pageVO.getTypeName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(DeviceTypeEnum::getTypeName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

            return ResultUtils.success(deviceTypeEnumService.page(page, queryWrapper));
        }


        public BaseResponse list(  DeviceTypeEnumVO vo){
            LambdaQueryWrapper<DeviceTypeEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                            queryWrapper.like(DeviceTypeEnum::getTypeName, vo.getTypeName());
                }
                return ResultUtils.success(deviceTypeEnumService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  DeviceTypeEnumVO vo) {
                DeviceTypeEnum entity =  DeviceTypeEnum.builder()
                    .typeName(vo.getTypeName())
                .build();








                boolean flag =this.deviceTypeEnumService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("device_type_enum").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getDeviceTypeEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( DeviceTypeEnumVO vo) {
                DeviceTypeEnum entity =  DeviceTypeEnum.builder()
                    .deviceTypeEnumId(vo.getDeviceTypeEnumId())
                    .typeName(vo.getTypeName())
                .build();



                        boolean flag = this.deviceTypeEnumService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getDeviceTypeEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( DeviceTypeEnumVO vo ) {
                DeviceTypeEnum entity = this.deviceTypeEnumService.getById(vo.getDeviceTypeEnumId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( DeviceTypeEnumVO vo) {
                boolean flag = this.deviceTypeEnumService.removeById(vo.getDeviceTypeEnumId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
