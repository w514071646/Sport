package com.qfedu.sport.controller;

import com.qfedu.sport.service.OrderService;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    //添加订单
    @PostMapping("/addtoorder")
    public Result addMessageToOrder(Integer[] str,Integer uid,Integer status) {
        return orderService.insertintoorder(str, uid, status);
    }

    //修改订单状态
    @GetMapping("/updateorderstatus")
    public Result updateOrderStatus(Integer uid,String ordernumber) {
        return orderService.updateStatus(uid, ordernumber);
    }

    //查询支付/未支付订单
    @PostMapping("/showpersonalorder")
    public Result showPersonalOrder(Integer uid,Integer orderstatus) {
        return orderService.selectOrder(uid, orderstatus);
    }

    //查询所有订单
    @PostMapping("/showallbyuid")
    public Result showAllByUid(Integer uid) {
        return orderService.selectAll(uid);
    }
}
