package com.ruoyi.application.mapper;

import java.util.List;
import com.ruoyi.application.domain.CustomerCar;

public interface CustomerCarMapper
{
    public CustomerCar selectCustomerCarById(Long id);

    public List<CustomerCar> selectCustomerCarList(CustomerCar customerCar);

    public List<CustomerCar> selectCustomerCarByCustomerId(Long customerId);

    public int insertCustomerCar(CustomerCar customerCar);

    public int updateCustomerCar(CustomerCar customerCar);

    public int deleteCustomerCarById(Long id);

    public int deleteCustomerCarByIds(Long[] ids);

    public int deleteCustomerCarByCustomerId(Long customerId);
}
