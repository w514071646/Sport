package com.qfedu.sport.dao;

import com.qfedu.sport.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "orderMapper")
public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int updatestatus(Integer uid,String ordernumber);

    List<Map<String,Order>> select(Integer uid,Integer orderstatus);

    List<Map<String,Order>> selectall(Integer uid);
}