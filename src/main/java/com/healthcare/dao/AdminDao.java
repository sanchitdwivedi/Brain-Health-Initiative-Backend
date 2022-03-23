package com.healthcare.dao;
import com.healthcare.entity.Admin;
import com.healthcare.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface AdminDao extends CrudRepository<Admin,Integer> {
    @Query("SELECT a FROM Admin a WHERE a.uuid=?1")
    public Admin findByUserId(String id);
}
