package com.qfedu.sport.service;

import com.qfedu.sport.domain.Order;
import com.qfedu.sport.vo.Result;

public interface OrderService {

    public Result insertintoorder(Integer[] str,Integer uid,Integer status);

    public Result updateStatus(Integer uid, String ordernumber);

    public Result selectOrder(Integer uid,Integer orderstatus);

    public Result selectAll(Integer uid);

}
