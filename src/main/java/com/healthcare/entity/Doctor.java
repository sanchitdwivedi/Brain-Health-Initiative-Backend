package com.healthcare.entity;

import com.healthcare.enumeration.EnumValidator;
import com.healthcare.enumeration.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "uuid")
    private Integer uuid;
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "doctor", nullable = false)
    @Valid
    private User doctor;
    @NotBlank
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @NotBlank
    @Column(nullable = false, name = "last_name")
    private String lastName;
    @NotBlank
    @Column(nullable = false, name = "state")
    private String state;
    @NotBlank
    @Column(nullable = false, name = "district")
    private String district;
    @NotBlank
    @Column(nullable = false, name = "city")
    private String city;
    @NotNull
    @Range(min = 100000, max = 999999, message = "Pincode must be of 6 digits")
    @Column(nullable = false, name = "pincode")
    private Integer pincode;
    @NotNull
    @Range(min = 1000000000, max = 9999999999l, message = "Mobile no. must be of 10 digits")
    @Column(nullable = false, name = "mobile_no")
    private Long mobileNo;
    @Email
    @Column(name = "email")
    private String email;
    @NotBlank
    @EnumValidator(
            enumClazz = Gender.class,
            message = "Invalid gender value"
    )
    @Schema(allowableValues = { "MALE", "FEMALE", "OTHER" })
    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name="hospital_id", nullable = false)
    private Hospital hospital;

    public Doctor() {
    }

    public Doctor(Integer uuid, User doctor, String firstName, String lastName, String state, String district, String city, Integer pincode, Long mobileNo, String email, String genders, Hospital hospital) {
        this.uuid = uuid;
        this.doctor = doctor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.district = district;
        this.city = city;
        this.pincode = pincode;
        this.mobileNo = mobileNo;
        this.email = email;
        this.gender = gender;
        this.hospital = hospital;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender.toUpperCase();
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + uuid +
                ", doctor=" + doctor +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", state='" + state + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                ", mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", hospital=" + hospital +
                '}';
    }
}
