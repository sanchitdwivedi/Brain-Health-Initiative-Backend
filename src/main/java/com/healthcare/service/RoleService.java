package com.healthcare.service;

import com.healthcare.dao.RoleDao;
import com.healthcare.entity.Admin;
import com.healthcare.entity.Role;
import com.healthcare.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role createRole(Role role){
        try{
            return roleDao.save(role);
        } catch (Exception e){
            throw new APIRequestException("A role is already present with name: " + role.getRoleName());
        }
    }

    public List<Role> getAllRoles(){
        List<Role> roles = (List<Role>) roleDao.findAll();
        return roles;
    }

    public Role getRoleByName(String roleName){
        return roleDao.findByRoleName(roleName);
    }

    public void deleteRole(int id) {
        //Role role=roleDao.findByRoleName(id);
        roleDao.deleteById(id);
    }

    public Role updateRole(Role role)
    { return roleDao.save(role);}

    public List<Role> getDoctorRoles(){
        List<Role> r = (List<Role>) roleDao.findAll();
        List<Role> doctorRoles = new ArrayList<>();
        for(Role role: r){
            if(role.getRoleName()!="program manager" && role.getRoleName()!="admin") doctorRoles.add(role);
        }
        return doctorRoles;
    }
}
