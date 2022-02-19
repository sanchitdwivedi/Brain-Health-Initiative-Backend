package com.healthcare.dao;

import com.healthcare.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PatientDao extends CrudRepository<Patient,Integer> {
    @Query("SELECT p FROM Patient p WHERE p.patientId=?1")
    public Patient findByPatientId(Integer id);

}
