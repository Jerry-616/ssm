package com.interceptor;

import com.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws ServletException, IOException {

        // 登陆页面放行
        System.out.println("uri: " + request.getRequestURI());
        if (request.getRequestURI().contains("login")) {
            return true;
        }
        // 注册页面放行
        System.out.println("uri: " + request.getRequestURI());
        if (request.getRequestURI().contains("register")) {
            return true;
        }
        // 用户、管理员已登陆放行
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return true;
        }else if (session.getAttribute("admin") != null){
            return true;
        }
        //如果cookie有值，放行
        User user = (User) request.getSession().getAttribute("user");
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie: cookies) {
                if("autologin".equals(cookie.getName())){
                    session.setAttribute("user", user);
                }
            }
            return true;
        }
        // 用户没有登陆跳转到登陆页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
