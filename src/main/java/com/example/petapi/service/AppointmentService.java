package com.example.petapi.service;

import com.example.petapi.Result;
import com.example.petapi.dao.AppointmentMapper;
import com.example.petapi.entity.Appointment;
import com.example.petapi.entity.AppointmentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentMapper appointmentMapper;

    public Object list(Appointment appointment) {
        AppointmentExample e = new AppointmentExample();
        AppointmentExample.Criteria c = e.createCriteria();

        List<Appointment> list = appointmentMapper.selectByExample(e);
        return Result.Success(list);

    }

    public Object insert(Appointment appointment) {
        return Result.Success(appointment);
    }

    public Object update(Appointment appointment) {
        return Result.Success(appointment);
    }

    public Object delete(Appointment appointment) {
        return Result.Success(appointment);
    }
}
