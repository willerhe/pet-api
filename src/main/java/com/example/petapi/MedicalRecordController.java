package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import com.example.petapi.entity.MedicalRecord;
import com.example.petapi.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicalRecordController {

    @Autowired
    MedicalRecordService medicalRecordService;

    @GetMapping("/v1/medicalRecords")
    public JSONObject list(MedicalRecord medicalRecord) {
        return Result.Success(medicalRecordService.list(medicalRecord));
    }


    @PostMapping("/v1/medicalRecord")
    public JSONObject insert(MedicalRecord medicalRecord) {
        return Result.Success(medicalRecordService.insert(medicalRecord));
    }


    @PutMapping("/v1/medicalRecord")
    public JSONObject update(MedicalRecord medicalRecord) {
        return Result.Success(medicalRecordService.update(medicalRecord));
    }

    @DeleteMapping("/v1/medicalRecord")
    public JSONObject delete(MedicalRecord medicalRecord) {
        return Result.Success(medicalRecordService.delete(medicalRecord));
    }


}
