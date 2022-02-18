package com.healthcare.service;

import com.healthcare.dao.RoleDao;
import com.healthcare.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role createRole(Role role){
        return roleDao.save(role);
    }

    public List<Role> getAllRoles(){
        List<Role> roles = (List<Role>) roleDao.findAll();
        return roles;
    }

    public Role getRoleByName(String roleName){
        return roleDao.findByRoleName(roleName);
    }
}
