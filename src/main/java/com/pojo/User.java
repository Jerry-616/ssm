package com.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.INTERNAL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userid;
    private String username;
    private String password;
    private String sex;
    private String adress;
    private String phone;
}

