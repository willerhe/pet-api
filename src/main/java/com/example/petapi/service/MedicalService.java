package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.Strings;
import com.example.petapi.dao.MedicalMapper;
import com.example.petapi.entity.Medical;
import com.example.petapi.entity.MedicalExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicalService {
    @Autowired
    MedicalMapper medicalMapper;

    public Object list(Medical medical) {
        MedicalExample e = new MedicalExample();
        MedicalExample.Criteria c = e.createCriteria();
        if (medical.getName() != null) {
            c.andNameLike(medical.getName());
        }

        List<Medical> list = medicalMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(Medical medical) {
        medical.setId(UUID.randomUUID().toString());
        medical.setIsDeleted(0);
        medical.setStatus(0);
        medical.setNo(Strings.getRandomString(10).toUpperCase());
        medicalMapper.insert(medical);
        return Result.Success(medical);
    }

    public Object update(Medical medical) {
        medicalMapper.updateByPrimaryKey(medical);
        return Result.Success(medical);
    }

    public Object delete(Medical medical) {
        medicalMapper.deleteByPrimaryKey(medical.getId());
        return Result.Success(medical);
    }


    public Object getById(Medical medical) {
        medicalMapper.selectByPrimaryKey(medical.getId());
        return Result.Success(medical);
    }
}
