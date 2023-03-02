package com.zhang.collect.mapper;

import java.util.List;
import com.zhang.collect.domain.CollWebsite;

/**
 * 站点管理Mapper接口
 * 
 * @author zhangzhe
 * @date 2023-03-02
 */
public interface CollWebsiteMapper 
{
    /**
     * 查询站点管理
     * 
     * @param id 站点管理主键
     * @return 站点管理
     */
    public CollWebsite selectCollWebsiteById(Long id);

    /**
     * 查询站点管理列表
     * 
     * @param collWebsite 站点管理
     * @return 站点管理集合
     */
    public List<CollWebsite> selectCollWebsiteList(CollWebsite collWebsite);

    /**
     * 新增站点管理
     * 
     * @param collWebsite 站点管理
     * @return 结果
     */
    public int insertCollWebsite(CollWebsite collWebsite);

    /**
     * 修改站点管理
     * 
     * @param collWebsite 站点管理
     * @return 结果
     */
    public int updateCollWebsite(CollWebsite collWebsite);

    /**
     * 删除站点管理
     * 
     * @param id 站点管理主键
     * @return 结果
     */
    public int deleteCollWebsiteById(Long id);

    /**
     * 批量删除站点管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCollWebsiteByIds(Long[] ids);
}
