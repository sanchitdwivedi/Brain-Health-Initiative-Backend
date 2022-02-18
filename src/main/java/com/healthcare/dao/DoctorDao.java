package com.healthcare.dao;

import com.healthcare.entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends CrudRepository<Doctor, Integer> {
    @Query("SELECT d FROM Doctor d WHERE d.healthId=?1")
    public Doctor findByHealthId(Long id);
}
