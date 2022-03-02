package com.chinasofti.dao;

import com.chinasofti.pojo.Customer;

import java.util.List;

public interface CustomerDao {
    //通过用户名或者电话号码查询客户信息
    public List<Customer> findCustomer(Customer customer);
    //查询客户信息，如果电话号码不为空，则查询通过电话号码查询
    public List<Customer> findCustomerByWhen(Customer  customer);
    //查询数据
    public  List<Customer> findCustomerTwo(Customer customer);
    //修改数据
    public  int updateCustomer(Customer customer);
    public  int updateCustomer1(Customer customer);
}
