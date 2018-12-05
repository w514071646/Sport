package com.qfedu.sport.controller;


import com.qfedu.sport.domain.Address;
import com.qfedu.sport.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {



        @PostMapping
        public Result sava(Address address){



            return  null;
        }

}
