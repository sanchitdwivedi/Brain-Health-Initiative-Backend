package com.healthcare.service;

import com.healthcare.dao.ConsultationFormDao;
import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.HospitalDao;
import com.healthcare.dao.PatientDao;
import com.healthcare.entity.ConsultationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationFormService {

    @Autowired
    private ConsultationFormDao consultationFormDao;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private HospitalDao hospitalDao;


    public ConsultationForm createConsultationForm(ConsultationForm consultationForm){
        return consultationFormDao.save(consultationForm);
    }

    public List<ConsultationForm> getAllConsultationForm(){
        List<ConsultationForm>  consultationForm = (List<ConsultationForm>) consultationFormDao.findAll();
        return consultationForm;
    }

    public List<ConsultationForm> getConsultationFormByAbhaId(String id){

        return consultationFormDao.findByAbhaId(id);
    }



}
