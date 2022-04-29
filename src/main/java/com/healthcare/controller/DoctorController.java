package com.healthcare.controller;

import com.healthcare.entity.Admin;
import com.healthcare.entity.ConsultationForm;
import com.healthcare.entity.Doctor;
import com.healthcare.service.ConsultationFormService;
import com.healthcare.service.DoctorService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@SecurityRequirement(name = "Brain Health Initiative API")
@Tag(name = "Doctor")
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ConsultationFormService consultationFormService;

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
    public ResponseEntity<Doctor> updatePassword(@PathVariable long id, @Schema(description = "Password must be atleast 8 characters long",
                            example = "{\"newPassword\":\"string\"}") @RequestBody HashMap<String, String> object){
        Doctor doctor = doctorService.updatePassword(id, object);
        return new ResponseEntity<Doctor>(doctor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable long id){
        return doctorService.getDoctorByHealthId(id);
    }
    @DeleteMapping("/{id}")
    private void deleteDoctor(@PathVariable("id") int id)
    {
        doctorService.deleteDoctor(id);
    }

    @PutMapping("/update/{id}")
    private Doctor update(@RequestBody Doctor doctor,@PathVariable int id)
    {
        doctor.setUuid(id);
        return doctorService.updateDoctor(doctor);

    }
    @GetMapping("/{id}/referrals")
    public List<ConsultationForm> getReferrals(@PathVariable long id){
        return consultationFormService.getConsultationFormByRefer(id);
    }

    @GetMapping("/{id}/patients")
    public List<ConsultationForm> getPatients(@PathVariable long id){
        return consultationFormService.getConsultationFormByDoctor(id);
    }

    @GetMapping("/role/{id}")
    public List<Doctor> getDoctorsByRoleId(@PathVariable Integer id){
        return doctorService.getDoctorsByRoleId(id);
    }
//    @GetMapping("/specialist")
//    @PreAuthorize("hasRole('specialist')")
//    public String forSpecialist(){
//        return "Welcome Specialist";
//    }
//
//    @GetMapping("/medical-officer")
//    @PreAuthorize("hasRole('medical officer')")
//    public String forMedicalOfficer(){
//        return "Welcome Medical officer";
//    }
}
