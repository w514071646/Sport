package com.qfedu.sport.controller;


import com.qfedu.sport.domain.User;
import com.qfedu.sport.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping
    public Result regiest(User user){
        

        return  null;
    }
}
