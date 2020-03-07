package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.UserDOMapper;
import com.example.petapi.entity.UserDO;
import com.example.petapi.entity.UserDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserDOMapper userDOMapper;

    public UserDO test(UserDO userDO) {
        userDO.setId("123124");
        userDO.setAccount("123123");
        userDO.setIsDeleted(false);
        userDOMapper.insert(userDO);
        return userDOMapper.selectByPrimaryKey("123124");
    }

    // 注册
    public UserDO register(UserDO userDO) {
        userDO.setId(UUID.randomUUID().toString());
        userDOMapper.insert(userDO);
        return userDOMapper.selectByPrimaryKey(userDO.getId());
    }

    // 登录
    public Object login(UserDO userDO) {
        UserDOExample e = new UserDOExample();
        UserDOExample.Criteria c = e.createCriteria();
        c.andPasswordEqualTo(userDO.getPassword());
        c.andAccountEqualTo(userDO.getAccount());
        List<UserDO> list = userDOMapper.selectByExample(e);
        if (list.size() == 0) {
            return Result.Failed("没有找到当前用户");
        } else {
            return Result.Success(list.get(0));
        }
    }


    public Object list(UserDO userDO) {
        UserDOExample e = new UserDOExample();
        UserDOExample.Criteria c = e.createCriteria();

        List<UserDO> list = userDOMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(UserDO userDO) {
        return Result.Success(userDO);
    }

    public Object update(UserDO userDO) {
        return Result.Success(userDO);
    }

    public Object delete(UserDO userDO) {
        return Result.Success(userDO);
    }
}
