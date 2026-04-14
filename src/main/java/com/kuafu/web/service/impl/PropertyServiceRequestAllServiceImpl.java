package com.kuafu.web.service.impl;

import java.util.List;
import com.kuafu.common.util.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuafu.common.domin.PageRequest;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.mapper.PropertyServiceRequestAllMapper;
import com.kuafu.web.entity.PropertyServiceRequestAll;
import com.kuafu.web.service.IPropertyServiceRequestAllService;
import org.springframework.util.SerializationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p> 物业请求 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Slf4j
@Service("PropertyServiceRequestAll")
public class PropertyServiceRequestAllServiceImpl extends ServiceImpl<PropertyServiceRequestAllMapper, PropertyServiceRequestAll> implements IPropertyServiceRequestAllService {
@Autowired
private PropertyServiceRequestAllMapper taskInfoAllMapper;


@Override
public List<PropertyServiceRequestAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper) {

        LambdaQueryWrapper<PropertyServiceRequestAll> pageQueryWrapper = getPageQueryWrapper(pageRequest, queryWrapper);
        final List<String> other_search_condition = pageRequest.getOther_search_condition();
        if (other_search_condition!=null){
        for (String s : other_search_condition) {
        if (StringUtils.isNotEmpty(s)){
        pageQueryWrapper.apply(s);
        }
        }
        }
        long current = pageRequest.getCurrent();
        long pageSize = pageRequest.getPageSize();
        long newCurrent = (current - 1) * pageSize;
        pageQueryWrapper.last("limit " + newCurrent + "," + pageSize);
        return taskInfoAllMapper.selectListNew(pageQueryWrapper);

        }

  @Override
public List<PropertyServiceRequestAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper,boolean isPage) {

                LambdaQueryWrapper<PropertyServiceRequestAll> pageQueryWrapper = getPageQueryWrapper(pageRequest, queryWrapper);
                final List<String> other_search_condition = pageRequest.getOther_search_condition();
                if (other_search_condition!=null){
                        for (String s : other_search_condition) {
                                if (StringUtils.isNotEmpty(s)){
                                        pageQueryWrapper.apply(s);
                                }
                        }
                }
                if (isPage){
                        long current = pageRequest.getCurrent();
                        long pageSize = pageRequest.getPageSize();
                        long newCurrent = (current - 1) * pageSize;
                        pageQueryWrapper.last("limit " + newCurrent + "," + pageSize);
                }

                return taskInfoAllMapper.selectListNew(pageQueryWrapper);

        }


@Override
public long selectCount(PageRequest pageRequest, LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper) {
        LambdaQueryWrapper<PropertyServiceRequestAll> pageQueryWrapper = getPageQueryWrapper(pageRequest, queryWrapper);

        final List<String> other_search_condition = pageRequest.getOther_search_condition();
        if (other_search_condition!=null){
        for (String s : other_search_condition) {
                pageQueryWrapper.apply(s);
                }
        }

        return taskInfoAllMapper.selectCount(queryWrapper);
        }



@Override
public IPage pageNew(IPage<PropertyServiceRequestAll> page, PageRequest pageRequest, LambdaQueryWrapper<PropertyServiceRequestAll> queryWrapper) {
        page.setCurrent(pageRequest.getCurrent());
        page.setSize(pageRequest.getPageSize());
        page.setRecords(selectListNew(pageRequest, queryWrapper));
        page.setTotal(selectCount(pageRequest, queryWrapper));
        return page;
        }



private <T> LambdaQueryWrapper<T> getPageQueryWrapper(PageRequest pageRequest, LambdaQueryWrapper<T> queryWrapper) {
final byte[] serialize = SerializationUtils.serialize(queryWrapper);
        return (LambdaQueryWrapper<T>) SerializationUtils.<LambdaQueryWrapper>deserialize(serialize);
        }

}
