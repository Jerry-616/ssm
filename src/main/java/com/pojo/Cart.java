package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

        private int cartid;

        private String cartname;

        private double price;

        private Integer num;

        private String image;


}
