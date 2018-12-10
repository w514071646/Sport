package com.qfedu.sport.service;

import com.qfedu.sport.domain.Goods;
import com.qfedu.sport.vo.Result;

import java.util.List;

public interface GoodsService {

    List<Goods> selectAllGoods();

    Result updateGoods(Goods goods);

    Result selectById(Integer id);

    Result delById(Integer id);


}
