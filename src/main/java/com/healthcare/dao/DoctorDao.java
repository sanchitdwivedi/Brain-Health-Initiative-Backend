package com.healthcare.dao;

import com.healthcare.entity.Admin;
import com.healthcare.entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorDao extends CrudRepository<Doctor, Integer> {
    @Query("SELECT d FROM Doctor d WHERE d.doctor.userId=?1 and d.doctor.active=1")
    public Doctor findByHealthId(Long id);

    @Query("SELECT d FROM Doctor d WHERE d.doctor.role.roleId=?1 and d.doctor.active=1")
    public List<Doctor> findByRoleId(Integer id);
}
