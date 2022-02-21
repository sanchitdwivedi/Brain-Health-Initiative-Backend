package com.healthcare.controller;

import com.healthcare.entity.ConsultationForm;
import com.healthcare.entity.Patient;
import com.healthcare.exception.APIRequestException;
import com.healthcare.service.ConsultationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationFormController {

    @Autowired
    private ConsultationFormService consultationformservice;

    @PostMapping("")
    public ConsultationForm createConsultationForm(@RequestBody ConsultationForm consultationForm){
        ConsultationForm c = consultationformservice.createConsultationForm(consultationForm);
        if(c==null) throw new APIRequestException("Invalid");
        return c;
    }

    @GetMapping("")
    public List<ConsultationForm> getAllConsultationForm() {
        List<ConsultationForm> consultationForm = consultationformservice.getAllConsultationForm();
        return consultationForm;
    }

    @GetMapping("/{id}")
    public List<ConsultationForm> getConsultationFormByAbhaId(@PathVariable String id) {

        return consultationformservice.getConsultationFormByAbhaId(id);
    }




}
