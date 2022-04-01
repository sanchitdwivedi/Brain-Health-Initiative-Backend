package com.healthcare.controller;

import com.healthcare.entity.*;
import com.healthcare.service.QuestionnaireService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add/question")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionDetail questionDetail){
        System.out.println("OK");
        System.out.println(questionDetail);
        questionnaireService.addQuestion(questionDetail);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/add/option")
    public QuestionnaireOptions addOption(@RequestBody QuestionnaireOptions questionnaireOptions){
        return questionnaireService.addOption(questionnaireOptions);
    }

//    @GetMapping("options")
//    public
}
