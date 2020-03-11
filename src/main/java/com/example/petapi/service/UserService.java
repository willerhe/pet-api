package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.Strings;
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
        // todo 查询是否有重复用户
        userDO.setId(UUID.randomUUID().toString());
        userDO.setIsDeleted(false);
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
        if(userDO.getPhoneNumber() != null){
            c.andPhoneNumberLike(userDO.getPhoneNumber());
        }
        if(userDO.getAccount() != null){
            c.andAccountLike(userDO.getAccount());
        }
        List<UserDO> list = userDOMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(UserDO userDO) {
        userDO.setId(UUID.randomUUID().toString());
        userDO.setNickname("用户" + Strings.getRandomString(10));
        userDO.setIsDeleted(false);
        userDOMapper.insert(userDO);
        return Result.Success(userDO);
    }

    public Object update(UserDO userDO) {
        UserDOExample e = new UserDOExample();
        UserDOExample.Criteria c = e.createCriteria();
        c.andIdEqualTo(userDO.getId());
        userDOMapper.updateByExample(userDO,e);
        return Result.Success(userDO);
    }

    public Object delete(UserDO userDO) {
        userDOMapper.deleteByPrimaryKey(userDO.getId());

        return Result.Success(userDO);
    }
}
