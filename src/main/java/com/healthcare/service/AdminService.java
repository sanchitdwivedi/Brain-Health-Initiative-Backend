package com.healthcare.service;
import com.healthcare.dao.AdminDao;
import com.healthcare.dao.RoleDao;
import com.healthcare.dao.UserDao;
import com.healthcare.entity.Admin;
import com.healthcare.entity.Doctor;
import com.healthcare.entity.Role;
import com.healthcare.entity.User;
import com.healthcare.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin createAdmin(Admin admin){
        Role role = roleDao.findByRoleName(admin.getAdmin().getRole().getRoleName());
        User user = new User();
        user.setUserId(admin.getAdmin().getUserId());
        user.setPassword(getEncodedPassword(admin.getAdmin().getPassword()));
        user.setRole(role);
        try {
            userDao.save(user);
            admin.setAdmin(user);
            return adminDao.save(admin);
        } catch (Exception e){
            throw new APIRequestException("A user is already registered with ID: " + admin.getAdmin().getUserId());
        }
    }
    public List<Admin> getAllAdmins(){
        List<Admin> admins = (List<Admin>) adminDao.findAll();
        return admins;
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public Admin getAdminById(Long id) {
        return adminDao.findAdminByUserId(id);
    }

    public void deleteAdmin(int id) {
        Optional<Admin> ad=adminDao.findById(id);
        if(!ad.isPresent()) throw new APIRequestException("Invalid User");
        User user = userDao.findByUserId(ad.get().getAdmin().getUserId());
        userDao.deleteById(user.getUuid());
    }

    public Admin updateAdmin(Admin admin) {
        return adminDao.save(admin);
    }
    public Admin updatePassword(long id, HashMap<String, String> object){
        if(!object.containsKey("newPassword")) throw new APIRequestException("Invalid request body");
        String password = object.get("newPassword");
        if(password==null || password.length()<8) throw new APIRequestException("Password must be atleast 8 characters long");
        Admin admin = adminDao.findAdminByUserId(id);
        if(admin==null || admin.getAdmin().getStatus()==1) throw new APIRequestException("Cannot change password of doctor with id: " + id);
        admin.getAdmin().setPassword(getEncodedPassword(password));
        admin.getAdmin().setStatus(1);
        return adminDao.save(admin);
    }
}
