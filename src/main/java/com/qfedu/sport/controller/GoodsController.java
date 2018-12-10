package com.qfedu.sport.controller;

import com.qfedu.sport.domain.Goods;
import com.qfedu.sport.service.GoodsService;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    //查询所有商品
    @GetMapping("/api/v1/goods")
    public List<Goods> selectAll(){
        return goodsService.selectAllGoods();
    }

    //修改商品信息
    @PostMapping("/api/v1/modifygoods")
    public Result updateGoods(Goods goods){

        return  goodsService.updateGoods(goods);
    }

    //查询指定商品信息
    @GetMapping("/api/v1/selectgoodsById")
    public Result selectGoods(Integer id){

        return goodsService.selectById(id);
    }
    //删除指定商品
    @PostMapping("/api/v1/delgoods")
    public Result delGoods(Integer id){

        return goodsService.delById(id);
    }


}
