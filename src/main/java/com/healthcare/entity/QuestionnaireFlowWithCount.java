package com.healthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class QuestionnaireFlowWithCount extends QuestionnaireFlow {

    @Column(nullable = false)
    private Integer questionnaireAnswers;

    public Integer getQuestionnaireAnswers() {
        return questionnaireAnswers;
    }

    public void setQuestionnaireAnswers(Integer questionnaireAnswers) {
        this.questionnaireAnswers = questionnaireAnswers;
    }

    public QuestionnaireFlowWithCount() {}

    public QuestionnaireFlowWithCount(int uuid, QuestionnaireData questionNumber, List<Integer> questionnaireOptions, QuestionnaireData nextQuestion, Integer questionnaireAnswers) {
        super(uuid, questionNumber, questionnaireOptions, nextQuestion);
        this.questionnaireAnswers = questionnaireAnswers;
    }

    @Override
    public String toString() {
        return "QuestionnaireFlowWithCount{" +
                "questionnaireAnswers=" + questionnaireAnswers +
                '}';
    }
}
