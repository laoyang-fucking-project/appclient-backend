package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.PropertyServiceRequestAll;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * <p> 物业请求 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Mapper
public interface PropertyServiceRequestAllMapper extends BaseMapper<PropertyServiceRequestAll> {
    public List<PropertyServiceRequestAll> selectListNew(@Param("ew") Wrapper<PropertyServiceRequestAll> queryWrapper);
}
