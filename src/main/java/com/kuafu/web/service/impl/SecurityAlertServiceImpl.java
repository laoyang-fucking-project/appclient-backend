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

import com.kuafu.web.mapper.SecurityAlertMapper;
import com.kuafu.web.entity.SecurityAlert;
import com.kuafu.web.service.ISecurityAlertService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 安全预警 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Slf4j
@Service("SecurityAlert")
public class SecurityAlertServiceImpl extends ServiceImpl<SecurityAlertMapper, SecurityAlert> implements ISecurityAlertService {


}
