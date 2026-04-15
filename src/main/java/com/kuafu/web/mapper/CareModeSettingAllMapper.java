package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.CareModeSettingAll;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * <p> 关怀模式 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Mapper
public interface CareModeSettingAllMapper extends BaseMapper<CareModeSettingAll> {
    public List<CareModeSettingAll> selectListNew(@Param("ew") Wrapper<CareModeSettingAll> queryWrapper);
}
