package com.healthcare.entity;

import javax.persistence.*;

public class QuestionnaireData {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="uuid")
    private Integer uuid;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private boolean isQuestion;

    @Column(nullable = false)
    private boolean takeCount;

    @Column(nullable = false)
    private boolean isMSQ;

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

    public boolean isQuestion() {
        return isQuestion;
    }

    public void setQuestion(boolean question) {
        isQuestion = question;
    }

    public boolean isTakeCount() {
        return takeCount;
    }

    public void setTakeCount(boolean takeCount) {
        this.takeCount = takeCount;
    }

    public boolean isMSQ() {
        return isMSQ;
    }

    public void setMSQ(boolean MSQ) {
        isMSQ = MSQ;
    }

    public QuestionnaireData() {}

    public QuestionnaireData(Integer uuid, String question, boolean isQuestion, boolean takeCount, boolean isMSQ) {
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
