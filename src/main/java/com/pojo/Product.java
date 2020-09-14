package com.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer productid;
    private String productname;
    private float price;
    private String sort;
    private int count;
    private String image;

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public float getPrice() {
        return price;
    }
}
