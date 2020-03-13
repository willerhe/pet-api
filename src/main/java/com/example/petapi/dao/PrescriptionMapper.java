package com.example.petapi.dao;

import com.example.petapi.entity.Prescription;
import com.example.petapi.entity.PrescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrescriptionMapper {
    long countByExample(PrescriptionExample example);

    int deleteByExample(PrescriptionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    List<Prescription> selectByExample(PrescriptionExample example);

    Prescription selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByExample(@Param("record") Prescription record, @Param("example") PrescriptionExample example);

    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKey(Prescription record);
}