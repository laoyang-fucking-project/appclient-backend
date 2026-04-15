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
import com.kuafu.web.entity.SensorDataRecord;
import com.kuafu.web.service.ISensorDataRecordService;
import com.kuafu.web.vo.SensorDataRecordPageVO;
import com.kuafu.web.vo.SensorDataRecordVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 传感器数据记录表 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("SensorDataRecordControllerService")
@RequiredArgsConstructor
public class SensorDataRecordControllerService  {

    private final ISensorDataRecordService sensorDataRecordService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( SensorDataRecordPageVO pageVO){
        IPage<SensorDataRecord> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<SensorDataRecord> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<SensorDataRecord> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(SensorDataRecord::getSensorDataRecordId);

            if(pageVO.getSensorDataRecordId() != null){
                queryWrapper.eq(SensorDataRecord::getSensorDataRecordId, pageVO.getSensorDataRecordId());
            }


            if(pageVO.getSmartHomeDeviceSmartDeviceId1() != null){
                queryWrapper.eq(SensorDataRecord::getSmartHomeDeviceSmartDeviceId1, pageVO.getSmartHomeDeviceSmartDeviceId1());
            }


        if(StringUtils.isNotEmpty(pageVO.getSensorValue())) {
                queryWrapper.eq(SensorDataRecord::getSensorValue, pageVO.getSensorValue());
            }


            if(pageVO.getRecordTime() != null){
                queryWrapper.eq(SensorDataRecord::getRecordTime, pageVO.getRecordTime());
            }

            return ResultUtils.success(sensorDataRecordService.page(page, queryWrapper));
        }


        public BaseResponse list(  SensorDataRecordVO vo){
            LambdaQueryWrapper<SensorDataRecord> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getSmartHomeDeviceSmartDeviceId1() != null){
                    queryWrapper.eq(SensorDataRecord::getSmartHomeDeviceSmartDeviceId1, vo.getSmartHomeDeviceSmartDeviceId1());
                }
            if(StringUtils.isNotEmpty(vo.getSensorValue())) {
                    queryWrapper.eq(SensorDataRecord::getSensorValue, vo.getSensorValue());
                }
                if(vo.getRecordTime() != null){
                    queryWrapper.eq(SensorDataRecord::getRecordTime, vo.getRecordTime());
                }
                return ResultUtils.success(sensorDataRecordService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  SensorDataRecordVO vo) {
                SensorDataRecord entity =  SensorDataRecord.builder()
                    .smartHomeDeviceSmartDeviceId1(vo.getSmartHomeDeviceSmartDeviceId1())
                    .sensorValue(vo.getSensorValue())
                    .recordTime(vo.getRecordTime())
                .build();








                boolean flag =this.sensorDataRecordService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("sensor_data_record").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getSensorDataRecordId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( SensorDataRecordVO vo) {
                SensorDataRecord entity =  SensorDataRecord.builder()
                    .sensorDataRecordId(vo.getSensorDataRecordId())
                    .smartHomeDeviceSmartDeviceId1(vo.getSmartHomeDeviceSmartDeviceId1())
                    .sensorValue(vo.getSensorValue())
                    .recordTime(vo.getRecordTime())
                .build();



                        boolean flag = this.sensorDataRecordService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getSensorDataRecordId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( SensorDataRecordVO vo ) {
                SensorDataRecord entity = this.sensorDataRecordService.getById(vo.getSensorDataRecordId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( SensorDataRecordVO vo) {
                boolean flag = this.sensorDataRecordService.removeById(vo.getSensorDataRecordId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
