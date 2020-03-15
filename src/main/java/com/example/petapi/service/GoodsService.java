package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.GoodsMapper;
import com.example.petapi.entity.Goods;
import com.example.petapi.entity.GoodsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    public Object list(Goods goods) {
        GoodsExample e = new GoodsExample();
        GoodsExample.Criteria c = e.createCriteria();

        List<Goods> list = goodsMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(Goods goods) {
        goods.setId(UUID.randomUUID().toString());
        goodsMapper.insert(goods);
        return Result.Success(goods);
    }

    public Object update(Goods goods) {
        return Result.Success(goods);
    }

    public Object delete(Goods goods) {
        goodsMapper.deleteByPrimaryKey(goods.getId());
        return Result.Success(goods);
    }
}
