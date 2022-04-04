package com.healthcare.entity;

import java.util.List;

public class QuestionResponse {

    private Integer questionId;
    private List<Integer> options;

    public QuestionResponse(){}

    public QuestionResponse(Integer questionId, List<Integer> options) {
        this.questionId = questionId;
        this.options = options;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public List<Integer> getOptions() {
        return options;
    }

    public void setOptions(List<Integer> options) {
        this.options = options;
    }
}
