package com.healthcare.dao;

import com.healthcare.entity.QuestionnaireData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireDataDao extends CrudRepository<QuestionnaireData, Integer> {

}
