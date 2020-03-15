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

    @GetMapping("/v1/goods")
    public JSONObject list(Goods goodsRecord) {
        return Result.Success(goodsService.list(goodsRecord));
    }


    @PostMapping("/v1/goods")
    public JSONObject insert(@RequestBody Goods goodsRecord) {
        return Result.Success(goodsService.insert(goodsRecord));
    }


    @PutMapping("/v1/goods")
    public JSONObject update(Goods goodsRecord) {
        return Result.Success(goodsService.update(goodsRecord));
    }

    @DeleteMapping("/v1/goods")
    public JSONObject delete(Goods goodsRecord) {
        return Result.Success(goodsService.delete(goodsRecord));
    }


}
