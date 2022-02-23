package com.healthcare.entity;

import com.healthcare.enumeration.Gender;

import javax.persistence.*;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Column(nullable = false, unique = true, name = "health_id")
    private Long healthId;
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(nullable = false, name = "last_name")
    private String lastName;
    @Column(nullable = false, name = "state")
    private String state;
    @Column(nullable = false, name = "district")
    private String district;
    @Column(nullable = false, name = "city")
    private String city;
    @Column(nullable = false, name = "pincode")
    private Integer pincode;
    @Column(nullable = false, name = "mobile_no")
    private Long mobileNo;
    @Column(name = "email")
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "status", nullable = false)
    private Integer status = 0;

    @ManyToOne
    @JoinColumn(name="hospital_id", nullable = false)
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name="role", nullable = false)
    private Role role;

    public Doctor() {
    }

    public Doctor(Integer doctorId, Long healthId, String firstName, String lastName, String state, String district, String city, Integer pincode, Long mobileNo, String email, String password, Gender gender, Integer status, Hospital hospital, Role role) {
        this.doctorId = doctorId;
        this.healthId = healthId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.district = district;
        this.city = city;
        this.pincode = pincode;
        this.mobileNo = mobileNo;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.status = status;
        this.hospital = hospital;
        this.role = role;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Long getHealthId() {
        return healthId;
    }

    public void setHealthId(Long healthId) {
        this.healthId = healthId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", healthId=" + healthId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", state='" + state + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                ", mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", status=" + status +
                ", hospital=" + hospital +
                ", role=" + role +
                '}';
    }
}
