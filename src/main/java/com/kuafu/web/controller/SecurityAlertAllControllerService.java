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
import com.kuafu.web.entity.SecurityAlertAll;
import com.kuafu.web.service.ISecurityAlertAllService;
import com.kuafu.web.vo.SecurityAlertAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.IAlertTypeEnumService;
import com.kuafu.web.entity.AlertTypeEnum;
import com.kuafu.web.service.IAlertLevelEnumService;
import com.kuafu.web.entity.AlertLevelEnum;
import com.kuafu.web.service.IAlertStatusEnumService;
import com.kuafu.web.entity.AlertStatusEnum;
import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 安全预警 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Service("SecurityAlertAllControllerService")
public class SecurityAlertAllControllerService implements IControllerService<SecurityAlertAll> {


@Autowired
    private  ISecurityAlertAllService securityAlertAllService;








    public BaseResponse page( SecurityAlertAllPageVO pageVO){
        IPage<SecurityAlertAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<SecurityAlertAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("sa.security_alert_id");
        LambdaQueryWrapper<SecurityAlertAll> queryWrapper = objectQueryWrapper.lambda();


            if(pageVO.getAlertStatusEnumAlertStatusEnumId1() != null){
                queryWrapper.eq(SecurityAlertAll::getAlertStatusEnumAlertStatusEnumId1, pageVO.getAlertStatusEnumAlertStatusEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getTypeName())) {

                        String s_string = pageVO.getTypeName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SecurityAlertAll::getTypeName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getCreateTime() != null){
                queryWrapper.eq(SecurityAlertAll::getCreateTime, pageVO.getCreateTime());
            }
        if(StringUtils.isNotEmpty(pageVO.getStatusName())) {

                        String s_string = pageVO.getStatusName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SecurityAlertAll::getStatusName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
        if(StringUtils.isNotEmpty(pageVO.getDescription())) {
                queryWrapper.like(SecurityAlertAll::getDescription, pageVO.getDescription());
            }
            if(pageVO.getRoleEnumRoleEnumId1() != null){
                queryWrapper.eq(SecurityAlertAll::getRoleEnumRoleEnumId1, pageVO.getRoleEnumRoleEnumId1());
            }
            if(pageVO.getSecurityAlertId() != null){
                queryWrapper.eq(SecurityAlertAll::getSecurityAlertId, pageVO.getSecurityAlertId());
            }
            if(pageVO.getReportUserInfoUserInfoId1() != null){
                queryWrapper.eq(SecurityAlertAll::getReportUserInfoUserInfoId1, pageVO.getReportUserInfoUserInfoId1());
            }
            if(pageVO.getAlertLevelEnumAlertLevelEnumId1() != null){
                queryWrapper.eq(SecurityAlertAll::getAlertLevelEnumAlertLevelEnumId1, pageVO.getAlertLevelEnumAlertLevelEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
                queryWrapper.like(SecurityAlertAll::getPassword, pageVO.getPassword());
            }
        if(StringUtils.isNotEmpty(pageVO.getLevelName())) {

                        String s_string = pageVO.getLevelName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SecurityAlertAll::getLevelName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getAlertTypeEnumAlertTypeEnumId1() != null){
                queryWrapper.eq(SecurityAlertAll::getAlertTypeEnumAlertTypeEnumId1, pageVO.getAlertTypeEnumAlertTypeEnumId1());
            }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
                queryWrapper.like(SecurityAlertAll::getPhoneNumber, pageVO.getPhoneNumber());
            }
        if(StringUtils.isNotEmpty(pageVO.getProcessProgress())) {
                queryWrapper.like(SecurityAlertAll::getProcessProgress, pageVO.getProcessProgress());
            }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {

                        String s_string = pageVO.getUsername();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(SecurityAlertAll::getUsername, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

                    securityAlertAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(SecurityAlertAllPageVO vo){
            LambdaQueryWrapper<SecurityAlertAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getAlertStatusEnumAlertStatusEnumId1() != null){
                    queryWrapper.eq(SecurityAlertAll::getAlertStatusEnumAlertStatusEnumId1, vo.getAlertStatusEnumAlertStatusEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                            queryWrapper.like(SecurityAlertAll::getTypeName, vo.getTypeName());
                }
                if(vo.getCreateTime() != null){
                    queryWrapper.eq(SecurityAlertAll::getCreateTime, vo.getCreateTime());
                }
            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                            queryWrapper.like(SecurityAlertAll::getStatusName, vo.getStatusName());
                }
            if(StringUtils.isNotEmpty(vo.getDescription())) {
                    queryWrapper.eq(SecurityAlertAll::getDescription, vo.getDescription());
                }
                if(vo.getRoleEnumRoleEnumId1() != null){
                    queryWrapper.eq(SecurityAlertAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                }
                if(vo.getReportUserInfoUserInfoId1() != null){
                    queryWrapper.eq(SecurityAlertAll::getReportUserInfoUserInfoId1, vo.getReportUserInfoUserInfoId1());
                }
                if(vo.getAlertLevelEnumAlertLevelEnumId1() != null){
                    queryWrapper.eq(SecurityAlertAll::getAlertLevelEnumAlertLevelEnumId1, vo.getAlertLevelEnumAlertLevelEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
                    queryWrapper.eq(SecurityAlertAll::getPassword, vo.getPassword());
                }
            if(StringUtils.isNotEmpty(vo.getLevelName())) {
                            queryWrapper.like(SecurityAlertAll::getLevelName, vo.getLevelName());
                }
                if(vo.getAlertTypeEnumAlertTypeEnumId1() != null){
                    queryWrapper.eq(SecurityAlertAll::getAlertTypeEnumAlertTypeEnumId1, vo.getAlertTypeEnumAlertTypeEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                    queryWrapper.eq(SecurityAlertAll::getPhoneNumber, vo.getPhoneNumber());
                }
            if(StringUtils.isNotEmpty(vo.getProcessProgress())) {
                    queryWrapper.eq(SecurityAlertAll::getProcessProgress, vo.getProcessProgress());
                }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
                            queryWrapper.like(SecurityAlertAll::getUsername, vo.getUsername());
                }
                return ResultUtils.success(securityAlertAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(SecurityAlertAllPageVO vo) {


                LambdaQueryWrapper<SecurityAlertAll> queryWrapper = new LambdaQueryWrapper<>();


                                if(vo.getAlertStatusEnumAlertStatusEnumId1() != null){
                                    queryWrapper.eq(SecurityAlertAll::getAlertStatusEnumAlertStatusEnumId1, vo.getAlertStatusEnumAlertStatusEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                                            queryWrapper.like(SecurityAlertAll::getTypeName, vo.getTypeName());
                                }


                                if(vo.getCreateTime() != null){
                                    queryWrapper.eq(SecurityAlertAll::getCreateTime, vo.getCreateTime());
                                }


                            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                                            queryWrapper.like(SecurityAlertAll::getStatusName, vo.getStatusName());
                                }


                            if(StringUtils.isNotEmpty(vo.getDescription())) {
                                    queryWrapper.eq(SecurityAlertAll::getDescription, vo.getDescription());
                                }


                                if(vo.getRoleEnumRoleEnumId1() != null){
                                    queryWrapper.eq(SecurityAlertAll::getRoleEnumRoleEnumId1, vo.getRoleEnumRoleEnumId1());
                                }


                                if(vo.getSecurityAlertId() != null){
                                    queryWrapper.eq(SecurityAlertAll::getSecurityAlertId, vo.getSecurityAlertId());
                                }


                                if(vo.getReportUserInfoUserInfoId1() != null){
                                    queryWrapper.eq(SecurityAlertAll::getReportUserInfoUserInfoId1, vo.getReportUserInfoUserInfoId1());
                                }


                                if(vo.getAlertLevelEnumAlertLevelEnumId1() != null){
                                    queryWrapper.eq(SecurityAlertAll::getAlertLevelEnumAlertLevelEnumId1, vo.getAlertLevelEnumAlertLevelEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getPassword())) {
                                    queryWrapper.eq(SecurityAlertAll::getPassword, vo.getPassword());
                                }


                            if(StringUtils.isNotEmpty(vo.getLevelName())) {
                                            queryWrapper.like(SecurityAlertAll::getLevelName, vo.getLevelName());
                                }


                                if(vo.getAlertTypeEnumAlertTypeEnumId1() != null){
                                    queryWrapper.eq(SecurityAlertAll::getAlertTypeEnumAlertTypeEnumId1, vo.getAlertTypeEnumAlertTypeEnumId1());
                                }


                            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                                    queryWrapper.eq(SecurityAlertAll::getPhoneNumber, vo.getPhoneNumber());
                                }


                            if(StringUtils.isNotEmpty(vo.getProcessProgress())) {
                                    queryWrapper.eq(SecurityAlertAll::getProcessProgress, vo.getProcessProgress());
                                }


                            if(StringUtils.isNotEmpty(vo.getUsername())) {
                                            queryWrapper.like(SecurityAlertAll::getUsername, vo.getUsername());
                                }

                // SecurityAlertAll entity = this.securityAlertAllService.getById(securityAlertId);
                    final Page<SecurityAlertAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    securityAlertAllService.pageNew(page, vo, queryWrapper);
                    final List<SecurityAlertAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public SecurityAlertAll getById(Serializable securityAlertId) {

                    LambdaQueryWrapper<SecurityAlertAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(SecurityAlertAll::getSecurityAlertId, securityAlertId);

                    final Page<SecurityAlertAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    securityAlertAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<SecurityAlertAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
