package com.healthcare.entity;

import com.healthcare.enumeration.EnumValidator;
import com.healthcare.enumeration.Gender;
import com.healthcare.enumeration.Socioeconomic;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name="uuid")
    private Integer uuid;

    @NotBlank
    @Size(min = 12, max = 12, message = "ABHA ID must be of 12 digits")
    @Column(name="abha_id",unique = true,nullable = false)
    private String abhaId;

    @NotBlank
    @Column(nullable=false,name="first_name")
    private String first_name;

    @NotBlank
    @Column(nullable=false,name="last_name")
    private String last_name;

    @NotNull
    @PastOrPresent
    @Column(nullable = false, name="dob")
    private Date dob;

    @NotBlank
    @EnumValidator(
            enumClazz = Gender.class,
            message = "Invalid gender value"
    )
    @Schema(allowableValues = { "MALE", "FEMALE", "OTHER" })
    @Column(name="gender",nullable=false)
    private String gender;

    @NotBlank
    @Column(nullable=false,name="education")
    private String education;

    @NotBlank
    @EnumValidator(
            enumClazz = Socioeconomic.class,
            message = "Invalid socio-economic status"
    )
    @Schema(allowableValues = { "BELOW_POVERTY_LINE", "ABOVE_POVERTY_LINE" })
    @Column(nullable=false,name="socioeconomic_status")
    private String socioeconomic_status;

    @NotNull
    @Range(min = 1000000000, max = 9999999999l, message = "Mobile no. must be of 10 digits")
    @Column(nullable=false,name="mobile_no")
    private Long mobile_no;

    @NotBlank
    @Column(nullable=false,name="address_line_1")
    private String address_line_1;

    @Column(name="address_line_2")
    private String address_line_2;

    @NotBlank
    @Column(nullable=false,name="district")
    private String district;

    @NotBlank
    @Column(nullable=false,name="state")
    private String state;

    @NotNull
    @Range(min = 100000, max = 999999, message = "Pincode must be of 6 digits")
    @Column(nullable=false,name="pin_code")
    private Long pin_code;

    @NotBlank
    @Column(nullable=false,name="information_caregiver_name")
    private String information_caregiver_name;

    @NotBlank
    @Column(nullable=false,name="relationship_with_patient")
    private String relationship_with_patient;

    public Patient()
    {

    }

    public Patient(Integer uuid, String abhaId, String first_name, String last_name, Date dob, String gender, String education, String socioeconomic_status, Long mobile_no, String address_line_1, String address_line_2, String district, String state, Long pin_code, String information_caregiver_name, String relationship_with_patient) {
        this.uuid = uuid;
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

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender.toUpperCase();
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
        this.socioeconomic_status = socioeconomic_status.toUpperCase();
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
                "patientId=" + uuid +
                ", abhaId='" + abhaId + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
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
