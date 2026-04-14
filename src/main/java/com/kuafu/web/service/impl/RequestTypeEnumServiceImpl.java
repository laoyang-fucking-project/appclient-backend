package com.kuafu.web.service.impl;

import java.util.List;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kuafu.web.mapper.RequestTypeEnumMapper;
import com.kuafu.web.entity.RequestTypeEnum;
import com.kuafu.web.service.IRequestTypeEnumService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 请求类型 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Slf4j
@Service("RequestTypeEnum")
public class RequestTypeEnumServiceImpl extends ServiceImpl<RequestTypeEnumMapper, RequestTypeEnum> implements IRequestTypeEnumService {


}
