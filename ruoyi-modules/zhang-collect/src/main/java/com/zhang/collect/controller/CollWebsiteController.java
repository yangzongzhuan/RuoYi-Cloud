package com.zhang.collect.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.zhang.collect.domain.CollWebsite;
import com.zhang.collect.service.ICollWebsiteService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 站点管理Controller
 * 
 * @author zhangzhe
 * @date 2023-03-02
 */
@RestController
@RequestMapping("/website")
public class CollWebsiteController extends BaseController
{
    @Autowired
    private ICollWebsiteService collWebsiteService;

    /**
     * 查询站点管理列表
     */
    @RequiresPermissions("collect:website:list")
    @GetMapping("/list")
    public TableDataInfo list(CollWebsite collWebsite)
    {
        startPage();
        List<CollWebsite> list = collWebsiteService.selectCollWebsiteList(collWebsite);
        return getDataTable(list);
    }

    /**
     * 导出站点管理列表
     */
    @RequiresPermissions("collect:website:export")
    @Log(title = "站点管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CollWebsite collWebsite)
    {
        List<CollWebsite> list = collWebsiteService.selectCollWebsiteList(collWebsite);
        ExcelUtil<CollWebsite> util = new ExcelUtil<CollWebsite>(CollWebsite.class);
        util.exportExcel(response, list, "站点管理数据");
    }

    /**
     * 获取站点管理详细信息
     */
    @RequiresPermissions("collect:website:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(collWebsiteService.selectCollWebsiteById(id));
    }

    /**
     * 新增站点管理
     */
    @RequiresPermissions("collect:website:add")
    @Log(title = "站点管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CollWebsite collWebsite)
    {
        return toAjax(collWebsiteService.insertCollWebsite(collWebsite));
    }

    /**
     * 修改站点管理
     */
    @RequiresPermissions("collect:website:edit")
    @Log(title = "站点管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CollWebsite collWebsite)
    {
        return toAjax(collWebsiteService.updateCollWebsite(collWebsite));
    }

    /**
     * 删除站点管理
     */
    @RequiresPermissions("collect:website:remove")
    @Log(title = "站点管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(collWebsiteService.deleteCollWebsiteByIds(ids));
    }
}
