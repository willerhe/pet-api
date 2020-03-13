package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import com.example.petapi.entity.Fee;
import com.example.petapi.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeeController {

    @Autowired
    FeeService feeService;

    @GetMapping("/v1/fees")
    public JSONObject list(Fee fee) {
        return Result.Success(feeService.list(fee));
    }

    @GetMapping("/v1/fee/medicals")
    public JSONObject medicals(Fee fee) {
        return Result.Success(feeService.medicals(fee));
    }


    @PostMapping("/v1/fee")
    public JSONObject insert(Fee fee) {
        return Result.Success(feeService.insert(fee));
    }


    @PutMapping("/v1/fee")
    public JSONObject update(Fee fee) {
        return Result.Success(feeService.update(fee));
    }

    @DeleteMapping("/v1/fee")
    public JSONObject delete(Fee fee) {
        return Result.Success(feeService.delete(fee));
    }


}
