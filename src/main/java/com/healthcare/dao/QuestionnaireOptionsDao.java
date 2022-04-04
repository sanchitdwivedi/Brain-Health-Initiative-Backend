package com.healthcare.dao;

import com.healthcare.entity.QuestionnaireOptions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireOptionsDao extends CrudRepository<QuestionnaireOptions, Integer> {
}
