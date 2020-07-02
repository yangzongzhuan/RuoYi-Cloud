package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.constant.CacheConstants;
import com.ruoyi.system.domain.SysClientDetails;
import com.ruoyi.system.mapper.SysClientDetailsMapper;
import com.ruoyi.system.service.ISysClientDetailsService;

/**
 * 终端配置Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysClientDetailsServiceImpl implements ISysClientDetailsService
{
    @Autowired
    private SysClientDetailsMapper sysClientDetailsMapper;

    /**
     * 查询终端配置
     * 
     * @param clientId 终端配置ID
     * @return 终端配置
     */
    @Override
    public SysClientDetails selectSysClientDetailsById(String clientId)
    {
        return sysClientDetailsMapper.selectSysClientDetailsById(clientId);
    }

    /**
     * 查询终端配置列表
     * 
     * @param sysClientDetails 终端配置
     * @return 终端配置
     */
    @Override
    public List<SysClientDetails> selectSysClientDetailsList(SysClientDetails sysClientDetails)
    {
        return sysClientDetailsMapper.selectSysClientDetailsList(sysClientDetails);
    }

    /**
     * 新增终端配置
     * 
     * @param sysClientDetails 终端配置
     * @return 结果
     */
    @Override
    public int insertSysClientDetails(SysClientDetails sysClientDetails)
    {
        return sysClientDetailsMapper.insertSysClientDetails(sysClientDetails);
    }

    /**
     * 修改终端配置
     * 
     * @param sysClientDetails 终端配置
     * @return 结果
     */
    @Override
    @CacheEvict(value = CacheConstants.CLIENT_DETAILS_KEY, key = "#sysClientDetails.clientId")
    public int updateSysClientDetails(SysClientDetails sysClientDetails)
    {
        return sysClientDetailsMapper.updateSysClientDetails(sysClientDetails);
    }

    /**
     * 批量删除终端配置
     * 
     * @param clientIds 需要删除的终端配置ID
     * @return 结果
     */
    @Override
    @CacheEvict(value = CacheConstants.CLIENT_DETAILS_KEY, allEntries = true)
    public int deleteSysClientDetailsByIds(String[] clientIds)
    {
        return sysClientDetailsMapper.deleteSysClientDetailsByIds(clientIds);
    }
}
