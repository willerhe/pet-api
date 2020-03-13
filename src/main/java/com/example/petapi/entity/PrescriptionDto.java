package com.example.petapi.entity;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class PrescriptionDto extends Prescription {

    private String MedicalId;

    public String getMedicalId() {
        return MedicalId;
    }

    public void setMedicalId(String medicalId) {
        MedicalId = medicalId;
    }

    private List<Fee> fees;

    public List<Fee> getFees() {
        return fees;
    }

    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }
}
