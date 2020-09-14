package com.service;
import com.dao.ProductMapper;
import com.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import  java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductService{
    //service调dao层：组合Dao
    @Autowired
    private ProductMapper productMapper;
    public void setProductMapper(ProductMapper productMapper){
        this.productMapper = productMapper;
    }

    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    public int deleteProductById(int id) {
        return productMapper.deleteProductById(id);
    }

    public void deleteSelect(List<Integer> ids) {
        productMapper.deleteSelect(ids);
    }

    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    public Product queryProductById(int id) {
        return productMapper.queryProductById(id);
    }

    public List<Product> queryAllProduct() {
        return productMapper.queryAllProduct();
    }

    public Product queryProductByName(String productname) {
        return productMapper.queryProductByName(productname);
    }

}
