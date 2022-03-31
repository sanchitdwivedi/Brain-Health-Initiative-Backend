package com.healthcare.dao;

import com.healthcare.entity.QuestionnaireFlow;
import org.springframework.data.repository.*;

@NoRepositoryBean
public interface QuestionnaireFlowDao extends CrudRepository<QuestionnaireFlow, Integer> {
}
