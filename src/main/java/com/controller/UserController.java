package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(@Qualifier("UserServiceImpl") UserService userService) {
        this.userService = userService;
    }

    //用户注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public User register(HttpSession session, User user) {
        System.out.println(user);
        userService.addUser(user);
        if (user != null) {
            session.setAttribute("user", user);
            return user;
        }
        return null;
    }

    //注册提示
    @RequestMapping("/a1")
    @ResponseBody
    public String ajax1(Integer id){
        User user = userService.queryUserById(id);
        String msg= "";
        if (user != null){
            msg = "ID已被注册";
        }else {
            msg = "ID可以被注册";
        }
        System.out.println(msg);
        return msg;

    }

    //跳转到登陆页面
    @RequestMapping("/jumplogin")
    public String jumpLogin() throws Exception {
        return "login";
    }

    //登陆验证
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public User login(HttpSession session,String username, String password, String checked,
                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 向session记录用户身份信息;
        System.out.println(username);
        User user = userService.login(username, password);
        String  loginname =request.getParameter("username");
        if (user != null) {
                //将数据存入cookie
				Cookie cookie =new Cookie("autologin", loginname);
				//设置cookie时间
				cookie.setMaxAge(60*60*24*7);
				//路径
				cookie.setPath(request.getContextPath());
				//response把cookie返回给客户端
				response.addCookie(cookie);
            session.setAttribute("user", user);
            session.setAttribute("username",loginname);
            return user;
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
    //显示用户列表
    @RequestMapping("/allUser")
    public String list(Model model) {
        List<User> list = userService.queryAllUser();
        model.addAttribute("list", list);
        return "allUser";
    }

    //跳转添加用户页面
    @RequestMapping("/toAddUser")
    public String toAddPaper() {
        return "addUser";
    }

    //添加用户
    @RequestMapping("/addUser")
    public String addUser(User user) {
        System.out.println(user);
        userService.addUser(user);
        return "redirect:/user/allUser";
    }

    //跳转修改用户信息页面
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