package com.ruoyi.application.controller;

import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.application.domain.Customer;
import com.ruoyi.application.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController
{
    @Autowired
    private ICustomerService customerService;

    @RequiresPermissions("app:customer:list")
    @GetMapping("/list")
    public TableDataInfo list(Customer customer)
    {
        startPage();
        List<Customer> list = customerService.selectCustomerList(customer);
        return getDataTable(list);
    }

    @Log(title = "客户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("app:customer:export")
    @PostMapping("/export")
    public void export(HttpServletResponse response, Customer customer)
    {
        List<Customer> list = customerService.selectCustomerList(customer);
        ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
        util.exportExcel(response, list, "客户数据");
    }

    @RequiresPermissions("app:customer:query")
    @GetMapping(value = { "/", "/{id}" })
    public AjaxResult getInfo(@PathVariable(value = "id", required = false) Long id)
    {
        AjaxResult ajax = AjaxResult.success();
        if (id != null)
        {
            Customer customer = customerService.selectCustomerById(id);
            ajax.put(AjaxResult.DATA_TAG, customer);
        }
        return ajax;
    }

    @RequiresPermissions("app:customer:add")
    @Log(title = "客户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Customer customer)
    {
        return toAjax(customerService.insertCustomer(customer));
    }

    @RequiresPermissions("app:customer:edit")
    @Log(title = "客户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Customer customer)
    {
        return toAjax(customerService.updateCustomer(customer));
    }

    @RequiresPermissions("app:customer:del")
    @Log(title = "客户管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(customerService.deleteCustomerByIds(ids));
    }
}
