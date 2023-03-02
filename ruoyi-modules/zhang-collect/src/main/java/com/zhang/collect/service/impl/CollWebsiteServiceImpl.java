package com.zhang.collect.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhang.collect.mapper.CollWebsiteMapper;
import com.zhang.collect.domain.CollWebsite;
import com.zhang.collect.service.ICollWebsiteService;

/**
 * 站点管理Service业务层处理
 * 
 * @author zhangzhe
 * @date 2023-03-02
 */
@Service
public class CollWebsiteServiceImpl implements ICollWebsiteService 
{
    @Autowired
    private CollWebsiteMapper collWebsiteMapper;

    /**
     * 查询站点管理
     * 
     * @param id 站点管理主键
     * @return 站点管理
     */
    @Override
    public CollWebsite selectCollWebsiteById(Long id)
    {
        return collWebsiteMapper.selectCollWebsiteById(id);
    }

    /**
     * 查询站点管理列表
     * 
     * @param collWebsite 站点管理
     * @return 站点管理
     */
    @Override
    public List<CollWebsite> selectCollWebsiteList(CollWebsite collWebsite)
    {
        return collWebsiteMapper.selectCollWebsiteList(collWebsite);
    }

    /**
     * 新增站点管理
     * 
     * @param collWebsite 站点管理
     * @return 结果
     */
    @Override
    public int insertCollWebsite(CollWebsite collWebsite)
    {
        collWebsite.setCreateTime(DateUtils.getNowDate());
        return collWebsiteMapper.insertCollWebsite(collWebsite);
    }

    /**
     * 修改站点管理
     * 
     * @param collWebsite 站点管理
     * @return 结果
     */
    @Override
    public int updateCollWebsite(CollWebsite collWebsite)
    {
        collWebsite.setUpdateTime(DateUtils.getNowDate());
        return collWebsiteMapper.updateCollWebsite(collWebsite);
    }

    /**
     * 批量删除站点管理
     * 
     * @param ids 需要删除的站点管理主键
     * @return 结果
     */
    @Override
    public int deleteCollWebsiteByIds(Long[] ids)
    {
        return collWebsiteMapper.deleteCollWebsiteByIds(ids);
    }

    /**
     * 删除站点管理信息
     * 
     * @param id 站点管理主键
     * @return 结果
     */
    @Override
    public int deleteCollWebsiteById(Long id)
    {
        return collWebsiteMapper.deleteCollWebsiteById(id);
    }
}
