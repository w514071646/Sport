package com.qfedu.sport.service.impl;

import com.qfedu.sport.dao.CardMapper;
import com.qfedu.sport.domain.Card;
import com.qfedu.sport.service.CardService;
import com.qfedu.sport.vo.CodeMsg;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CardServiceImpl implements CardService {


    @Autowired
    private CardMapper cardMapper;

    @Override
    public Result<Card> addToCard(Card card) {
       /* int i = cardMapper.insertSelective(card);

        Result vo = null;

        if (i > 0 ) {
            vo = Result.OK();
        } else {
            vo = Result.error();
        }*/
       int gid = card.getGid();
       int uid = card.getUid();
       Card record = cardMapper.selectbygid(gid,uid);
       if( record != null){
           int rcount = card.getCount();
           int count = rcount + record.getCount();
           System.out.println("coumt"+ count );
           System.out.println("uid"+ + uid);
           cardMapper.updatecounttt(count,uid,gid);
           return Result.error(CodeMsg.SUCCESS);
       } else {
           return cardMapper.insertSelective(card) > 0 ? Result.error(CodeMsg.SUCCESS) : Result.error(CodeMsg.ERROR);

       }
        //return cardMapper.insertSelective(card) > 0 ? Result.error(CodeMsg.SUCCESS) : Result.error(CodeMsg.ERROR);
    }

    @Override
    public Result selectcard(Integer uid) {
       /* List<Map<String,Object>> map = cardMapper.selectall(uid);
        Result vo = null;*/
       /* if (map != null) {
            vo = Result.success(map);
        } else {
            vo = Result.error(CodeMsg.ERROR);
        }*/
        return cardMapper.selectall(uid) != null ? Result.success(cardMapper.selectall(uid)): Result.error(CodeMsg.ERROR);
    }

    @Override
    public Result updateStatus(Integer cid) {
        return cardMapper.updatestatus(cid) > 0 ? Result.error(CodeMsg.SUCCESS) : Result.error(CodeMsg.ERROR);
    }

    @Override
    public Result updateCount(Integer count, Integer cid) {
        return cardMapper.updatecount(count,cid) > 0 ? Result.error(CodeMsg.SUCCESS) : Result.error(CodeMsg.ERROR);
    }

    @Override
    public Result buying(Card card) {
        if(cardMapper.insertSelective(card) > 0) {
            Map map = cardMapper.selectbycid(card.getGid(), card.getUid());
            System.out.println(map.get("cid"));
            return Result.error(CodeMsg.SUCCESS);
        } else {
            return Result.error(CodeMsg.ERROR);
        }
    }

}