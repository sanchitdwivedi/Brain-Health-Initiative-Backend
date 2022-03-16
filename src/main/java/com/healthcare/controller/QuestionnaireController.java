package com.healthcare.controller;

import com.healthcare.entity.Doctor;
import com.healthcare.entity.QuestionResponse;
import com.healthcare.entity.QuestionnaireData;
import com.healthcare.service.QuestionnaireService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@SecurityRequirement(name = "Brain Health Initiative API")
@Tag(name = "Questionnaire")
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @PostMapping("")
    public ResponseEntity<QuestionnaireData> getNextQuestion(@RequestBody QuestionResponse questionResponse){
        QuestionnaireData q = questionnaireService.getNextQuestion(questionResponse);
        return new ResponseEntity<QuestionnaireData>(q, HttpStatus.OK);
    }

}
