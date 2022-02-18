package com.healthcare.entity;

public class JwtResponse {
    private Doctor doctor;
    private String jwtToken;

    public JwtResponse(Doctor doctor, String jwtToken) {
        this.doctor = doctor;
        this.jwtToken = jwtToken;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
