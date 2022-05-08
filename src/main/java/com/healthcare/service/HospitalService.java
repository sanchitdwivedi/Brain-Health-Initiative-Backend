package com.healthcare.service;

import com.healthcare.dao.HospitalDao;
import com.healthcare.dao.LevelDao;
import com.healthcare.entity.Admin;
import com.healthcare.entity.Hospital;
import com.healthcare.entity.Level;
import com.healthcare.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {
    @Autowired
    private HospitalDao hospitalDao;
    @Autowired
    private LevelDao levelDao;

    public Hospital createHospital(Hospital hospital){
        Level level = levelDao.findByLevelName(hospital.getLevel().getLevelName());
        if(level==null) throw new APIRequestException("Invalid level");
        hospital.setLevel(level);
        try {
            return hospitalDao.save(hospital);
        } catch (Exception e){
            throw new APIRequestException("An hospital is already present with name: " + hospital.getHospitalName());
        }
    }

    public List<Hospital> getAllHospitals(){
        List<Hospital> hospitals = (List<Hospital>) hospitalDao.findAll();
        List<Hospital> currHospitals = new ArrayList<>();
        for(Hospital hospital: hospitals){
            if(hospital.getActive()==1) currHospitals.add(hospital);
        }
        return currHospitals;
    }

    public Hospital getHospitalById(int id){
        Optional<Hospital> hospital = hospitalDao.findById(id);
        if(!hospital.isPresent() || hospital.get().getActive()==0) throw new APIRequestException("Invalid hospital");
        return hospital.get();
    }

    public void deleteHospital(Integer id) {
//        hospitalDao.deleteById(id);
        Optional<Hospital> hospital = hospitalDao.findById(id);
        if(!hospital.isPresent()) throw new APIRequestException("Invalid hospital");
        hospital.get().setActive(0);
        hospitalDao.save(hospital.get());
    }

    public Hospital updateAdmin(Hospital hospital) {
        return hospitalDao.save(hospital);
    }
}
