package com.healthcare.dao;

import com.healthcare.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientDao extends CrudRepository<Patient,Integer> {
    @Query("SELECT p FROM Patient p WHERE p.abhaId=?1")
    public Patient findByAbhaId(String id);

    @Query("SELECT p FROM Patient p WHERE p.mobile_no=?1")
    public List<Patient> findByMobileNo(Long id);

    @Query("SELECT p FROM Patient p WHERE ((CONCAT(p.first_name, ' ', p.last_name)=?1) and p.mobile_no=?2)")
    public Patient findByMobileAndName(String name, Long mobile);

}
