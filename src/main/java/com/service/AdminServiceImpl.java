package com.service;

import com.dao.AdminMapper;

import com.pojo.Admin;

public class AdminServiceImpl implements AdminService {
    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper){
        this.adminMapper = adminMapper;
    }

    public Admin login(String adminname, String password) {
        Admin admin=this.adminMapper.login(adminname,password);
        return admin;
    }
}
