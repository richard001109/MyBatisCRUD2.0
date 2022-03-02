package com.chinasofti.test;

import com.chinasofti.dao.UserDao;
import com.chinasofti.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UpdateUser {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis-config.xml配置文件读取，数据库的连接
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.通过读取到的信息建立sqlSessionFactory(会话工厂)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.
        SqlSession session = sqlSessionFactory.openSession(true);
        //4.
        Users users = new Users();
        users.setId(8);
        users.setName("刘翔");
        users.setSex("b");
        users.setAge(28);
        users.setAddress("上海");
        UserDao userDao = session.getMapper(UserDao.class);
        int i = userDao.updateUser(users);
        if (i>0){
            System.out.println("用户信息修改成功");
        }
        session.close();
    }
}
