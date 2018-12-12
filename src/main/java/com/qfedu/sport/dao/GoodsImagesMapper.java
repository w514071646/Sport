package com.qfedu.sport.dao;

import com.qfedu.sport.domain.GoodsImages;

public interface GoodsImagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsImages record);

    int insertSelective(GoodsImages record);

    GoodsImages selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsImages record);

    int updateByPrimaryKey(GoodsImages record);
}