package com.healthcare.controller;

import com.healthcare.entity.Admin;
import com.healthcare.entity.Hospital;
import com.healthcare.service.HospitalService;
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
@Tag(name = "Hospital")
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @PostMapping("")
    public ResponseEntity<Hospital> createHospital(@Valid @RequestBody Hospital hospital){
        Hospital h = hospitalService.createHospital(hospital);
        return new ResponseEntity<Hospital>(h, HttpStatus.CREATED);
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

    @DeleteMapping("/{id}")
    private void deleteHospital(@PathVariable("id") Integer id)
    {
        hospitalService.deleteHospital(id);
       // System.out.println("Deleted");
    }

    @PutMapping("/{id}")
    private Hospital update(@RequestBody Hospital hospital,@PathVariable int id)
    {
        hospital.setHospitalId(id);
        return hospitalService.updateAdmin(hospital);

    }

}
