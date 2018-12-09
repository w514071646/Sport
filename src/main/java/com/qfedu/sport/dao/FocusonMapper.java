package com.qfedu.sport.dao;

import com.qfedu.sport.domain.Focuson;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Array;
import java.util.Map;

public interface FocusonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Focuson record);

    int insertSelective(Focuson record);

    Focuson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Focuson record);

    int updateByPrimaryKey(Focuson record);
    @Select("select uid fons from focuson where fid = #{id}")
    Array findFans(int id);

}