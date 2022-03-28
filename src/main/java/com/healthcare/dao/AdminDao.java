package com.healthcare.dao;
import com.healthcare.entity.Admin;
import com.healthcare.entity.Doctor;
import com.healthcare.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface AdminDao extends CrudRepository<Admin,Integer> {
    @Query("SELECT a FROM Admin a WHERE a.admin.userId=?1")
    public Admin findAdminByUserId(String id);

    @Query("DELETE FROM Admin a WHERE a.admin.userId=?1")
    public Admin deleteAdminByUserId(Long id);
}
