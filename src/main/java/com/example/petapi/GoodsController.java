package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import com.example.petapi.entity.Goods;
import com.example.petapi.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/v1/goodsRecords")
    public JSONObject list(Goods goodsRecord) {
        return Result.Success(goodsService.list(goodsRecord));
    }


    @PostMapping("/v1/goodsRecord")
    public JSONObject insert(Goods goodsRecord) {
        return Result.Success(goodsService.insert(goodsRecord));
    }


    @PutMapping("/v1/goodsRecord")
    public JSONObject update(Goods goodsRecord) {
        return Result.Success(goodsService.update(goodsRecord));
    }

    @DeleteMapping("/v1/goodsRecord")
    public JSONObject delete(Goods goodsRecord) {
        return Result.Success(goodsService.delete(goodsRecord));
    }


}
