package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.PropertyServiceRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p> 物业请求 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Mapper
public interface PropertyServiceRequestMapper extends BaseMapper<PropertyServiceRequest> {

}
