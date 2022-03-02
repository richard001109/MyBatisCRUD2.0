package com.chinasofti.test;

import com.chinasofti.dao.CustomerDao;
import com.chinasofti.pojo.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UpdateCustomer1Test {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis-config.xml配置文件读取，数据库的连接
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.通过读取到的信息建立sqlSessionFactory(会话工厂)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.
        SqlSession session = sqlSessionFactory.openSession(true);
        //4.
        CustomerDao customerDao = session.getMapper(CustomerDao.class);
        Customer customer = new Customer();
        customer.setId(4);
        customer.setPhone("12306");
        int row = customerDao.updateCustomer1(customer);
        if (row>0){
            System.out.println("修改了"+row+"条数据");
        }
    }
}
