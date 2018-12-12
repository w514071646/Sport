package com.qfedu.sport.dao;

import com.qfedu.sport.domain.GTGI;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("GTGIMapper")
public interface GTGIMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GTGI record);

    int insertSelective(GTGI record);

    GTGI selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GTGI record);

    int updateByPrimaryKey(GTGI record);

    List<GTGI> selectByGtid(@Param("gtid") Integer gtid);
}