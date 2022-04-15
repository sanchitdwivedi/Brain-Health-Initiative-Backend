package com.healthcare.service;

import com.healthcare.dao.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramManagerService {
    @Autowired
    private PatientDao patientDao;

    public int getPatientCountByDistrict(String district){
        return patientDao.getPatientCountByDistrict(district);
    }

}
