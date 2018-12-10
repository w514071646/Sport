package com.qfedu.sport.controller;


import com.qfedu.sport.service.UserService;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    //注册
    @PostMapping("/regist")
    public Result userRegist(String email, String password,String code) {
        System.out.println("email1:" + email);
        return userService.regist(email,password,code);
    }

    //发送邮箱验证码
    @GetMapping("/emailcode")
    public Result emaliCode(String email) {
        return userService.EmailCode(email);
    }

    //登录
    @GetMapping("/login")
    public Result userLogin(String email, String password, String token, HttpServletRequest request, HttpServletResponse response){

        return userService.login(email,password,token,request,response);
    }
}
