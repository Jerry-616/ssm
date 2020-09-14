package com.controller;

import com.pojo.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    //跳转添加商品页面
    @RequestMapping("/toAddProduct")
    public String toAddPaper() {
        return "addProduct";
    }

    //添加商品
    @RequestMapping("/addProduct")
    public String addProduct(MultipartFile file, Product product)throws IOException {
        //图片上传成功后，将图片的地址写到数据库
        String filePath = "E:\\idea_workplace\\ssm\\web\\image";//路径
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新文件名
        String newFileName = UUID.randomUUID()+originalFilename;
        //封装上传文件位置全路径
        File targetFile = new File(filePath,newFileName);
        //把本地文件上传到封装上传文件位置的全路径
        file.transferTo(targetFile);
        product.setImage(newFileName);
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

    //文件（商品图）下载
    @RequestMapping(value="/download")
    public String downloads(HttpServletResponse response , HttpServletRequest request) throws Exception{
        //图片地址
        String path = "E:\\idea_workplace\\ssm\\web\\image";
        String fileName = request.getParameter("filename");
        //设置response 响应头
        response.reset(); //设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));
        File file = new File(path,fileName);
        //读取文件--输入流
        InputStream input=new FileInputStream(file);
        //写出文件--输出流
        OutputStream out = response.getOutputStream();
        byte[] buff =new byte[1024];
        int index=0;
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return null;
    }
}