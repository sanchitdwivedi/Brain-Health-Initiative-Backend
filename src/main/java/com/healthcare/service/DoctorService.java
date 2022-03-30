package com.healthcare.service;

import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.HospitalDao;
import com.healthcare.dao.RoleDao;
import com.healthcare.dao.UserDao;
import com.healthcare.entity.*;
import com.healthcare.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class DoctorService {
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private HospitalDao hospitalDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Doctor createDoctor(Doctor doctor){
        Role role = roleDao.findByRoleName(doctor.getDoctor().getRole().getRoleName());
        Optional<Hospital> hospital = hospitalDao.findById(doctor.getHospital().getHospitalId());
        if(role==null) throw new APIRequestException("Invalid role");
        if(!hospital.isPresent()) throw new APIRequestException("Invalid hospital");
        doctor.setHospital(hospital.get());
        User user = new User();
        user.setUserId(doctor.getDoctor().getUserId());
        user.setPassword(getEncodedPassword(doctor.getDoctor().getPassword()));
        user.setRole(role);
        try {
            userDao.save(user);
            doctor.setDoctor(user);
            return doctorDao.save(doctor);
        } catch (Exception e){
            throw new APIRequestException("A user is already registered with ID: " + doctor.getDoctor().getUserId());
        }
    }

    public List<Doctor> getAllDoctors(){
        List<Doctor> doctors = (List<Doctor>) doctorDao.findAll();
        return doctors;
    }

    public Doctor getDoctorByHealthId(long id){
        return doctorDao.findByHealthId(id);
    }

    public Doctor updatePassword(long id, HashMap<String, String> object){
        if(!object.containsKey("newPassword")) throw new APIRequestException("Invalid request body");
        String password = object.get("newPassword");
        if(password==null || password.length()<8) throw new APIRequestException("Password must be atleast 8 characters long");
        Doctor doctor = doctorDao.findByHealthId(id);
        if(doctor==null || doctor.getDoctor().getStatus()==1) throw new APIRequestException("Cannot change password of doctor with id: " + id);
        doctor.getDoctor().setPassword(getEncodedPassword(password));
        doctor.getDoctor().setStatus(1);
        return doctorDao.save(doctor);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public void deleteDoctor(long id) {
        Doctor d=doctorDao.findByHealthId(id);
        doctorDao.deleteById(d.getUuid());
    }

    public Doctor updateDoctor(Doctor doctor) {
        return doctorDao.save(doctor);
    }
}
