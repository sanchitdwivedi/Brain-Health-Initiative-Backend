package com.healthcare.dao;
import com.healthcare.entity.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface AdminDao extends CrudRepository<Admin,Integer> {
    @Query("SELECT a FROM Admin a WHERE a.admin.userId=?1")
    public Admin findAdminByUserId(Long id);

}
