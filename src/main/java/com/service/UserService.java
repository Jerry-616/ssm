package com.service;

import com.pojo.Product;
import com.pojo.User;

import java.util.List;

public interface UserService {
    //增加一个User
    int addUser(User user);

    //登录验证
    User login(String username,String password);

    //根据id删除一个User
    int deleteUserById(int id);

    //批量删除User
    void deleteSelect(List<Integer> ids);

    //更新User
    int updateUser(User user);

    //根据id查询,返回一个User
    User queryUserById(int id);

    //查询全部Usert,返回list集合
    List<User> queryAllUser();

    //按名查询Product
    User queryUserByName(String username);
}
