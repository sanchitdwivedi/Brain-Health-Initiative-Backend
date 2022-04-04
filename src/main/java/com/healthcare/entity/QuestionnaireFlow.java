package com.healthcare.entity;

import com.healthcare.util.QuestionnaireRedirectConverter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@MappedSuperclass
public abstract class QuestionnaireFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;

    @ManyToOne
    private QuestionnaireData questionNumber;

//    @OneToMany
    @Convert(converter = QuestionnaireRedirectConverter.class)
    private List<Integer> questionnaireOptions;

    @ManyToOne
    private QuestionnaireData nextQuestion;

    public QuestionnaireFlow() {}

    public QuestionnaireFlow(int uuid, QuestionnaireData questionNumber, List<Integer> questionnaireOptions, QuestionnaireData nextQuestion) {
        this.uuid = uuid;
        this.questionNumber = questionNumber;
        this.questionnaireOptions = questionnaireOptions;
        this.nextQuestion = nextQuestion;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public QuestionnaireData getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(QuestionnaireData questionNumber) {
        this.questionNumber = questionNumber;
    }

    public List<Integer> getQuestionnaireOptions() {
        return questionnaireOptions;
    }

    public void setQuestionnaireOptions(List<Integer> questionnaireOptions) {
        this.questionnaireOptions = questionnaireOptions;
    }

    public QuestionnaireData getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(QuestionnaireData nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    @Override
    public String toString() {
        return "QuestionnaireFlow{" +
                "uuid=" + uuid +
                ", questionNumber=" + questionNumber +
                ", questionnaireOptions=" + questionnaireOptions +
                ", nextQuestion=" + nextQuestion +
                '}';
    }
}
