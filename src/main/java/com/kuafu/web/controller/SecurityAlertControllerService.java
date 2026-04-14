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
import com.kuafu.web.entity.SecurityAlert;
import com.kuafu.web.service.ISecurityAlertService;
import com.kuafu.web.vo.SecurityAlertPageVO;
import com.kuafu.web.vo.SecurityAlertVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 安全预警 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("SecurityAlertControllerService")
@RequiredArgsConstructor
public class SecurityAlertControllerService  {

    private final ISecurityAlertService securityAlertService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( SecurityAlertPageVO pageVO){
        IPage<SecurityAlert> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<SecurityAlert> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<SecurityAlert> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(SecurityAlert::getSecurityAlertId);

            if(pageVO.getSecurityAlertId() != null){
                queryWrapper.eq(SecurityAlert::getSecurityAlertId, pageVO.getSecurityAlertId());
            }


            if(pageVO.getAlertTypeEnumAlertTypeEnumId1() != null){
                queryWrapper.eq(SecurityAlert::getAlertTypeEnumAlertTypeEnumId1, pageVO.getAlertTypeEnumAlertTypeEnumId1());
            }


            if(pageVO.getAlertLevelEnumAlertLevelEnumId1() != null){
                queryWrapper.eq(SecurityAlert::getAlertLevelEnumAlertLevelEnumId1, pageVO.getAlertLevelEnumAlertLevelEnumId1());
            }


            if(pageVO.getAlertStatusEnumAlertStatusEnumId1() != null){
                queryWrapper.eq(SecurityAlert::getAlertStatusEnumAlertStatusEnumId1, pageVO.getAlertStatusEnumAlertStatusEnumId1());
            }


        if(StringUtils.isNotEmpty(pageVO.getDescription())) {
                queryWrapper.eq(SecurityAlert::getDescription, pageVO.getDescription());
            }


            if(pageVO.getReportUserInfoUserInfoId1() != null){
                queryWrapper.eq(SecurityAlert::getReportUserInfoUserInfoId1, pageVO.getReportUserInfoUserInfoId1());
            }


        if(StringUtils.isNotEmpty(pageVO.getProcessProgress())) {
                queryWrapper.eq(SecurityAlert::getProcessProgress, pageVO.getProcessProgress());
            }


            if(pageVO.getCreateTime() != null){
                queryWrapper.eq(SecurityAlert::getCreateTime, pageVO.getCreateTime());
            }

            return ResultUtils.success(securityAlertService.page(page, queryWrapper));
        }


        public BaseResponse list(  SecurityAlertVO vo){
            LambdaQueryWrapper<SecurityAlert> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getAlertTypeEnumAlertTypeEnumId1() != null){
                    queryWrapper.eq(SecurityAlert::getAlertTypeEnumAlertTypeEnumId1, vo.getAlertTypeEnumAlertTypeEnumId1());
                }
                if(vo.getAlertLevelEnumAlertLevelEnumId1() != null){
                    queryWrapper.eq(SecurityAlert::getAlertLevelEnumAlertLevelEnumId1, vo.getAlertLevelEnumAlertLevelEnumId1());
                }
                if(vo.getAlertStatusEnumAlertStatusEnumId1() != null){
                    queryWrapper.eq(SecurityAlert::getAlertStatusEnumAlertStatusEnumId1, vo.getAlertStatusEnumAlertStatusEnumId1());
                }
            if(StringUtils.isNotEmpty(vo.getDescription())) {
                    queryWrapper.eq(SecurityAlert::getDescription, vo.getDescription());
                }
                if(vo.getReportUserInfoUserInfoId1() != null){
                    queryWrapper.eq(SecurityAlert::getReportUserInfoUserInfoId1, vo.getReportUserInfoUserInfoId1());
                }
            if(StringUtils.isNotEmpty(vo.getProcessProgress())) {
                    queryWrapper.eq(SecurityAlert::getProcessProgress, vo.getProcessProgress());
                }
                if(vo.getCreateTime() != null){
                    queryWrapper.eq(SecurityAlert::getCreateTime, vo.getCreateTime());
                }
                return ResultUtils.success(securityAlertService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  SecurityAlertVO vo) {
                SecurityAlert entity =  SecurityAlert.builder()
                    .alertTypeEnumAlertTypeEnumId1(vo.getAlertTypeEnumAlertTypeEnumId1())
                    .alertLevelEnumAlertLevelEnumId1(vo.getAlertLevelEnumAlertLevelEnumId1())
                    .alertStatusEnumAlertStatusEnumId1(vo.getAlertStatusEnumAlertStatusEnumId1())
                    .description(vo.getDescription())
                    .reportUserInfoUserInfoId1(vo.getReportUserInfoUserInfoId1())
                    .processProgress(vo.getProcessProgress())
                .build();








                boolean flag =this.securityAlertService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("security_alert").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getSecurityAlertId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( SecurityAlertVO vo) {
                SecurityAlert entity =  SecurityAlert.builder()
                    .securityAlertId(vo.getSecurityAlertId())
                    .alertTypeEnumAlertTypeEnumId1(vo.getAlertTypeEnumAlertTypeEnumId1())
                    .alertLevelEnumAlertLevelEnumId1(vo.getAlertLevelEnumAlertLevelEnumId1())
                    .alertStatusEnumAlertStatusEnumId1(vo.getAlertStatusEnumAlertStatusEnumId1())
                    .description(vo.getDescription())
                    .reportUserInfoUserInfoId1(vo.getReportUserInfoUserInfoId1())
                    .processProgress(vo.getProcessProgress())
                .build();



                        boolean flag = this.securityAlertService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getSecurityAlertId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( SecurityAlertVO vo ) {
                SecurityAlert entity = this.securityAlertService.getById(vo.getSecurityAlertId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( SecurityAlertVO vo) {
                boolean flag = this.securityAlertService.removeById(vo.getSecurityAlertId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
