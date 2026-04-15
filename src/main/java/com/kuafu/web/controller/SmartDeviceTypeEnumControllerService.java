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
import com.kuafu.web.entity.SmartDeviceTypeEnum;
import com.kuafu.web.service.ISmartDeviceTypeEnumService;
import com.kuafu.web.vo.SmartDeviceTypeEnumPageVO;
import com.kuafu.web.vo.SmartDeviceTypeEnumVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 设备类型枚举表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("SmartDeviceTypeEnumControllerService")
@RequiredArgsConstructor
public class SmartDeviceTypeEnumControllerService  {

    private final ISmartDeviceTypeEnumService smartDeviceTypeEnumService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( SmartDeviceTypeEnumPageVO pageVO){
        IPage<SmartDeviceTypeEnum> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<SmartDeviceTypeEnum> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<SmartDeviceTypeEnum> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(SmartDeviceTypeEnum::getSmartDeviceTypeEnumId);

            if(pageVO.getSmartDeviceTypeEnumId() != null){
                queryWrapper.eq(SmartDeviceTypeEnum::getSmartDeviceTypeEnumId, pageVO.getSmartDeviceTypeEnumId());
            }


        if(StringUtils.isNotEmpty(pageVO.getTypeName())) {
//                        queryWrapper.like(SmartDeviceTypeEnum::getTypeName, pageVO.getTypeName());
                        String s_string = pageVO.getTypeName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SmartDeviceTypeEnum::getTypeName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

            return ResultUtils.success(smartDeviceTypeEnumService.page(page, queryWrapper));
        }


        public BaseResponse list(  SmartDeviceTypeEnumVO vo){
            LambdaQueryWrapper<SmartDeviceTypeEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                            queryWrapper.like(SmartDeviceTypeEnum::getTypeName, vo.getTypeName());
                }
                return ResultUtils.success(smartDeviceTypeEnumService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  SmartDeviceTypeEnumVO vo) {
                SmartDeviceTypeEnum entity =  SmartDeviceTypeEnum.builder()
                    .typeName(vo.getTypeName())
                .build();








                boolean flag =this.smartDeviceTypeEnumService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("smart_device_type_enum").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getSmartDeviceTypeEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( SmartDeviceTypeEnumVO vo) {
                SmartDeviceTypeEnum entity =  SmartDeviceTypeEnum.builder()
                    .smartDeviceTypeEnumId(vo.getSmartDeviceTypeEnumId())
                    .typeName(vo.getTypeName())
                .build();



                        boolean flag = this.smartDeviceTypeEnumService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getSmartDeviceTypeEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( SmartDeviceTypeEnumVO vo ) {
                SmartDeviceTypeEnum entity = this.smartDeviceTypeEnumService.getById(vo.getSmartDeviceTypeEnumId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( SmartDeviceTypeEnumVO vo) {
                boolean flag = this.smartDeviceTypeEnumService.removeById(vo.getSmartDeviceTypeEnumId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
