package com.qfedu.sport.service;

import com.qfedu.sport.vo.Result;

public interface GoodsService {
    public Result showGoods(Integer gtid);

    public Result showGoodsDetail(Integer id);
}