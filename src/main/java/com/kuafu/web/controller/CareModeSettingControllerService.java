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
import com.kuafu.web.entity.CareModeSetting;
import com.kuafu.web.service.ICareModeSettingService;
import com.kuafu.web.vo.CareModeSettingPageVO;
import com.kuafu.web.vo.CareModeSettingVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 关怀模式 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("CareModeSettingControllerService")
@RequiredArgsConstructor
public class CareModeSettingControllerService  {

    private final ICareModeSettingService careModeSettingService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( CareModeSettingPageVO pageVO){
        IPage<CareModeSetting> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<CareModeSetting> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<CareModeSetting> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(CareModeSetting::getCareModeSettingId);

            if(pageVO.getCareModeSettingId() != null){
                queryWrapper.eq(CareModeSetting::getCareModeSettingId, pageVO.getCareModeSettingId());
            }


            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(CareModeSetting::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }


            if(pageVO.getEnabled() != null){
                queryWrapper.eq(CareModeSetting::getEnabled, pageVO.getEnabled());
            }

            return ResultUtils.success(careModeSettingService.page(page, queryWrapper));
        }


        public BaseResponse list(  CareModeSettingVO vo){
            LambdaQueryWrapper<CareModeSetting> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(CareModeSetting::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
                if(vo.getEnabled() != null){
                    queryWrapper.eq(CareModeSetting::getEnabled, vo.getEnabled());
                }
                return ResultUtils.success(careModeSettingService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  CareModeSettingVO vo) {
                CareModeSetting entity =  CareModeSetting.builder()
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .enabled(vo.getEnabled())
                .build();








                boolean flag =this.careModeSettingService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("care_mode_setting").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getCareModeSettingId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( CareModeSettingVO vo) {
                CareModeSetting entity =  CareModeSetting.builder()
                    .careModeSettingId(vo.getCareModeSettingId())
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .enabled(vo.getEnabled())
                .build();



                        boolean flag = this.careModeSettingService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getCareModeSettingId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( CareModeSettingVO vo ) {
                CareModeSetting entity = this.careModeSettingService.getById(vo.getCareModeSettingId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( CareModeSettingVO vo) {
                boolean flag = this.careModeSettingService.removeById(vo.getCareModeSettingId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
