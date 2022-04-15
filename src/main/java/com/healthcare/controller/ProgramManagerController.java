package com.healthcare.controller;
import com.healthcare.service.ProgramManagerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@SecurityRequirement(name = "Brain Health Initiative API")
@Tag(name = "Program Manager")
@RequestMapping("/pm")
public class ProgramManagerController {
    @Autowired
    private ProgramManagerService pmservice;

    @GetMapping("/district/{districtName}")
    private int getPatientCountByDistrict(@PathVariable("districtName") String districtName)
    {
        return pmservice.getPatientCountByDistrict(districtName);
    }
}
