package com.dao;
import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //注册用户
    int addUser(User user);

    //登录验证
    User login(@Param("username") String username,
                   @Param("password") String password);

    //根据id删除一个User
    int deleteUserById(@Param("userid")int id);

    //批量删除User
    void deleteSelect(List<Integer> ids);

    //更新User
    int updateUser(User user);

    //根据id查询,返回一个User
    User queryUserById(@Param("userid")Integer id);

    //查询全部User,返回list集合
    List<User> queryAllUser();

    //按名查询User
    User queryUserByName(@Param("username") String username);

}