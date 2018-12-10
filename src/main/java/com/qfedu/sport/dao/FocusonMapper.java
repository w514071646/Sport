package com.qfedu.sport.dao;

import com.qfedu.sport.domain.Focuson;
import com.qfedu.sport.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
@Mapper
@Component("FocusonMapper")
public interface FocusonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Focuson record);

    int insertSelective(Focuson record);

    Focuson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Focuson record);

    int updateByPrimaryKey(Focuson record);
    @Select("select uid fonsid from focuson where fid = #{id}")
    List<Map<String,Object>> findFans(int id);
    @Select("select fid starid from focuson where uid = #{id} ")
    List<Map<String,Object>> findStar(int id);

    List<Map> findAllFans(int[] arr);
}