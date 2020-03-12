package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.AppointmentMapper;
import com.example.petapi.dao.MedicalRecordMapper;
import com.example.petapi.dao.PetMapper;
import com.example.petapi.entity.Appointment;
import com.example.petapi.entity.AppointmentExample;
import com.example.petapi.entity.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {
    @Autowired
    AppointmentMapper appointmentMapper;
    @Autowired
    PetMapper petMapper;
    @Autowired
    MedicalRecordMapper medicalRecordMapper;

    public Object list(Appointment appointment) {
        AppointmentExample e = new AppointmentExample();
        AppointmentExample.Criteria c = e.createCriteria();
        e.setOrderByClause("promise_time desc");
        c.andIsDeletedNotEqualTo(1);

        List<Appointment> list = appointmentMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(Appointment appointment) {
        appointment.setIsDeleted(0);
        appointment.setId(UUID.randomUUID().toString());
        appointment.setStatus(0);
        appointmentMapper.insert(appointment);
        return Result.Success(appointment);
    }

    public Object update(Appointment appointment) {
        return Result.Success(appointment);
    }

    public Object confirm(Appointment appointment) {
        // 在这里生成一条就诊记录
        MedicalRecord md = new MedicalRecord();

        md.setPatientName(appointment.getPetName());
        md.setReason(appointment.getRemark());
        md.setId(UUID.randomUUID().toString());
        md.setPhoneNumber(appointment.getPhoneNumber());
        md.setPatientId(appointment.getUserId());
        md.setIsDeleted(false);
        md.setStatus(0);

        medicalRecordMapper.insert(md);

        appointment.setStatus(1);
        appointmentMapper.updateByPrimaryKey(appointment);


        return Result.Success(appointment);
    }

    public Object delete(Appointment appointment) {
        appointment.setIsDeleted(1);
        AppointmentExample e = new AppointmentExample();
        AppointmentExample.Criteria c = e.createCriteria();
        c.andIdEqualTo(appointment.getId());
        appointmentMapper.updateByExample(appointment, e);
        return Result.Success(appointment);
    }
}
