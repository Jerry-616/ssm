package com.service;

import com.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {
    //增加一个Product
    int addProduct(Product product);

    //根据id删除一个Product
    int deleteProductById(int id);

    //批量删除Product
    void deleteSelect(List<Integer> ids);

    //编辑Product
    int updateProduct(Product product);

    //根据id查询,返回一个Product
    Product queryProductById(int id);

    //查询全部Product,返回list集合
    List<Product> queryAllProduct();

    //按名查询Product
    Product queryProductByName(String productname);

}
