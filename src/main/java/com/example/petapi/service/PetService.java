package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.PetMapper;
import com.example.petapi.entity.Pet;
import com.example.petapi.entity.PetExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    PetMapper PetMapper;


    public Object list(Pet Pet) {
        PetExample e = new PetExample();
        PetExample.Criteria c = e.createCriteria();

        List<Pet> list = PetMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(Pet Pet) {
        return Result.Success(Pet);
    }

    public Object update(Pet Pet) {
        return Result.Success(Pet);
    }

    public Object delete(Pet Pet) {
        return Result.Success(Pet);
    }
}
