package com.healthcare.entity;

import javax.persistence.*;

@Entity
public class QuestionnaireData {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="uuid")
    private Integer uuid;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private int isQuestion;

    @Column(nullable = false)
    private int takeCount;

    @Column(nullable = false)
    private int isMSQ;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getIsQuestion() {
        return isQuestion;
    }

    public void setIsQuestion(int isQuestion) {
        this.isQuestion = isQuestion;
    }

    public int getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(int takeCount) {
        this.takeCount = takeCount;
    }

    public int getIsMSQ() {
        return isMSQ;
    }

    public void setIsMSQ(int isMSQ) {
        this.isMSQ = isMSQ;
    }

    public QuestionnaireData() {}

    public QuestionnaireData(Integer uuid, String question, int isQuestion, int takeCount, int isMSQ) {
        this.uuid = uuid;
        this.question = question;
        this.isQuestion = isQuestion;
        this.takeCount = takeCount;
        this.isMSQ = isMSQ;
    }

    @Override
    public String toString() {
        return "QuestionnaireData{" +
                "uuid=" + uuid +
                ", question='" + question + '\'' +
                ", isQuestion=" + isQuestion +
                ", takeCount=" + takeCount +
                ", isMSQ=" + isMSQ +
                '}';
    }
}
