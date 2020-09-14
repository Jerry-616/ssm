package com.dao;
import com.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    //增加一个Product
    int addProduct(Product product);

    //按id删除一个Product
    int deleteProductById(@Param("productid")int id);

    //批量删除Product
    void deleteSelect(List<Integer> ids);

    //更新Product
    int updateProduct(Product product);

    //按id查询,返回Product
    Product queryProductById(@Param("productid") int id);

    //查询全部Product,返回list集合
    List<Product> queryAllProduct();

    //按名查询Product
    Product queryProductByName(@Param("productname") String productname);

}