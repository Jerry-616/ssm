package com.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.INTERNAL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productid;
    private String productname;
    private float price;
    private String sort;
    private int count;
}
