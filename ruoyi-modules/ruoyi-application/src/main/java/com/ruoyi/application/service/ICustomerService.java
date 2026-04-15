package com.ruoyi.application.service;

import java.util.List;
import com.ruoyi.application.domain.Customer;

public interface ICustomerService
{
    public Customer selectCustomerById(Long id);

    public List<Customer> selectCustomerList(Customer customer);

    public int insertCustomer(Customer customer);

    public int updateCustomer(Customer customer);

    public int deleteCustomerByIds(Long[] ids);

    public int deleteCustomerById(Long id);
}
