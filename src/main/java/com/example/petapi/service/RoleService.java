package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.RoleMapper;
import com.example.petapi.entity.Role;
import com.example.petapi.entity.RoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public Object list(Role role) {
        RoleExample e = new RoleExample();
        RoleExample.Criteria c = e.createCriteria();

        List<Role> list = roleMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(Role role) {
        return Result.Success(role);
    }

    public Object update(Role role) {
        return Result.Success(role);
    }

    public Object delete(Role role) {
        return Result.Success(role);
    }
}
