package com.controller;

import com.pojo.User;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    //显示用户列表
    @RequestMapping("/allUser")
    public String list(Model model) {
        List<User> list = userService.queryAllUser();
        model.addAttribute("list", list);
        return "allUser";
    }

    //添加用户页面
    @RequestMapping("/toAddUser")
    public String toAddPaper() {
        return "addUser";
    }

    //添加用户请求
    @RequestMapping("/addUser")
    public String addUser(User user) {
        System.out.println(user);
        userService.addUser(user);
        return "redirect:/user/allUser";
    }

    //修改用户信息页面
    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(Model model, int id) {
        User user = userService.queryUserById(id);
        System.out.println(user);
        model.addAttribute("user",user );
        return "updateUser";
    }

    //修改用户信息
    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        System.out.println("updateUser=>"+user);
        userService.updateUser(user);
        return "redirect:/user/allUser";
    }
    //删除用户
    @RequestMapping("/deleteUser")
    public String deleteUser(int id) {
        userService.deleteUserById(id);
        return "redirect:/user/allUser";
    }

    //批量删除用户
    @RequestMapping("/deleteSelect")
    public String deleteSelect(String list) {
        String[] strs = list.split(",");
        List<Integer> ids = new ArrayList<Integer>();
        for(int i = 0; i<strs.length;i++){
            ids.add(Integer.parseInt(strs[i]));
        }
        userService.deleteSelect(ids);
        return "redirect:/user/allUser";
    }

    //跳转到登陆页面
    @RequestMapping("/jumplogin")
    public String jumpLogin() throws Exception {
        return "login";
    }

    //跳转到成功页面
    @RequestMapping("/jumpSuccess")
    public String jumpSuccess() throws Exception {
        return "success";
    }

    //登陆提交
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String pwd) throws Exception {
        // 向session记录用户身份信息
        System.out.println("接收前端==="+username);
        session.setAttribute("user", username);
        return "main";
    }

    //退出登陆
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        // session 过期
        session.invalidate();
        return "login";
    }

    //查询用户
    @RequestMapping("/queryuser")
    public String queryuser(String queryusername,Model model) {
        User user = userService.queryUserByName(queryusername);
        System.out.println("queryuser=>" + user);
        List<User> list = new ArrayList<User>();
        list.add(user);
        model.addAttribute("list", list);
        return "allUser";
    }
}