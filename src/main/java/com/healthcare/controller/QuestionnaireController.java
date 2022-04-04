package com.healthcare.controller;

import com.healthcare.entity.*;
import com.healthcare.exception.APIRequestException;
import com.healthcare.service.QuestionnaireService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SecurityRequirement(name = "Brain Health Initiative API")
@Tag(name = "Questionnaire")
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/first")
    public ResponseEntity<QuestionnaireData> getFirstQuestion(){
        QuestionnaireData questionnaireData = questionnaireService.getFirstQuestion();
        return new ResponseEntity<>(questionnaireData, HttpStatus.OK);
    }

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

    @GetMapping("/option/{id}")
    public QuestionnaireOptions getOption(@PathVariable Integer id){
        return questionnaireService.getOption(id);
    }

    @PostMapping("/options")
    public List<QuestionnaireOptions> getOptionsList(@RequestBody Map<String, List<Integer>> optionIds){
        if(!optionIds.containsKey("ids")) throw new APIRequestException("Invalid request body");
        return questionnaireService.getOptionsList(optionIds.get("ids"));
    }
}
