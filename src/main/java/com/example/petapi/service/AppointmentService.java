package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.AppointmentMapper;
import com.example.petapi.dao.PetMapper;
import com.example.petapi.entity.Appointment;
import com.example.petapi.entity.AppointmentExample;
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

    public Object list(Appointment appointment) {
        AppointmentExample e = new AppointmentExample();
        AppointmentExample.Criteria c = e.createCriteria();

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

    public Object delete(Appointment appointment) {
        return Result.Success(appointment);
    }
}
