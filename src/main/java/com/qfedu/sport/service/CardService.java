package com.qfedu.sport.service;

import com.qfedu.sport.domain.Card;
import com.qfedu.sport.vo.Result;

public interface CardService {

    public Result addToCard(Card card);

    public Result selectcard(Integer uid);

    public Result updateStatus(Integer cid);

    public Result updateCount(Integer count,Integer cid);

    public Result buying(Card card);

}
