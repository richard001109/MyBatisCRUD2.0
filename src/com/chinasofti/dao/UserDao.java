package com.chinasofti.dao;

import com.chinasofti.pojo.Users;

import java.util.List;

/**
 * 数据访问接口层
 */
public interface UserDao {
    //通过ID查询用户信息
    public Users selectUserByID(int id);

    public List<Users> selectAllUser();

    public  int  addUser(Users users);

    public  int  deleteUser(Users users);

    public  int  updateUser(Users users);
}
