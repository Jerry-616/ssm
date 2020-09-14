package com.controller;

import com.pojo.Cart;
import com.pojo.Product;
import com.service.ProductService;
import jdk.nashorn.internal.objects.AccessorPropertyDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    @Qualifier("ProductServiceImpl")
    private ProductService productService;

    @RequestMapping("addCart")
    public String addCart(Product product,HttpSession session,int id) {
        // 获取商品对象
        Product findproduct = productService.queryProductById(id);
        // 存储到购物车
        Map<Product , Integer> cartMap = (Map<Product, Integer>) session.getAttribute("cartMap");
        if(cartMap == null){
            cartMap = new HashMap<Product , Integer>();
        }
        if (cartMap.containsKey(findproduct)) {
            // 有这件商品，原来的数量+1
            cartMap.put(findproduct, cartMap.get(findproduct) + 1);
        } else {
            cartMap.put(findproduct, 1);
        }
        session.setAttribute("cartMap", cartMap);
        return "cart";
    }

    //购物车数量-1
    @RequestMapping("subtractCart")
    public String subtractCart(HttpSession session,int id) {
        Product findproduct = productService.queryProductById(id);
        Map<Product , Integer> cartMap = (Map<Product, Integer>) session.getAttribute("cartMap");
        if(cartMap.get(findproduct) == 1){
            cartMap.remove(findproduct);
        }else {
            cartMap.put(findproduct,cartMap.get(findproduct) - 1);
        }
        return "cart";
    }

    //购物车数量+1
    @RequestMapping("plusCart")
    public String plusCart(HttpSession session,int id) {
        Product findproduct = productService.queryProductById(id);
        Map<Product , Integer> cartMap = (Map<Product, Integer>) session.getAttribute("cartMap");
        cartMap.put(findproduct,cartMap.get(findproduct) + 1);
        return "cart";
    }

    //删除购物车商品
    @RequestMapping("deleteCart")
    public String deleteCart(HttpSession session,int id) {
        Product findproduct = productService.queryProductById(id);
        Map<Product , Integer> cartMap = (Map<Product, Integer>) session.getAttribute("cartMap");
        cartMap.remove(findproduct);
        return "cart";
    }

    //清空购物车
    @RequestMapping("cleanCart")
    public String cleanCart(HttpSession session) {
        session.removeAttribute("cartMap");
        return "cart";
    }
}
