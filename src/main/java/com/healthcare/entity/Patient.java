package com.healthcare.entity;

import com.healthcare.enumeration.Gender;
import com.healthcare.enumeration.Socioeconomic;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id")
    private Integer patientId;

    @Column(name="abha_id",unique = true,nullable = false)
    private String abhaId;

    @Column(nullable=false,name="first_name")
    private String first_name;

    @Column(nullable=false,name="last_name")
    private String last_name;

    @Column(name="dob")
    private Date dob;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="gender",nullable=false)
    private Gender gender;

    @Column(nullable=false,name="education")
    private String education;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable=false,name="socioeconomic_status")
    private Socioeconomic socioeconomic_status;

    @Column(nullable=false,name="mobile_no")
    private Long mobile_no;

    @Column(nullable=false,name="address_line_1")
    private String address_line_1;

    @Column(name="address_line_2")
    private String address_line_2;

    @Column(nullable=false,name="district")
    private String district;

    @Column(nullable=false,name="state")
    private String state;

    @Column(nullable=false,name="pin_code")
    private Long pin_code;

    @Column(nullable=false,name="information_caregiver_name")
    private String information_caregiver_name;

    @Column(nullable=false,name="relationship_with_patient")
    private String relationship_with_patient;

    public Patient()
    {

    }

    public Patient(Integer patientId, String abhaId, String first_name, String last_name, Date dob, Gender gender, String education, Socioeconomic socioeconomic_status, Long mobile_no, String address_line_1, String address_line_2, String district, String state, Long pin_code, String information_caregiver_name, String relationship_with_patient) {
        this.patientId = patientId;
        this.abhaId = abhaId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.gender = gender;
        this.education = education;
        this.socioeconomic_status = socioeconomic_status;
        this.mobile_no = mobile_no;
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.district = district;
        this.state = state;
        this.pin_code = pin_code;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Socioeconomic getSocioeconomic_status() {
        return socioeconomic_status;
    }

    public void setSocioeconomic_status(Socioeconomic socioeconomic_status) {
        this.socioeconomic_status = socioeconomic_status;
    }

    public Long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(Long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPin_code() {
        return pin_code;
    }

    public void setPin_code(Long pin_code) {
        this.pin_code = pin_code;
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
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", education='" + education + '\'' +
                ", socioeconomic_status=" + socioeconomic_status +
                ", mobile_no=" + mobile_no +
                ", address_line_1='" + address_line_1 + '\'' +
                ", address_line_2='" + address_line_2 + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", pin_code=" + pin_code +
                ", information_caregiver_name='" + information_caregiver_name + '\'' +
                ", relationship_with_patient='" + relationship_with_patient + '\'' +
                '}';
    }
}
