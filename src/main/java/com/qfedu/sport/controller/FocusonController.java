package com.qfedu.sport.controller;


import com.qfedu.sport.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//查看自身粉丝
@RestController
public class FocusonController {
    @GetMapping("/api/v1/follow")
    public Result  follow(int id){

        return  null;
    }



}
