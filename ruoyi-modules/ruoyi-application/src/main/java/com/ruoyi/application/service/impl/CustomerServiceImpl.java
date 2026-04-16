package com.ruoyi.application.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.application.domain.Customer;
import com.ruoyi.application.domain.CustomerCar;
import com.ruoyi.application.mapper.CustomerMapper;
import com.ruoyi.application.mapper.CustomerCarMapper;
import com.ruoyi.application.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService
{
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerCarMapper customerCarMapper;

    @Override
    public Customer selectCustomerById(Long id)
    {
        return customerMapper.selectCustomerById(id);
    }

    @Override
    public List<Customer> selectCustomerList(Customer customer)
    {
        return customerMapper.selectCustomerList(customer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertCustomer(Customer customer)
    {
        customer.setCreateBy(SecurityUtils.getUsername());
        int rows = customerMapper.insertCustomer(customer);
        insertCustomerCar(customer);
        return rows;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateCustomer(Customer customer)
    {
        customer.setUpdateBy(SecurityUtils.getUsername());
        customerCarMapper.deleteCustomerCarByCustomerId(customer.getId());
        insertCustomerCar(customer);
        return customerMapper.updateCustomer(customer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteCustomerByIds(Long[] ids)
    {
        for (Long id : ids)
        {
            customerCarMapper.deleteCustomerCarByCustomerId(id);
        }
        return customerMapper.deleteCustomerByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteCustomerById(Long id)
    {
        customerCarMapper.deleteCustomerCarByCustomerId(id);
        return customerMapper.deleteCustomerById(id);
    }

    public void insertCustomerCar(Customer customer)
    {
        List<CustomerCar> cars = customer.getCars();
        Long customerId = customer.getId();
        if (StringUtils.isNotNull(cars) && cars.size() > 0)
        {
            for (CustomerCar car : cars)
            {
                car.setCustomerId(customerId);
                car.setCreateBy(SecurityUtils.getUsername());
            }
            for (CustomerCar car : cars)
            {
                customerCarMapper.insertCustomerCar(car);
            }
        }
    }
}
