package com.qfedu.sport.service.impl;

import com.qfedu.sport.dao.OrderMapper;
import com.qfedu.sport.domain.Order;
import com.qfedu.sport.service.OrderService;
import com.qfedu.sport.vo.CodeMsg;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Result insertintoorder(Integer[] str,Integer uid,Integer status) {
        Order order = new Order();
        order.setUid(uid);
        order.setOrderstatus(status);
        String ordernumber = UUID.randomUUID().toString();
        order.setOrdernumber(ordernumber);
        for (Integer cid : str) {
            order.setCid(cid);
            orderMapper.insertSelective(order);
        }

        return  Result.error(CodeMsg.SUCCESS);
    }

    @Override
    public Result updateStatus(Integer uid,String ordernumber) {
        return orderMapper.updatestatus(uid,ordernumber) > 0 ? Result.error(CodeMsg.SUCCESS) :  Result.error(CodeMsg.ERROR);
    }

    @Override
    public Result selectOrder(Integer uid, Integer orderstatus) {
        return orderMapper.select(uid, orderstatus) != null ? Result.success(orderMapper.select(uid, orderstatus)) : Result.error(CodeMsg.ERROR);
    }

    @Override
    public Result selectAll(Integer uid) {
        return orderMapper.selectall(uid) != null ? Result.success(orderMapper.selectall(uid)) : Result.error(CodeMsg.ERROR);
    }
}
