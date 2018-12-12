package com.qfedu.sport.service.impl;

import com.qfedu.sport.dao.GTGIMapper;
import com.qfedu.sport.dao.GoodsMapper;
import com.qfedu.sport.service.GoodsService;
import com.qfedu.sport.vo.CodeMsg;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GTGIMapper gtgiMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Result showGoods(Integer gtid) {
        return gtgiMapper.selectByGtid(gtid) != null ? Result.success(gtgiMapper.selectByGtid(gtid)) : Result.error(CodeMsg.ERROR);
    }

    @Override
    public Result showGoodsDetail(Integer id) {
        return goodsMapper.selectById(id) != null ? Result.success(goodsMapper.selectById(id)) : Result.error(CodeMsg.ERROR);
    }
}
