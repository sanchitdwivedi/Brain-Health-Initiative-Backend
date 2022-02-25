package com.healthcare.service;

import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.HospitalDao;
import com.healthcare.dao.RoleDao;
import com.healthcare.entity.Doctor;
import com.healthcare.entity.Hospital;
import com.healthcare.entity.Role;
import com.healthcare.enumeration.Gender;
import com.healthcare.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;


@Service
public class DoctorService {
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private HospitalDao hospitalDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Doctor createDoctor(Doctor doctor){
        Role role = roleDao.findByRoleName(doctor.getRole().getRoleName());
        Optional<Hospital> hospital = hospitalDao.findById(doctor.getHospital().getHospitalId());
        if(role==null) throw new APIRequestException("Invalid role");
        if(!hospital.isPresent()) throw new APIRequestException("Invalid hospital");
        doctor.setRole(role);
        doctor.setHospital(hospital.get());
        doctor.setPassword(getEncodedPassword(doctor.getPassword()));
        try {
            return doctorDao.save(doctor);
        } catch (Exception e){
            throw new APIRequestException("A doctor is already registered with Health ID: " + doctor.getHealthId());
        }
    }

    public List<Doctor> getAllDoctors(){
        List<Doctor> doctors = (List<Doctor>) doctorDao.findAll();
        return doctors;
    }

    public Doctor getDoctorByHealthId(long id){
        return doctorDao.findByHealthId(id);
    }

    public Doctor updatePassword(long id, String password){
        if(password==null || password.length()<8) throw new APIRequestException("Password must be atleast 8 characters long");
        Doctor doctor = doctorDao.findByHealthId(id);
        if(doctor==null || doctor.getStatus()==1) throw new APIRequestException("Cannot change password of doctor with id: " + id);
        doctor.setPassword(getEncodedPassword(password));
        doctor.setStatus(1);
        return doctorDao.save(doctor);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
