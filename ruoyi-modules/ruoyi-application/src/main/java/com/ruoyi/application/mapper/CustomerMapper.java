package com.ruoyi.application.mapper;

import java.util.List;
import com.ruoyi.application.domain.Customer;

public interface CustomerMapper
{
    public Customer selectCustomerById(Long id);

    public List<Customer> selectCustomerList(Customer customer);

    public int insertCustomer(Customer customer);

    public int updateCustomer(Customer customer);

    public int deleteCustomerById(Long id);

    public int deleteCustomerByIds(Long[] ids);
}
