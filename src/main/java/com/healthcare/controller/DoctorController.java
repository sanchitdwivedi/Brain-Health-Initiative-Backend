package com.healthcare.controller;

import com.healthcare.entity.Doctor;
import com.healthcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("")
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody Doctor doctor){
        Doctor d = doctorService.createDoctor(doctor);
        return new ResponseEntity<Doctor>(d, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Doctor> getAllDoctors(){
        List<Doctor> doctors = doctorService.getAllDoctors();
        return doctors;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updatePassword(@PathVariable long id, @RequestBody Map<String, String> object){
        Doctor doctor = doctorService.updatePassword(id, object.get("newPassword"));
        return new ResponseEntity<Doctor>(doctor, HttpStatus.CREATED);
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
