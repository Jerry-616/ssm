package com.dao;

import com.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    //登录验证
    Admin login(@Param("adminname") String adminname,
                @Param("password") String password);
}
