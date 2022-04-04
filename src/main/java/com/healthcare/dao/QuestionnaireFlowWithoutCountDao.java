package com.healthcare.dao;

import com.healthcare.entity.QuestionnaireFlow;
import com.healthcare.entity.QuestionnaireFlowWithoutCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionnaireFlowWithoutCountDao extends QuestionnaireFlowDao {

    @Query("select q from QuestionnaireFlowWithoutCount q where q.questionNumber.uuid=?1")
    public List<QuestionnaireFlowWithoutCount> getNextQuestion(Integer questionNumber);

}
