package com.healthcare.dummyNHR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationalHealthRecordService {

    @Autowired
    private NationalHealthRecordDao nationalHealthRecordDao;

    public NationalHealthRecord createNationalHealthRecord(NationalHealthRecord nationalHealthRecord){
        return nationalHealthRecordDao.save(nationalHealthRecord);
    }

    public List<NationalHealthRecord> getAllNationalHealthRecord() {
        return (List<NationalHealthRecord>) nationalHealthRecordDao.findAll();
    }

    public NationalHealthRecord getNationalHealthRecordByAbhaId(String id) {
        return nationalHealthRecordDao.findByAbhaId(id);
    }
}
