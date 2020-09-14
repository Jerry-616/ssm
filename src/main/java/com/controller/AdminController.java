package com.controller;

import com.pojo.Admin;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")

public class AdminController {
    private final AdminService adminService;

    public AdminController(@Qualifier("AdminServiceImpl") AdminService adminService) {
        this.adminService = adminService;
    }

    //登陆验证
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Admin login(HttpSession session, String adminname, String password, String checked,
                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 向session记录用户身份信息;
        System.out.println(adminname);
        Admin admin = adminService.login(adminname, password);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return admin;
        }
        return null;
    }


    //退出登陆
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        // session 过期
        session.invalidate();
        return "login";
    }

}