package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import com.example.petapi.entity.Role;
import com.example.petapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/v1/roles")
    public JSONObject list(Role role) {
        return Result.Success(roleService.list(role));
    }


    @PostMapping("/v1/role")
    public JSONObject insert(Role role) {
        return Result.Success(roleService.insert(role));
    }


    @PutMapping("/v1/role")
    public JSONObject update(Role role) {
        return Result.Success(roleService.update(role));
    }

    @DeleteMapping("/v1/role")
    public JSONObject delete(Role role) {
        return Result.Success(roleService.delete(role));
    }


}
