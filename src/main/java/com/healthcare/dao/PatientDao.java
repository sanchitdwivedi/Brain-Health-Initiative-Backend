package com.healthcare.dao;

import com.healthcare.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatientDao extends CrudRepository<Patient,Integer> {
    @Query("SELECT p FROM Patient p WHERE p.abhaId=?1")
    public Patient findByAbhaId(String id);

    @Query("SELECT p FROM Patient p WHERE p.mobile_no=?1")
    public List<Patient> findByMobileNo(Long id);

    @Query("Select count(p.uuid) from Patient p where p.district=?1")
    public int getPatientCountByDistrict(String district);

}
