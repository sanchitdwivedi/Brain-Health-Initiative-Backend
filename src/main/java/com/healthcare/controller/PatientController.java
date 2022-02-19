package com.healthcare.controller;


import com.healthcare.entity.Patient;
import com.healthcare.exception.APIRequestException;
import com.healthcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("")
    public Patient createPatient(@RequestBody Patient patient) {
        Patient p = patientService.createPatient(patient);
        if (p == null) throw new APIRequestException("The provided Patient Info is not a valid one!");
        return p;
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

    @GetMapping("/getPatient/{mob_no}")
    public Patient getPatientByMobileNo(@PathVariable String mob_no) {
        return patientService.getPatientByMobileNo(mob_no);
    }

}
