package com.healthcare.entity;

import java.util.List;
import java.util.Map;

public class QuestionDetail {
    private String text = "Default";
    private List<Integer> optionId;
//    Map<List<Answer>, Redirected Question/Conclusion>
    private Map<Integer, List<List<Integer>>> redirect;
    private int isMSQ = 0;
    private int isQuestion = 0;
    private int takeCount = 0;

    public QuestionDetail() {}

    public QuestionDetail(String text) {
        this.text = text;
    }

//    public QuestionDetail(String text, List<Integer> optionId, Map<List<Integer>, Integer> redirect, int isMSQ, int isQuestion, int takeCount) {
//        this.text = text;
//        this.optionId = optionId;
//        this.redirect = redirect;
//        this.isMSQ = isMSQ;
//        this.isQuestion = isQuestion;
//        this.takeCount = takeCount;
//    }


    public QuestionDetail(String text, List<Integer> optionId, Map<Integer, List<List<Integer>>> redirect, int isMSQ, int isQuestion, int takeCount) {
        this.text = text;
        this.optionId = optionId;
        this.redirect = redirect;
        this.isMSQ = isMSQ;
        this.isQuestion = isQuestion;
        this.takeCount = takeCount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) { this.text = text; }

    public List<Integer> getOptionId() {
        return optionId;
    }

    public void setOptionId(List<Integer> optionId) {
        this.optionId = optionId;
    }

//    public Map<List<Integer>, Integer> getRedirect() {
//        return redirect;
//    }
//
//    public void setRedirect(Map<List<Integer>, Integer> redirect) {
//        this.redirect = redirect;
//    }

    public Map<Integer, List<List<Integer>>> getRedirect() {
        return redirect;
    }

    public void setRedirect(Map<Integer, List<List<Integer>>> redirect) {
        this.redirect = redirect;
    }

    public int getIsMSQ() {
        return isMSQ;
    }

    public void setIsMSQ(int isMSQ) {
        this.isMSQ = isMSQ;
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

    @Override
    public String toString() {
        return "QuestionDetail{" +
                "text='" + text + '\'' +
                ", optionId=" + optionId +
                ", redirect=" + redirect +
                ", isMSQ=" + isMSQ +
                ", isQuestion=" + isQuestion +
                ", takeCount=" + takeCount +
                '}';
    }
}
