package com.healthcare.dao;

import com.healthcare.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, Integer>{
    @Query("SELECT r FROM Role r WHERE r.roleName=?1")
    public Role findByRoleName(String roleName);
}
