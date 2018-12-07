package com.qfedu.sport.dao;

import com.qfedu.sport.domain.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component("AddressMapper")
public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectAllAddress(int uid);
    @Select("select * from address where id = #{id}")
    Address selectById(int id);
    @Delete("delecte from address where id =#{id}")
    int delAddress(int id);



}