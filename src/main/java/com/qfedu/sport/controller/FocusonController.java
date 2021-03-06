package com.qfedu.sport.controller;


import com.qfedu.sport.service.FocusonService;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//查看自身粉丝
@RestController
public class FocusonController {
    @Autowired
    private FocusonService service;
    //查看所有自身粉丝详情
    @GetMapping("/api/v1/follow")
    public Result follow(Integer id){


        return service.follow(id);
    }
    //查看所有关注人的信息
    @GetMapping("/api/v1/concerned")
    public Result concerned(Integer id){

        return service.concerned(id);
    }









}
