package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/v1/hello")
    public JSONObject hello(){

        return Result.Success("你好");
    }
}
