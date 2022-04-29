package com.healthcare.service;

import com.healthcare.dao.PatientDao;
import com.healthcare.entity.Patient;
import com.healthcare.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientDao patientDao;

    public Patient createPatient(Patient patient){
       try {
           return patientDao.save(patient);
       } catch (Exception e) {
           throw new APIRequestException("A patient is already registered with id: " + patient.getAbhaId());
       }
    }

    public List<Patient> getAllPatients(){
        List<Patient> patients = (List<Patient>) patientDao.findAll();
        return patients;
    }

    public Patient getPatientByAbhaId(String id){
        return patientDao.findByAbhaId(id);
    }
    public List<Patient> getPatientsByMobileNo(String mobNo){
        try {
            return patientDao.findByMobileNo(Long.parseLong(mobNo));
        } catch (NumberFormatException e){
            throw new APIRequestException("Invalid mobile number");
        }
    }

    public Patient getPatientByMobileAndName(String name, Long mobile){
        return patientDao.findByMobileAndName(name, mobile);
    }

}
