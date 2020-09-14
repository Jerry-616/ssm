package com.service;

import com.pojo.Admin;

public interface AdminService {
    //登录验证
    Admin login(String adminname, String password);
}
