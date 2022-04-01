package com.healthcare.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
public class Medicine {
    private String medicineName;
    private String dosage;
    private String dosingTime;
    private Integer duration;

    public Medicine(){}

    public Medicine(String medicineName, String dosage, String dosingTime, Integer duration) {
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.dosingTime = dosingTime;
        this.duration = duration;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDosingTime() {
        return dosingTime;
    }

    public void setDosingTime(String dosingTime) {
        this.dosingTime = dosingTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineName='" + medicineName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", dosingTime='" + dosingTime + '\'' +
                ", duration=" + duration +
                '}';
    }
}
