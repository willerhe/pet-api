package com.example.petapi.dao;

import com.example.petapi.entity.MedicalRecord;
import com.example.petapi.entity.MedicalRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MedicalRecordMapper {
    long countByExample(MedicalRecordExample example);

    int deleteByExample(MedicalRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(MedicalRecord record);

    int insertSelective(MedicalRecord record);

    List<MedicalRecord> selectByExample(MedicalRecordExample example);

    MedicalRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MedicalRecord record, @Param("example") MedicalRecordExample example);

    int updateByExample(@Param("record") MedicalRecord record, @Param("example") MedicalRecordExample example);

    int updateByPrimaryKeySelective(MedicalRecord record);

    int updateByPrimaryKey(MedicalRecord record);
}