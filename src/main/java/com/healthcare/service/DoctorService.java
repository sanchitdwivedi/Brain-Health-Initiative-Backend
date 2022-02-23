package com.healthcare.service;

import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.HospitalDao;
import com.healthcare.dao.RoleDao;
import com.healthcare.entity.Doctor;
import com.healthcare.entity.Hospital;
import com.healthcare.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


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
        Hospital hospital = hospitalDao.findById(doctor.getHospital().getHospitalId()).get();
        if(role==null || hospital==null) return null;
        doctor.setRole(role);
        doctor.setHospital(hospital);
        doctor.setPassword(getEncodedPassword(doctor.getPassword()));
        return doctorDao.save(doctor);
    }

    public List<Doctor> getAllDoctors(){
        List<Doctor> doctors = (List<Doctor>) doctorDao.findAll();
        return doctors;
    }

    public Doctor getDoctorByHealthId(long id){
        return doctorDao.findByHealthId(id);
    }

    public Doctor updatePassword(long id, String password){
        Doctor doctor = doctorDao.findByHealthId(id);
        if(doctor==null || doctor.getStatus()==1) return null;
        doctor.setPassword(getEncodedPassword(password));
        doctor.setStatus(1);
        return doctorDao.save(doctor);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
