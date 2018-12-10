package com.qfedu.sport.dao;

import com.qfedu.sport.domain.Card;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "cardMapper")
public interface CardMapper {

    int insertSelective(Card record);

    List<Map<String,Object>> selectall(Integer uid);

    int updatecount(Integer count,Integer cid);

    int updatestatus(Integer cid);
}