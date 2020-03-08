package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import com.example.petapi.entity.UserDO;
import com.example.petapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/v1/hello")
    public JSONObject hello(UserDO userDO) {
        return Result.Success(userService.test(userDO));
    }

    @PostMapping("/v1/login")
    public JSONObject login(@RequestBody UserDO userDO) {
        return Result.Success(userService.login(userDO));
    }

    @PostMapping("/v1/register")
    public JSONObject register(@RequestBody UserDO userDO) {
        return Result.Success(userService.register(userDO));
    }


    @GetMapping("/v1/users")
    public JSONObject list(UserDO userDO) {
        return Result.Success(userService.list(userDO));
    }


    @PostMapping("/v1/user")
    public JSONObject insert(UserDO userDO) {
        return Result.Success(userService.insert(userDO));
    }


    @PutMapping("/v1/user")
    public JSONObject update(UserDO userDO) {
        return Result.Success(userService.update(userDO));
    }

    @DeleteMapping("/v1/user")
    public JSONObject delete(UserDO userDO) {
        return Result.Success(userService.delete(userDO));
    }


}
