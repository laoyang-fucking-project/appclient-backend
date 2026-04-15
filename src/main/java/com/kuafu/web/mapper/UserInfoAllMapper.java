package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.UserInfoAll;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * <p> 用户 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Mapper
public interface UserInfoAllMapper extends BaseMapper<UserInfoAll> {
    public List<UserInfoAll> selectListNew(@Param("ew") Wrapper<UserInfoAll> queryWrapper);
}
