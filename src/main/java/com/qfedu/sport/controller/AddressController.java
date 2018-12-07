package com.qfedu.sport.controller;


import com.qfedu.sport.domain.Address;
import com.qfedu.sport.service.AddressService;
import com.qfedu.sport.vo.CodeMsg;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
        @Autowired
        private AddressService service;
        //查询所有收货地址
        @GetMapping("/api/v1/address")
        public Result selectAll(Integer uid){

            if (service.selectAllAddress(uid) != null){

                return  Result.success(service.selectAllAddress(uid));
            } else {

                return Result.error(CodeMsg.ERROR);
            }
        }

    //修改收货地址
         @PostMapping("/api/v1/address")
          public Result updateAddress(Address address){

        if (service.selectAllAddress(address.getUid()) != null){

            return  Result.success(service.selectAllAddress(address.getUid()));
        } else {

            return Result.error(CodeMsg.ERROR);
        }
    }

}
