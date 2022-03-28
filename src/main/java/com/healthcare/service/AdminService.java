package com.healthcare.service;
import com.healthcare.dao.AdminDao;
import com.healthcare.dao.RoleDao;
import com.healthcare.dao.UserDao;
import com.healthcare.entity.Admin;
import com.healthcare.entity.Role;
import com.healthcare.entity.User;
import com.healthcare.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Admin getAdminById(String id) {
        return adminDao.findAdminByUserId(id);
    }

    public void deleteAdmin(long id) {
        adminDao.deleteAdminByUserId(id);
    }

    public Admin updateAdmin(Admin admin) {
        return adminDao.save(admin);
    }
}
