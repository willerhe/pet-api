package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import com.example.petapi.entity.Fee;
import com.example.petapi.entity.Prescription;
import com.example.petapi.entity.PrescriptionDto;
import com.example.petapi.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PrescriptionController {

    @Autowired
    PrescriptionService prescriptionService;

    @GetMapping("/v1/prescriptions")
    public JSONObject list(Prescription prescription) {
        return Result.Success(prescriptionService.list(prescription));
    }

    @GetMapping("/v1/prescription")
    public JSONObject getById(Prescription prescription) {
        return Result.Success(prescriptionService.getById(prescription));
    }


    @PostMapping("/v1/prescription")
    public JSONObject insert(Prescription prescription) {
        return Result.Success(prescriptionService.insert(prescription));
    }

    @PostMapping("/v1/prescription/store")
    public JSONObject store(@RequestBody PrescriptionDto prescription) {
        return Result.Success(prescriptionService.store(prescription));
    }


    @PutMapping("/v1/prescription")
    public JSONObject update(Prescription prescription) {
        return Result.Success(prescriptionService.update(prescription));
    }

    @DeleteMapping("/v1/prescription")
    public JSONObject delete(Prescription prescription) {
        return Result.Success(prescriptionService.delete(prescription));
    }


}
