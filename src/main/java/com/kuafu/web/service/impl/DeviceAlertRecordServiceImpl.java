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

import com.kuafu.web.mapper.DeviceAlertRecordMapper;
import com.kuafu.web.entity.DeviceAlertRecord;
import com.kuafu.web.service.IDeviceAlertRecordService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 设备告警记录表 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Slf4j
@Service("DeviceAlertRecord")
public class DeviceAlertRecordServiceImpl extends ServiceImpl<DeviceAlertRecordMapper, DeviceAlertRecord> implements IDeviceAlertRecordService {


}
