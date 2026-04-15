package com.ruoyi.application.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.application.domain.CustomerCar;
import com.ruoyi.application.mapper.CustomerCarMapper;
import com.ruoyi.application.service.ICustomerCarService;

@Service
public class CustomerCarServiceImpl implements ICustomerCarService
{
    @Autowired
    private CustomerCarMapper customerCarMapper;

    @Override
    public CustomerCar selectCustomerCarById(Long id)
    {
        return customerCarMapper.selectCustomerCarById(id);
    }

    @Override
    public List<CustomerCar> selectCustomerCarList(CustomerCar customerCar)
    {
        return customerCarMapper.selectCustomerCarList(customerCar);
    }

    @Override
    public List<CustomerCar> selectCustomerCarByCustomerId(Long customerId)
    {
        return customerCarMapper.selectCustomerCarByCustomerId(customerId);
    }

    @Override
    public int insertCustomerCar(CustomerCar customerCar)
    {
        customerCar.setCreateBy(SecurityUtils.getUsername());
        return customerCarMapper.insertCustomerCar(customerCar);
    }

    @Override
    public int updateCustomerCar(CustomerCar customerCar)
    {
        customerCar.setUpdateBy(SecurityUtils.getUsername());
        return customerCarMapper.updateCustomerCar(customerCar);
    }

    @Override
    public int deleteCustomerCarByIds(Long[] ids)
    {
        return customerCarMapper.deleteCustomerCarByIds(ids);
    }

    @Override
    public int deleteCustomerCarById(Long id)
    {
        return customerCarMapper.deleteCustomerCarById(id);
    }
}
