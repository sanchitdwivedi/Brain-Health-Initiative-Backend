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

    @PostMapping("/createPatient")
    public Patient createPatient(@RequestBody Patient patient){
        Patient p = patientService.createPatient(patient);
        if(p==null) throw new APIRequestException("The provided Patient Info is not a valid one!");
        return p;
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatient(){
        List<Patient> patients = patientService.getAllPatients();
        return patients;
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Integer id){
        return patientService.getPatientByPatientId(id);
    }



}
