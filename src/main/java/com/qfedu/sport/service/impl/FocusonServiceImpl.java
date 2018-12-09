package com.qfedu.sport.service.impl;

import com.qfedu.sport.dao.FocusonMapper;
import com.qfedu.sport.service.FocusonService;
import com.qfedu.sport.vo.CodeMsg;
import com.qfedu.sport.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class FocusonServiceImpl implements FocusonService {
    @Autowired
    private FocusonMapper dao;
    //找出所有关注我的人的信息
    @Override
    public Result follow(int id) {

        List<Map<String,Object>> list = dao.findFans(id);
        int[] arr = new int[list.size()];
        if (list!= null) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    arr[i] = (int) map.get(str);
                }
            }
            return Result.success(dao.findAllFans(arr));
        }else {

            return  Result.error(CodeMsg.ERROR);
        }

    }
    //找出所有被我关注的人
    @Override
    public Result concerned(int id) {
        List<Map<String,Object>> list = dao.findStar(id);
        int[] arr = new int[list.size()];
        if (list!= null) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = list.get(i);
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    arr[i] = (int) map.get(str);
                }
            }
            return Result.success(dao.findAllFans(arr));
        }else {

            return  Result.error(CodeMsg.ERROR);
        }


    }
}
