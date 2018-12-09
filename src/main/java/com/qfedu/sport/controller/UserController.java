package com.qfedu.sport.controller;


import com.qfedu.sport.domain.User;
import com.qfedu.sport.utils.EmailUtils;
import com.qfedu.sport.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UserController {
    @GetMapping ("/api/v1/test")
    public Result regiest(String to){
        Random random = new Random();
       int code = random.nextInt(9999);
        EmailUtils email = new EmailUtils();
        try {
            email.sendMail("zhuque159@qq.com",code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
