package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.PetMapper;
import com.example.petapi.entity.Pet;
import com.example.petapi.entity.PetExample;
import com.example.petapi.entity.UserDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PetService {
    @Autowired
    PetMapper petMapper;


    public Object list(Pet Pet) {
        PetExample e = new PetExample();
        PetExample.Criteria c = e.createCriteria();
        c.andIsDeletedEqualTo(false);

        List<Pet> list = petMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(Pet pet) {
        pet.setId(UUID.randomUUID().toString());
        pet.setIsDeleted(false);
        petMapper.insert(pet);
        return Result.Success(pet);
    }

    public Object update(Pet Pet) {
        return Result.Success(Pet);
    }

    public Object delete(Pet pet) {
        pet.setIsDeleted(true);
        PetExample e = new PetExample();
        PetExample.Criteria c = e.createCriteria();
        c.andIdEqualTo(pet.getId());
        petMapper.updateByExample(pet, e);

        return Result.Success("成功");
    }
}
