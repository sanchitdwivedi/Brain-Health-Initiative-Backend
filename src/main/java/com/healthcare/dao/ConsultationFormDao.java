package com.healthcare.dao;

import com.healthcare.entity.ConsultationForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ConsultationFormDao extends CrudRepository<ConsultationForm, Integer> {


    @Query("FROM ConsultationForm g where g.patient.abhaId= ?1")
    public List<ConsultationForm> findByAbhaId(String id);

    @Query("FROM ConsultationForm g where g.refer.doctor.userId=?1")
    public List<ConsultationForm> findByRefer(Long id);

    @Query("FROM ConsultationForm g where g.doctor.doctor.userId=?1")
    public List<ConsultationForm> findByDoctor(Long id);

    @Query("FROM ConsultationForm g where g.questionnaireResponse is not NULL")
    public List<ConsultationForm> formsWithQuestionnaire();
}
