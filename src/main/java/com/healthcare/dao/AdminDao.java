package com.healthcare.dao;
import com.healthcare.entity.Admin;
import com.healthcare.entity.Doctor;
import com.healthcare.entity.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


public interface AdminDao extends CrudRepository<Admin,Integer> {
    @Query("SELECT a FROM Admin a WHERE a.admin.userId=?1 and a.admin.active=1")
    public Admin findAdminByUserId(Long id);

}
