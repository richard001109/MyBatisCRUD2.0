package com.chinasofti.test;

import com.chinasofti.dao.UserDao;
import com.chinasofti.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AddUserTest {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis-config.xml配置文件读取，数据库的连接
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.通过读取到的信息建立sqlSessionFactory(会话工厂)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.
        SqlSession session = sqlSessionFactory.openSession(true);
        //4.
        Users users1 = new Users();
        users1.setName("李志");
        users1.setSex("b");
        users1.setAge(38);
        users1.setAddress("南京");
        UserDao userDao = session.getMapper(UserDao.class);
        int i = userDao.addUser(users1);
        if(i>0){
            System.out.println("用户信息添加成功");
        }
        session.close();
    }
}
