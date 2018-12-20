package com.qfedu.sport.dao;

import com.qfedu.sport.domain.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component(value = "cardMapper")
public interface CardMapper {

    int insertSelective(Card record);

    List<Map<String,Object>> selectall(Integer uid);

    int updatecount(@Param("count") Integer count,@Param("cid") Integer cid);

    int updatecounttt(@Param("count") Integer count,@Param("uid") Integer uid,@Param("gid") Integer gid);

    int updatestatus(Integer cid);

    Card selectbygid(@Param("gid") Integer gid, @Param("uid") Integer uid);

    Map<String, Object> selectbycid(@Param("gid") Integer gid, @Param("uid") Integer uid);

}