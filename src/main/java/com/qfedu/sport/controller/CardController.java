package com.qfedu.sport.controller;

import com.qfedu.sport.domain.Card;
import com.qfedu.sport.service.CardService;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    //为购物车添加商品
    @PostMapping("/addtocard")
    public Result addCard(Card card) {
        return cardService.addToCard(card);
    }

    //展示购物车中的商品
    @PostMapping("/showcard")
    public Result showCard(Integer uid){
        return cardService.selectcard(uid);
    }

    //修改购物车中商品的数量
    @GetMapping("/updatecountbynull")
    public Result updateCountByNull(Integer count,Integer cid) {
        return cardService.updateCount(count,cid);
    }
    //删除购物车中的商品
    @GetMapping("/delete")
    public Result deleteCard(Integer cid){
        return cardService.updateStatus(cid);
    }

}
