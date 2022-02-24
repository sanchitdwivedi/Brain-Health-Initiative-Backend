package com.healthcare.dummyNHR;

import com.healthcare.enumeration.Gender;
import com.healthcare.enumeration.Socioeconomic;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class NationalHealthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patient_id")
    private Integer patientId;

    @Column(nullable = false, name="abha_id")
    private String abhaId;

    @Column(nullable = false, name="first_name")
    private String first_name;

    @Column(nullable = false, name="last_name")
    private String last_name;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, name="socioeconomic_status")
    private Socioeconomic socioeconomic_status;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, name = "gender")
    private Gender gender;

    @Column(nullable = false, name = "education")
    private String education;

    @Column(nullable = false, name="moble_no")
    private Long mobile_no;

    @Column(nullable = false, name="address_line_1")
    private String address_line_1;

    @Column(nullable = false, name="address_line_2")
    private String address_line_2;

    @Column(nullable = false, name="district")
    private String district;

    @Column(nullable = false, name="state")
    private String state;

    @Column(nullable = false, name="pin_code")
    private Long pin_code;

    @Column(nullable = false, name="dob")
    private Date dob;

    public NationalHealthRecord() {}

    public NationalHealthRecord(Integer patientId, String abhaId, String first_name, String last_name, Socioeconomic socioeconomic_status, Gender gender, String education, Long mobile_no, String address_line_1, String address_line_2, String district, String state, Long pin_code, Date dob) {
        this.patientId = patientId;
        this.abhaId = abhaId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.socioeconomic_status = socioeconomic_status;
        this.gender = gender;
        this.education = education;
        this.mobile_no = mobile_no;
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.district = district;
        this.state = state;
        this.pin_code = pin_code;
        this.dob = dob;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public Date getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "NationalHealthRecord{" +
                "patientId=" + patientId +
                ", abhaId='" + abhaId + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", socioeconomic_status=" + socioeconomic_status +
                ", gender=" + gender +
                ", education='" + education + '\'' +
                ", mobile_no=" + mobile_no +
                ", address_line_1='" + address_line_1 + '\'' +
                ", address_line_2='" + address_line_2 + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", pin_code=" + pin_code +
                ", dob=" + dob +
                '}';
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

}

/**
 * Run these in workbench:
 * INSERT INTO `healthcaredb`.`national_health_record` (`patient_id`, `abha_id`, `address_line_1`, `address_line_2`, `district`, `dob`, `education`, `first_name`, `gender`, `last_name`, `moble_no`, `pin_code`, `socioeconomic_status`, `state`) VALUES ('1', '1122', 'IIITB', 'Electronic City', 'Bangalore', '1990-01-01', 'PhD', 'Rohit', '0', 'Kumar', '9988776655', '560100', '1', 'Karnataka');
 *
 * */