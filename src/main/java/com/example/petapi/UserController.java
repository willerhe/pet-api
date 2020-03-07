package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import com.example.petapi.entity.UserDO;
import com.example.petapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/v1/hello")
    public JSONObject hello(UserDO userDO) {
        return Result.Success(userService.test(userDO));
    }

    @PostMapping("/v1/login")
    public JSONObject login(UserDO userDO) {
        return Result.Success(userService.login(userDO));
    }

    @PostMapping("/v1/register")
    public JSONObject register(UserDO userDO) {
        return Result.Success(userService.register(userDO));
    }
}
