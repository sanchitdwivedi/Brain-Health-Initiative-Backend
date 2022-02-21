package com.healthcare.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id")
    private Integer patientId;

    @Id
    @Column(name="abha_id",unique = true,nullable = false)
    private String abhaId;

    @Column(nullable=false,name="patient_name")
    private String patient_name;

    @Column(name="dob")
    private Date dob;

    @Column(name="gender",nullable=false)
    private String gender;

    @Column(nullable=false,name="education")
    private String education;

    @Column(nullable=false,name="socioeconomic_status")
    private String socioeconomic_status;

    @Column(nullable=false,name="mobile_no")
    private String mobile_no;

    @Column(nullable=false,name="information_caregiver_name")
    private String information_caregiver_name;

    @Column(nullable=false,name="relationship_with_patient")
    private String relationship_with_patient;

    public Patient()
    {

    }

    public Patient(Integer patientId, String abhaId, String patient_name, Date dob, String gender, String education, String socioeconomic_status, String mobile_no, String information_caregiver_name, String relationship_with_patient) {
        this.patientId = patientId;
        this.abhaId = abhaId;
        this.patient_name = patient_name;
        this.dob = dob;
        this.gender = gender;
        this.education = education;
        this.socioeconomic_status = socioeconomic_status;
        this.mobile_no = mobile_no;
        this.information_caregiver_name = information_caregiver_name;
        this.relationship_with_patient = relationship_with_patient;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getAbhaId() {
        return abhaId;
    }

    public void setAbhaId(String abhaId) {
        this.abhaId = abhaId;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSocioeconomic_status() {
        return socioeconomic_status;
    }

    public void setSocioeconomic_status(String socioeconomic_status) {
        this.socioeconomic_status = socioeconomic_status;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getInformation_caregiver_name() {
        return information_caregiver_name;
    }

    public void setInformation_caregiver_name(String information_caregiver_name) {
        this.information_caregiver_name = information_caregiver_name;
    }

    public String getRelationship_with_patient() {
        return relationship_with_patient;
    }

    public void setRelationship_with_patient(String relationship_with_patient) {
        this.relationship_with_patient = relationship_with_patient;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", abhaId='" + abhaId + '\'' +
                ", patient_name='" + patient_name + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", education='" + education + '\'' +
                ", socioeconomic_status='" + socioeconomic_status + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                ", information_caregiver_name='" + information_caregiver_name + '\'' +
                ", relationship_with_patient='" + relationship_with_patient + '\'' +
                '}';
    }
}
