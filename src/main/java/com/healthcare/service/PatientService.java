package com.healthcare.service;

import com.healthcare.dao.PatientDao;
import com.healthcare.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientDao patientDao;

    public Patient createPatient(Patient patient){
        Patient p=patientDao.findByAbhaId(patient.getAbhaId());
        if(p!=null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient already exists!");
       else
            return patientDao.save(patient);
    }

    public List<Patient> getAllPatients(){
        List<Patient> patients = (List<Patient>) patientDao.findAll();
        return patients;
    }

    public Patient getPatientByAbhaId(String id){
        return patientDao.findByAbhaId(id);
    }
    public Patient getPatientByMobileNo(Long mobNo){ return patientDao.findByMobileNo(mobNo);}

}
