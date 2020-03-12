package com.example.petapi;

import com.alibaba.fastjson.JSONObject;
import com.example.petapi.entity.Appointment;
import com.example.petapi.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/v1/appointments")
    public JSONObject list(Appointment appointment) {
        return Result.Success(appointmentService.list(appointment));
    }


    @PostMapping("/v1/appointment")
    public JSONObject insert(@RequestBody Appointment appointment) {
        return Result.Success(appointmentService.insert(appointment));
    }


    @PutMapping("/v1/appointment")
    public JSONObject update(Appointment appointment) {
        return Result.Success(appointmentService.update(appointment));
    }


    @PutMapping("/v1/appointment/confirm")
    public JSONObject confirm(@RequestBody Appointment appointment) {
        return Result.Success(appointmentService.confirm(appointment));
    }

    @DeleteMapping("/v1/appointment")
    public JSONObject delete(Appointment appointment) {
        return Result.Success(appointmentService.delete(appointment));
    }


}
