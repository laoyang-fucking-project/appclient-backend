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

import com.kuafu.web.mapper.SmartDeviceStatusEnumMapper;
import com.kuafu.web.entity.SmartDeviceStatusEnum;
import com.kuafu.web.service.ISmartDeviceStatusEnumService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 设备状态枚举表 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Slf4j
@Service("SmartDeviceStatusEnum")
public class SmartDeviceStatusEnumServiceImpl extends ServiceImpl<SmartDeviceStatusEnumMapper, SmartDeviceStatusEnum> implements ISmartDeviceStatusEnumService {


}
