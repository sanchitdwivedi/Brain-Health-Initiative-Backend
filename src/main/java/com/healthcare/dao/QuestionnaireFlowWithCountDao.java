package com.healthcare.dao;

import com.healthcare.entity.QuestionnaireFlow;
import com.healthcare.entity.QuestionnaireFlowWithCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireFlowWithCountDao extends QuestionnaireFlowDao{
    @Query("select q from QuestionnaireFlowWithCount q where q.questionNumber.uuid=?1")
    public List<QuestionnaireFlowWithCount> getNextQuestion(int QuestionNumber);

}
