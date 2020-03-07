package com.example.petapi.service;

import com.example.petapi.dao.UserDOMapper;
import com.example.petapi.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDOMapper userDOMapper;

   public UserDO test(UserDO userDO){
       userDO.setId("123124");
       userDO.setAccount("123123");
       userDO.setIsDeleted(false);
       userDOMapper.insert(userDO);


          return userDOMapper.selectByPrimaryKey("123124");
   }
}
