package com.healthcare.service;

import com.healthcare.dao.ConsultationFormDao;
import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.HospitalDao;
import com.healthcare.dao.PatientDao;
import com.healthcare.entity.ConsultationForm;
import com.healthcare.entity.Doctor;
import com.healthcare.entity.Hospital;
import com.healthcare.entity.Patient;
import com.healthcare.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Doctor doctor = doctorDao.findByHealthId(consultationForm.getDoctor().getDoctor().getUserId());
        if(doctor==null) throw new APIRequestException("Invalid doctor id");
        Optional<Hospital> hospital = hospitalDao.findById(consultationForm.getHospital().getHospitalId());
        if(!hospital.isPresent()) throw new APIRequestException("Invalid hospital");
        Patient patient = patientDao.findByAbhaId(consultationForm.getPatient().getAbhaId());
        if(patient==null) throw new APIRequestException("Invalid patient");
        Doctor refer = null;
        if(consultationForm.getRefer()!=null) refer = doctorDao.findByHealthId((consultationForm.getRefer().getDoctor().getUserId()));
        consultationForm.setDoctor(doctor);
        consultationForm.setRefer(refer);
        consultationForm.setHospital(hospital.get());
        consultationForm.setPatient(patient);
        return consultationFormDao.save(consultationForm);
    }

    public List<ConsultationForm> getAllConsultationForm(){
        List<ConsultationForm>  consultationForm = (List<ConsultationForm>) consultationFormDao.findAll();
        return consultationForm;
    }

    public List<ConsultationForm> getConsultationFormByAbhaId(String id){

        return consultationFormDao.findByAbhaId(id);
    }

    public List<ConsultationForm> getConsultationFormByRefer(Long id){
        return consultationFormDao.findByRefer(id);
    }

    public List<ConsultationForm> getConsultationFormByDoctor(Long id){
        return consultationFormDao.findByDoctor(id);
    }

    public List<ConsultationForm> getFormsWithQuestionnaire(){
        return consultationFormDao.formsWithQuestionnaire();
    }

}
