package com.controller;
import com.pojo.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/jump")
public class JumpController {
    @Autowired
    @Qualifier("ProductServiceImpl")
    private ProductService productService;

    //跳转到管理员登陆页面
    @RequestMapping("/jumpadminlogin")
    public String jumpAdminlogin() throws Exception {
        return "login-admin";
    }
    //跳转主页
    @RequestMapping("/jumpindex")
    public String jumpIndex() throws Exception {
        return "front-index";
    }

    //跳转后台
    @RequestMapping("/jumpbackindex")
    public String jumpBackindex() throws Exception {
        return "main";
    }

    //跳转注册
    @RequestMapping("/jumpregister")
    public String jumpRegister() throws Exception {
        return "register";
    }

    //跳转前台所有商品
    @RequestMapping("/jumpfront-allproduct")
    public String list(Model model){
        List<Product> list = productService.queryAllProduct();
        model.addAttribute("list", list);
        return "front-allProduct";
    }

    //跳转购物车
    @RequestMapping("/jumpcart")
    public String jumpCart() throws Exception {
        return "cart";
    }
}
