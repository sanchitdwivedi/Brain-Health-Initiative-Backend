package com.healthcare.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "hospital_id")
    private Integer hospitalId;
    @NotBlank
    @Column(name = "hospital_name", nullable = false, unique = true)
    private String hospitalName;
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

    @ManyToOne
    @JoinColumn(name="level", nullable = false)
    private Level level;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer active = 1;

    public Hospital() {
    }

    public Hospital(Integer hospitalId, String hospitalName, String state, String district, String city, Integer pincode, Level level, Integer active) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.state = state;
        this.district = district;
        this.city = city;
        this.pincode = pincode;
        this.level = level;
        this.active = active;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
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

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ", state='" + state + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                ", level=" + level +
                ", active=" + active +
                '}';
    }
}
