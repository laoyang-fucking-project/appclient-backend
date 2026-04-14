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
import com.kuafu.web.entity.RequestTypeEnum;
import com.kuafu.web.service.IRequestTypeEnumService;
import com.kuafu.web.vo.RequestTypeEnumPageVO;
import com.kuafu.web.vo.RequestTypeEnumVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 请求类型 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Service("RequestTypeEnumControllerService")
@RequiredArgsConstructor
public class RequestTypeEnumControllerService  {

    private final IRequestTypeEnumService requestTypeEnumService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( RequestTypeEnumPageVO pageVO){
        IPage<RequestTypeEnum> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<RequestTypeEnum> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<RequestTypeEnum> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(RequestTypeEnum::getRequestTypeEnumId);

            if(pageVO.getRequestTypeEnumId() != null){
                queryWrapper.eq(RequestTypeEnum::getRequestTypeEnumId, pageVO.getRequestTypeEnumId());
            }


        if(StringUtils.isNotEmpty(pageVO.getTypeName())) {
//                        queryWrapper.like(RequestTypeEnum::getTypeName, pageVO.getTypeName());
                        String s_string = pageVO.getTypeName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(RequestTypeEnum::getTypeName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

            return ResultUtils.success(requestTypeEnumService.page(page, queryWrapper));
        }


        public BaseResponse list(  RequestTypeEnumVO vo){
            LambdaQueryWrapper<RequestTypeEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getTypeName())) {
                            queryWrapper.like(RequestTypeEnum::getTypeName, vo.getTypeName());
                }
                return ResultUtils.success(requestTypeEnumService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  RequestTypeEnumVO vo) {
                RequestTypeEnum entity =  RequestTypeEnum.builder()
                    .typeName(vo.getTypeName())
                .build();








                boolean flag =this.requestTypeEnumService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("request_type_enum").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getRequestTypeEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( RequestTypeEnumVO vo) {
                RequestTypeEnum entity =  RequestTypeEnum.builder()
                    .requestTypeEnumId(vo.getRequestTypeEnumId())
                    .typeName(vo.getTypeName())
                .build();



                        boolean flag = this.requestTypeEnumService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getRequestTypeEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( RequestTypeEnumVO vo ) {
                RequestTypeEnum entity = this.requestTypeEnumService.getById(vo.getRequestTypeEnumId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( RequestTypeEnumVO vo) {
                boolean flag = this.requestTypeEnumService.removeById(vo.getRequestTypeEnumId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
