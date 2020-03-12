package com.example.petapi.dao;

import com.example.petapi.entity.Medical;
import com.example.petapi.entity.MedicalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MedicalMapper {
    long countByExample(MedicalExample example);

    int deleteByExample(MedicalExample example);

    int deleteByPrimaryKey(String id);

    int insert(Medical record);

    int insertSelective(Medical record);

    List<Medical> selectByExample(MedicalExample example);

    Medical selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Medical record, @Param("example") MedicalExample example);

    int updateByExample(@Param("record") Medical record, @Param("example") MedicalExample example);

    int updateByPrimaryKeySelective(Medical record);

    int updateByPrimaryKey(Medical record);
}