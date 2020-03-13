package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.MedicalRecordMapper;
import com.example.petapi.entity.MedicalRecord;
import com.example.petapi.entity.MedicalRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {
    @Autowired
    MedicalRecordMapper medicalRecordMapper;

    public Object list(MedicalRecord medicalRecord) {
        MedicalRecordExample e = new MedicalRecordExample();
        MedicalRecordExample.Criteria c = e.createCriteria();

        List<MedicalRecord> list = medicalRecordMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(MedicalRecord medicalRecord) {
        return Result.Success(medicalRecord);
    }

    public Object update(MedicalRecord medicalRecord) {
        medicalRecordMapper.updateByPrimaryKey(medicalRecord);

        return Result.Success(medicalRecord);
    }

    public Object delete(MedicalRecord medicalRecord) {
        medicalRecordMapper.deleteByPrimaryKey(medicalRecord.getId());
        return Result.Success(medicalRecord);
    }

    public Object getById(MedicalRecord medicalRecord) {
        medicalRecord = medicalRecordMapper.selectByPrimaryKey(medicalRecord.getId());
        return Result.Success(medicalRecord);
    }
}
