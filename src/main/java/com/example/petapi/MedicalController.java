package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import com.example.petapi.entity.Medical;
import com.example.petapi.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicalController {

    @Autowired
    MedicalService medicalService;

    @GetMapping("/v1/medicals")
    public JSONObject list(Medical medical) {
        return Result.Success(medicalService.list(medical));
    }


    @PostMapping("/v1/medical")
    public JSONObject insert(@RequestBody Medical medical) {
        return Result.Success(medicalService.insert(medical));
    }


    @PutMapping("/v1/medical")
    public JSONObject update(@RequestBody Medical medical) {
        return Result.Success(medicalService.update(medical));
    }

    @DeleteMapping("/v1/medical")
    public JSONObject delete(Medical medical) {
        return Result.Success(medicalService.delete(medical));
    }


}
