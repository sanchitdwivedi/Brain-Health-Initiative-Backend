package com.healthcare.controller;

import com.healthcare.entity.Doctor;
import com.healthcare.exception.APIRequestException;
import com.healthcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("")
    public Doctor createDoctor(@RequestBody Doctor doctor){
        Doctor d = doctorService.createDoctor(doctor);
        if(d==null) throw new APIRequestException("The provided role/hospital is not a valid one!");
        return d;
    }

    @GetMapping("")
    public List<Doctor> getAllDoctors(){
        List<Doctor> doctors = doctorService.getAllDoctors();
        return doctors;
    }

    @PutMapping("/{id}")
    public Doctor updatePassword(@PathVariable long id, @RequestBody Map<String, String> object){
        Doctor doctor = doctorService.updatePassword(id, object.get("newPassword"));
        if(doctor==null) throw new APIRequestException("Cannot change password of doctor with id: " + id);
        return doctor;
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable long id){
        return doctorService.getDoctorByHealthId(id);
    }

    @GetMapping("/specialist")
    @PreAuthorize("hasRole('specialist')")
    public String forSpecialist(){
        return "Welcome Specialist";
    }

    @GetMapping("/medical-officer")
    @PreAuthorize("hasRole('medical officer')")
    public String forMedicalOfficer(){
        return "Welcome Medical officer";
    }
}
