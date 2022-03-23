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

    public Medicine(){}

    public Medicine(String medicineName, String dosage, String dosingTime) {
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.dosingTime = dosingTime;
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

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineName='" + medicineName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", dosingTime='" + dosingTime + '\'' +
                '}';
    }
}
