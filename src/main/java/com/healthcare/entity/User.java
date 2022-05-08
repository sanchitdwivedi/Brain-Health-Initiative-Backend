package com.healthcare.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "uuid")
    private Integer uuid;
    @NotNull
    @Range(min = 100000000000l, max = 999999999999l, message = "User ID must be of 12 digits")
    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8, message = "Password must be atleast {min} characters long")
    @Column(name = "password", nullable = false)
    private String password;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "status", nullable = false)
    private Integer status = 0;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="role", nullable = false)
    private Role role;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer active = 1;

    public User(){

    }

    public User(Integer uuid, Long userId, String password, Integer status, Role role, Integer active) {
        this.uuid = uuid;
        this.userId = userId;
        this.password = password;
        this.status = status;
        this.role = role;
        this.active = active;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", userId=" + userId +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", role=" + role +
                ", active=" + active +
                '}';
    }
}
