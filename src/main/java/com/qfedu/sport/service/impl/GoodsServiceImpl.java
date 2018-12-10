package com.qfedu.sport.service.impl;

import com.qfedu.sport.dao.GoodsMapper;
import com.qfedu.sport.domain.Goods;
import com.qfedu.sport.service.GoodsService;
import com.qfedu.sport.vo.CodeMsg;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    //查询所有商品信息
    @Override
    public List<Goods> selectAllGoods() {
        return goodsMapper.selectAllGoods();
    }

    //修改商品信息
    @Override
    public Result updateGoods(Goods goods) {
        if (goodsMapper.updateByPrimaryKey(goods)>0){
            return Result.success(goodsMapper.updateByPrimaryKey(goods));
        }else {
            return Result.error(CodeMsg.ERROR);
        }

    }

    //查询指定id的商品
    @Override
    public Result selectById(Integer id) {
        if(goodsMapper.selectByPrimaryKey(id)!=null){
            return Result.success(goodsMapper.selectByPrimaryKey(id));
        }else {
            return Result.error(CodeMsg.ERROR);
        }
    }

    //删除指定的商品
    @Override
    public Result delById(Integer id) {
        return Result.success(goodsMapper.deleteByPrimaryKey(id));
    }
}
