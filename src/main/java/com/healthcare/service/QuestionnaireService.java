package com.healthcare.service;

import com.healthcare.dao.*;
import com.healthcare.entity.*;
import com.healthcare.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireFlowWithCountDao questionnaireFlowWithCountDao;

    @Autowired
    private QuestionnaireFlowWithoutCountDao questionnaireFlowWithoutCountDao;

    @Autowired
    private QuestionnaireDataDao questionnaireDataDao;

    @Autowired
    private QuestionnaireOptionsDao questionnaireOptionsDao;

    public QuestionnaireData getFirstQuestion(){
        return questionnaireDataDao.findById(2).get();
    }

    public QuestionnaireData getNextQuestion(QuestionResponse questionResponse){
        Optional<QuestionnaireData> questionnaireData = questionnaireDataDao.findById(questionResponse.getQuestionId());
        if(!questionnaireData.isPresent()){
            throw new APIRequestException("No Question with id: "+questionResponse.getQuestionId()+" found!");
        }
        if(questionnaireData.get().getTakeCount()==1){
            int count = questionResponse.getOptions().size();
            List<QuestionnaireFlowWithCount> list = questionnaireFlowWithCountDao.getNextQuestion(questionnaireData.get().getUuid());
            for (QuestionnaireFlowWithCount qf : list) {
                if(qf.getQuestionnaireAnswers()==count){
                    return qf.getNextQuestion();
                }
            }
            for(QuestionnaireFlowWithCount qf: list){
                if(qf.getQuestionnaireAnswers()==-1) return qf.getNextQuestion();
            }
            return questionnaireDataDao.findById(1).get();
        }else {
            List<QuestionnaireFlowWithoutCount> list = questionnaireFlowWithoutCountDao.getNextQuestion(questionnaireData.get().getUuid());
            if (list.size() != 0) {
                for (QuestionnaireFlowWithoutCount qf : list) {
                    if(qf.isTakeAnyCombination()==1){
                        for (Integer answer : qf.getQuestionnaireAnswers()) {
                            for (Integer response : questionResponse.getOptions()) {
                                if (response == answer) {
                                    return qf.getNextQuestion();
                                }
                            }
                        }
                    }else{
                        boolean isMatched = true;
                        if (qf.getQuestionnaireAnswers().size() != questionResponse.getOptions().size())
                            continue;
                        for (Integer answer : qf.getQuestionnaireAnswers()) {
                            boolean isFound = false;
                            for (Integer response : questionResponse.getOptions()) {
                                if (response == answer) {
                                    isFound = true;
                                    break;
                                }
                            }
                            if (!isFound) {
                                isMatched = false;
                                break;
                            }
                        }
                        if (isMatched) {
                            //Redirect Question Found
                            return qf.getNextQuestion();
                        }
                    }
                }
            }
        }
        return questionnaireDataDao.findById(1).get();
    }


    public void addQuestion(QuestionDetail questionDetail){
        QuestionnaireData questionnaireData = new QuestionnaireData();
        questionnaireData.setQuestion(questionDetail.getText());
        if(questionDetail.getIsQuestion()==0){
            questionnaireDataDao.save(questionnaireData);
            return;
        }
        questionnaireData.setIsQuestion(questionDetail.getIsQuestion());
        questionnaireData.setIsMSQ(questionDetail.getIsMSQ());
        questionnaireData.setTakeCount(questionDetail.getTakeCount());
        questionnaireData = questionnaireDataDao.save(questionnaireData);

        if(questionDetail.getTakeCount()==1){
            for(Map.Entry<Integer, List<List<Integer>>> entry: questionDetail.getRedirect().entrySet()){
                for(List<Integer> count: entry.getValue()){
                    QuestionnaireFlowWithCount questionnaireFlowWithCount = new QuestionnaireFlowWithCount();
                    questionnaireFlowWithCount.setQuestionNumber(questionnaireData);
                    questionnaireFlowWithCount.setQuestionnaireOptions(questionDetail.getOptionId());
                    questionnaireFlowWithCount.setQuestionnaireAnswers(count.get(0));
                    questionnaireFlowWithCount.setNextQuestion(questionnaireDataDao.findById(entry.getKey()).get());
                    questionnaireFlowWithCountDao.save(questionnaireFlowWithCount);
                }
            }
        }else {
            for (Map.Entry<Integer, List<List<Integer>>> entry : questionDetail.getRedirect().entrySet()) {
                for(List<Integer> answerList: entry.getValue()){
                    QuestionnaireFlowWithoutCount questionnaireFlowWithoutCount = new QuestionnaireFlowWithoutCount();
                    questionnaireFlowWithoutCount.setQuestionNumber(questionnaireData);
                    questionnaireFlowWithoutCount.setQuestionnaireOptions(questionDetail.getOptionId());
                    questionnaireFlowWithoutCount.setQuestionnaireAnswers(answerList);
                    questionnaireFlowWithoutCount.setNextQuestion(questionnaireDataDao.findById(entry.getKey()).get());
                    questionnaireFlowWithCountDao.save(questionnaireFlowWithoutCount);
                }
            }
        }
    }

//    private List<QuestionnaireOptions> getOptionObject(List<Integer> options){
//        List<QuestionnaireOptions> optionObjects = new ArrayList<>();
//        for(int option: options){
//            optionObjects.add(questionnaireOptionsDao.findById(option).get());
//        }
//        return optionObjects;
//    }

    public QuestionnaireOptions addOption(QuestionnaireOptions questionnaireOptions){
        return questionnaireOptionsDao.save(questionnaireOptions);
    }

    public QuestionnaireOptions getOption(Integer id){
        Optional<QuestionnaireOptions> questionnaireOptions = this.questionnaireOptionsDao.findById(id);
        if(!questionnaireOptions.isPresent()) throw new APIRequestException("Invalid option");
        return questionnaireOptions.get();
    }

    public List<QuestionnaireOptions> getOptionsList(List<Integer> optionIds){
        List<QuestionnaireOptions> options = new ArrayList<>();
        for(Integer id: optionIds){
            options.add(getOption(id));
        }
        return options;
    }

    public QuestionnaireData getQuestionById(Integer id){
        return questionnaireDataDao.findById(id).get();
    }

    public List<QuestionnaireData> getQuestionDataList(List<Integer> questionIds){
        List<QuestionnaireData> questions = new ArrayList<>();
        for(Integer id: questionIds){
            questions.add(getQuestionById(id));
        }
        return questions;
    }
}
