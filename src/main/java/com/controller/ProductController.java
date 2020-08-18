package com.controller;

import com.pojo.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("ProductServiceImpl")
    private ProductService productService;

    //显示商品列表
    @RequestMapping("/allProduct")
    public String list(Model model) {
        List<Product> list = productService.queryAllProduct();
        model.addAttribute("list", list);
        return "allProduct";
    }

    //添加商品页面
    @RequestMapping("/toAddProduct")
    public String toAddPaper() {
        return "addProduct";
    }

    //添加商品请求
    @RequestMapping("/addProduct")
    public String addProduct(Product product) {
        System.out.println(product);
        productService.addProduct(product);
        return "redirect:/product/allProduct";
    }

    //修改商品信息页面
    @RequestMapping("/toUpdateProduct")
    public String toUpdateProduct(Model model, int id) {
        Product product = productService.queryProductById(id);
        System.out.println(product);
        model.addAttribute("product",product );
        return "updateProduct";
    }

    //修改
    @RequestMapping("/updateProduct")
    public String updateProduct(Product product) {
        System.out.println("updateProduct=>"+product);
        productService.updateProduct(product);
        return "redirect:/product/allProduct";
    }

    //删除商品
    @RequestMapping("/deleteProduct")
    public String deleteProduct(int id) {
        productService.deleteProductById(id);
        return "redirect:/product/allProduct";
    }

    //批量删除商品
    @RequestMapping("/deleteSelect")
    public String deleteSelect(String list) {
        String[] strs = list.split(",");
        List<Integer> ids = new ArrayList<Integer>();
        for(int i = 0; i<strs.length;i++){
            ids.add(Integer.parseInt(strs[i]));
        }
        productService.deleteSelect(ids);
        return "redirect:/product/allProduct";
    }

    //查询商品
    @RequestMapping("/queryproduct")
    public String queryproduct(String queryproductname,Model model) {
        Product product = productService.queryProductByName(queryproductname);
        System.out.println("queryproduct=>" + product);
        List<Product> list = new ArrayList<Product>();
        list.add(product);
        model.addAttribute("list", list);
        return "allProduct";
    }
}