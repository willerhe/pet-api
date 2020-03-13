package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.FeeMapper;
import com.example.petapi.entity.Fee;
import com.example.petapi.entity.FeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService {
    @Autowired
    FeeMapper feeMapper;

    public Object list(Fee fee) {
        FeeExample e = new FeeExample();
        FeeExample.Criteria c = e.createCriteria();

        List<Fee> list = feeMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(Fee fee) {
        return Result.Success(fee);
    }

    public Object update(Fee fee) {
        return Result.Success(fee);
    }

    public Object delete(Fee fee) {
        return Result.Success(fee);
    }

    public Object medicals(Fee fee) {
        FeeExample e = new FeeExample();
        FeeExample.Criteria c = e.createCriteria();
        c.andPrescriptionIdEqualTo(fee.getPrescriptionId());
        return Result.Success(feeMapper.selectByExample(e));
    }
}
