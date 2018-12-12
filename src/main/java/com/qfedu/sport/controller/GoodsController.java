package com.qfedu.sport.controller;

import com.qfedu.sport.service.GoodsService;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    //根据商品类型查询商品
    @GetMapping("/api/v1/goods")
    public Result showGoods(Integer gtid) {
        return goodsService.showGoods(gtid);
    }


    //商品详情展示
    @GetMapping("/api/v1/goodsdetail")
    public Result showGoodsDetail(Integer id) {
        return goodsService.showGoodsDetail(id);
    }
}
