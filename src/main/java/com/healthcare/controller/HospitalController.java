package com.healthcare.controller;

import com.healthcare.entity.Hospital;
import com.healthcare.exception.APIRequestException;
import com.healthcare.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @PostMapping("")
    public Hospital createHospital(@RequestBody Hospital hospital){
        Hospital h = hospitalService.createHospital(hospital);
        if(h==null) throw new APIRequestException("The provided level is not a valid one!");
        return h;
    }

    @GetMapping("")
    public List<Hospital> getAllHospitals(){
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return hospitals;
    }

    @GetMapping("/{id}")
    public Hospital getHospital(@PathVariable int id){
        return hospitalService.getHospitalById(id);
    }
}
