package com.healthcare.service;

import com.healthcare.dao.QuestionnaireDao;
import com.healthcare.entity.QuestionResponse;
import com.healthcare.entity.QuestionnaireData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireDao questionnaireDao;

    public QuestionnaireData getNextQuestion(QuestionResponse questionResponse){
        
        return new QuestionnaireData();
    }

}
