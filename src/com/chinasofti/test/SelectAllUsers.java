package com.chinasofti.test;

import com.chinasofti.dao.UserDao;
import com.chinasofti.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SelectAllUsers {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis-config.xml配置文件读取，数据库的连接
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.通过读取到的信息建立sqlSessionFactory(会话工厂)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.
        SqlSession session = sqlSessionFactory.openSession(true);//openSession()中参数为true时会自动提交状态
        //4.
        UserDao userDao = session.getMapper(UserDao.class);
        List<Users> users = userDao.selectAllUser();
        for (Users user : users) {
            System.out.println(user);
        }

        session.close();
    }
}
