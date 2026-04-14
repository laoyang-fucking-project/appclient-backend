package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.KfSystemConfig;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p> 系统配置 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Mapper
public interface KfSystemConfigMapper extends BaseMapper<KfSystemConfig> {

}
