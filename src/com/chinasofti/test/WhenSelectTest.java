package com.chinasofti.test;

import com.chinasofti.dao.CustomerDao;
import com.chinasofti.pojo.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WhenSelectTest {
        public static void main(String[] args) throws IOException {//psvm 快捷方式
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession(true);

            Customer customer = new Customer();
            //customer.setUsername("宋小宝");
            //customer.setPhone("15344456789");
            customer.setJobs("worker");
            CustomerDao customerDao = session.getMapper(CustomerDao.class);
            List<Customer> customers = customerDao.findCustomerByWhen(customer);

            for (Customer customer1 : customers) {
                System.out.println(customer1);
            }
        }
}
