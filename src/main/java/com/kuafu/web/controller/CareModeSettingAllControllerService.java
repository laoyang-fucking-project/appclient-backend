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
import com.kuafu.web.entity.CareModeSettingAll;
import com.kuafu.web.service.ICareModeSettingAllService;
import com.kuafu.web.vo.CareModeSettingAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 关怀模式 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("CareModeSettingAllControllerService")
public class CareModeSettingAllControllerService implements IControllerService<CareModeSettingAll> {


@Autowired
    private  ICareModeSettingAllService careModeSettingAllService;








    public BaseResponse page( CareModeSettingAllPageVO pageVO){
        IPage<CareModeSettingAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<CareModeSettingAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("cms.care_mode_setting_id");
        LambdaQueryWrapper<CareModeSettingAll> queryWrapper = objectQueryWrapper.lambda();


        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
                queryWrapper.like(CareModeSettingAll::getPassword, pageVO.getPassword());
            }
            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(CareModeSettingAll::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }
            if(pageVO.getCareModeSettingId() != null){
                queryWrapper.eq(CareModeSettingAll::getCareModeSettingId, pageVO.getCareModeSettingId());
            }
            if(pageVO.getRoleEnumRoleEnumId1() != null){
                queryWrapper.eq(CareModeSettingAll::getRoleEnumRoleEnumId1, pageVO.getRoleEnumRoleEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
                queryWrapper.like(CareModeSettingAll::getPhoneNumber, pageVO.getPhoneNumber());
            }
            if(pageVO.getEnabled() != null){
                queryWrapper.eq(CareModeSettingAll::getEnabled, pageVO.getEnabled());
            }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {

                        String s_string = pageVO.getUsername();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(CareModeSettingAll::getUsername, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

                    careModeSettingAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(CareModeSettingAllPageVO vo){
            LambdaQueryWrapper<CareModeSettingAll> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getPassword())) {
                    queryWrapper.eq(CareModeSettingAll::getPassword, vo.getPassword());
                }
                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(CareModeSettingAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
                if(vo.getRoleEnumRoleEnumId1() != null){
                    queryWrapper.eq(CareModeSettingAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                    queryWrapper.eq(CareModeSettingAll::getPhoneNumber, vo.getPhoneNumber());
                }
                if(vo.getEnabled() != null){
                    queryWrapper.eq(CareModeSettingAll::getEnabled, vo.getEnabled());
                }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
                            queryWrapper.like(CareModeSettingAll::getUsername, vo.getUsername());
                }
                return ResultUtils.success(careModeSettingAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(CareModeSettingAllPageVO vo) {


                LambdaQueryWrapper<CareModeSettingAll> queryWrapper = new LambdaQueryWrapper<>();


                            if(StringUtils.isNotEmpty(vo.getPassword())) {
                                    queryWrapper.eq(CareModeSettingAll::getPassword, vo.getPassword());
                                }


                                if(vo.getUserInfoUserInfoId1() != null){
                                    queryWrapper.eq(CareModeSettingAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                                }


                                if(vo.getCareModeSettingId() != null){
                                    queryWrapper.eq(CareModeSettingAll::getCareModeSettingId, vo.getCareModeSettingId());
                                }


                                if(vo.getRoleEnumRoleEnumId1() != null){
                                    queryWrapper.eq(CareModeSettingAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                                    queryWrapper.eq(CareModeSettingAll::getPhoneNumber, vo.getPhoneNumber());
                                }


                                if(vo.getEnabled() != null){
                                    queryWrapper.eq(CareModeSettingAll::getEnabled, vo.getEnabled());
                                }


                            if(StringUtils.isNotEmpty(vo.getUsername())) {
                                            queryWrapper.like(CareModeSettingAll::getUsername, vo.getUsername());
                                }

                // CareModeSettingAll entity = this.careModeSettingAllService.getById(careModeSettingId);
                    final Page<CareModeSettingAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    careModeSettingAllService.pageNew(page, vo, queryWrapper);
                    final List<CareModeSettingAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public CareModeSettingAll getById(Serializable careModeSettingId) {

                    LambdaQueryWrapper<CareModeSettingAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(CareModeSettingAll::getCareModeSettingId, careModeSettingId);

                    final Page<CareModeSettingAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    careModeSettingAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<CareModeSettingAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
