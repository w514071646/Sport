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

            return service.selectAllAddress(uid);
        }

    //修改收货地址
         @PostMapping("/api/v1/address")
          public Result updateAddress(Address address){

          return   service.updateAddress(address);
         }

    //查询指定收货地址
    @PostMapping("/api/v1/selectById")
    public Result selectAddress(Integer id){

            return service.selectById(id);
        }
    //删除指定收货地址
    @PostMapping("/api/v1/deladdress")
    public Result delAddress(Integer id){

        return service.delById(id);
    }






}
