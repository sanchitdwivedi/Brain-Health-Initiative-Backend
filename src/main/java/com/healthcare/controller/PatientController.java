package com.healthcare.controller;


import com.healthcare.entity.Patient;
import com.healthcare.service.PatientService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@SecurityRequirement(name = "Brain Health Initiative API")
@Tag(name = "Patient")
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("")
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
        Patient p = patientService.createPatient(patient);
        return new ResponseEntity<Patient>(p, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Patient> getAllPatient() {
        List<Patient> patients = patientService.getAllPatients();
        return patients;
    }

    @GetMapping("/{id}")
    public Patient getPatientByAbhaId(@PathVariable String id) {
        return patientService.getPatientByAbhaId(id);
    }

    @GetMapping("/mobile/{mob_no}")
    public List<Patient> getPatientsByMobileNo(@PathVariable String mob_no) {
        return patientService.getPatientsByMobileNo(mob_no);
    }

    @GetMapping("/name/{name}/mobile/{mobile}")
    public Patient getPatientByMobileAndName(@PathVariable String name, @PathVariable Long mobile){
        return patientService.getPatientByMobileAndName(name, mobile);
    }
}
