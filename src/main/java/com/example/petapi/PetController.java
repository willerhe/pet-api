package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import com.example.petapi.entity.Pet;
import com.example.petapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping("/v1/pets")
    public JSONObject list(Pet pet) {
        return Result.Success(petService.list(pet));
    }


    @PostMapping("/v1/pet")
    public JSONObject insert(Pet pet) {
        return Result.Success(petService.insert(pet));
    }


    @PutMapping("/v1/pet")
    public JSONObject update(Pet pet) {
        return Result.Success(petService.update(pet));
    }

    @DeleteMapping("/v1/pet")
    public JSONObject delete(Pet pet) {
        return Result.Success(petService.delete(pet));
    }


}
