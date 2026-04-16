package com.ruoyi.application.controller;

import java.util.List;
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
import com.ruoyi.application.domain.CustomerCar;
import com.ruoyi.application.service.ICustomerCarService;

@RestController
@RequestMapping("/customer/car")
public class CustomerCarController extends BaseController
{
    @Autowired
    private ICustomerCarService customerCarService;

    @RequiresPermissions("app:car:query")
    @GetMapping("/list/{customerId}")
    public AjaxResult list(@PathVariable Long customerId)
    {
        List<CustomerCar> list = customerCarService.selectCustomerCarByCustomerId(customerId);
        return AjaxResult.success(list);
    }

    @RequiresPermissions("app:car:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(customerCarService.selectCustomerCarById(id));
    }

    @RequiresPermissions("app:car:add")
    @Log(title = "客户车辆", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CustomerCar customerCar)
    {
        return toAjax(customerCarService.insertCustomerCar(customerCar));
    }

    @RequiresPermissions("app:car:edit")
    @Log(title = "客户车辆", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CustomerCar customerCar)
    {
        return toAjax(customerCarService.updateCustomerCar(customerCar));
    }

    @RequiresPermissions("app:car:del")
    @Log(title = "客户车辆", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(customerCarService.deleteCustomerCarByIds(ids));
    }
}
