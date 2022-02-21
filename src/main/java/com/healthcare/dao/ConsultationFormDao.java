package com.healthcare.dao;

import com.healthcare.entity.ConsultationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ConsultationFormDao extends CrudRepository<ConsultationForm, Integer> {


    @Query("FROM ConsultationForm g where g.patientId.abhaId= ?1")
    public List<ConsultationForm> findByAbhaId(String id);
}
