package com.example.petapi.dao;

import com.example.petapi.entity.Pet;
import com.example.petapi.entity.PetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetMapper {
    long countByExample(PetExample example);

    int deleteByExample(PetExample example);

    int insert(Pet record);

    int insertSelective(Pet record);

    List<Pet> selectByExample(PetExample example);

    int updateByExampleSelective(@Param("record") Pet record, @Param("example") PetExample example);

    int updateByExample(@Param("record") Pet record, @Param("example") PetExample example);
}