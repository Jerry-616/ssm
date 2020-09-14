package com.service;
import com.dao.UserMapper;
import com.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    //service调dao层：组合Dao
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    public void deleteSelect(List<Integer> ids) {
        userMapper.deleteSelect(ids);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public User queryUserById(Integer id) {
        return userMapper.queryUserById(id);
    }

    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }

    public User login(String username,String password) {
        User user=this.userMapper.login(username,password);
            return user;
    }
}
