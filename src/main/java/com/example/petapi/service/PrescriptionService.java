package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.FeeMapper;
import com.example.petapi.dao.MedicalMapper;
import com.example.petapi.dao.MedicalRecordMapper;
import com.example.petapi.dao.PrescriptionMapper;
import com.example.petapi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrescriptionService {
    @Autowired
    PrescriptionMapper prescriptionMapper;
    @Autowired
    FeeMapper feeMapper;

    @Autowired
    MedicalRecordMapper medicalRecordMapper;

    public Object list(Prescription prescription) {
        PrescriptionExample e = new PrescriptionExample();
        PrescriptionExample.Criteria c = e.createCriteria();

        List<Prescription> list = prescriptionMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(Prescription prescription) {
        return Result.Success(prescription);
    }

    public Object update(Prescription prescription) {
        return Result.Success(prescription);
    }

    public Object delete(Prescription prescription) {
        return Result.Success(prescription);
    }

    public Object store(PrescriptionDto prescription) {
        // 添加处方
        String prescriptionId = UUID.randomUUID().toString();
        prescription.setId(prescriptionId);
        prescription.setIsDeleted(0);

        // 添加处方记录
        for (Fee fee : prescription.getFees()) {
            fee.setIsDeleted(0);
            fee.setId(UUID.randomUUID().toString());
            feeMapper.insert(fee);
            fee.setPrescriptionId(prescriptionId);
        }

        // 更新medical
        MedicalRecord m = medicalRecordMapper.selectByPrimaryKey(prescription.getMedicalId());
        m.setStatus(2);
        medicalRecordMapper.updateByPrimaryKey(m);


        prescriptionMapper.insert(prescription);


        return Result.Success(prescription);
    }
}
