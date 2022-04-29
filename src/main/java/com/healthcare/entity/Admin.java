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
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "uuid")
    private Integer uuid;
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "admin", nullable = false)
    @Valid
    private User admin;

    @NotBlank
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @NotBlank
    @Column(nullable = false, name = "last_name")
    private String lastName;
   /* @NotBlank
    @Column(nullable = false, name = "state")
    private String state;
    @NotBlank
    @Column(nullable = false, name = "district")
    private String district;
    @NotBlank
    @Column(nullable = false, name = "city")
    private String city;*/
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

    public Admin() {
    }

    public Admin(Integer uuid, User admin, String firstName, String lastName, Integer pincode, Long mobileNo, String email, String gender) {
        this.uuid = uuid;
        this.admin = admin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pincode = pincode;
        this.mobileNo = mobileNo;
        this.email = email;
        this.gender = gender;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
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
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "uuid=" + uuid +
                ", admin=" + admin +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pincode=" + pincode +
                ", mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
