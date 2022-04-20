package com.healthcare.entity;

import com.healthcare.util.QuestionnaireRedirectConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Map;

@Entity
public class QuestionnaireFlowWithoutCount extends QuestionnaireFlow{


    @Column(nullable = false)
//    @OneToMany
    @Convert(converter = QuestionnaireRedirectConverter.class)
    private List<Integer> questionnaireAnswers;

    @Column(nullable = false)
    private int takeAnyCombination;

    public QuestionnaireFlowWithoutCount() {}

    public QuestionnaireFlowWithoutCount(int uuid, QuestionnaireData questionNumber, List<Integer> questionnaireOptions, QuestionnaireData nextQuestion, List<Integer> questionnaireAnswers, int takeAnyCombination) {
        super(uuid, questionNumber, questionnaireOptions, nextQuestion);
        this.questionnaireAnswers = questionnaireAnswers;
        this.takeAnyCombination = takeAnyCombination;
    }

    public List<Integer> getQuestionnaireAnswers() {
        return questionnaireAnswers;
    }

    public void setQuestionnaireAnswers(List<Integer> questionnaireAnswers) {
        this.questionnaireAnswers = questionnaireAnswers;
    }

    public int isTakeAnyCombination() {
        return takeAnyCombination;
    }

    public void setTakeAnyCombination(int takeAnyCombination) {
        this.takeAnyCombination = takeAnyCombination;
    }

    @Override
    public String toString() {
        return "QuestionnaireFlowWithoutCount{" +
                "questionnaireAnswers=" + questionnaireAnswers +
                ", takeAnyCombination=" + takeAnyCombination +
                '}';
    }
}
