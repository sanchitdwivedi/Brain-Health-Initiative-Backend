package com.healthcare.dummyNHR;

import com.healthcare.exception.APIRequestException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Hidden
@RequestMapping("/NHR")
public class NationalHealthRecordController {

    @Autowired
    private NationalHealthRecordService nationalhealthrecordservice;

    @PostMapping("")
    public NationalHealthRecord createNationalHealthRecord(@RequestBody NationalHealthRecord nationalHealthRecord){
        NationalHealthRecord n = nationalhealthrecordservice.createNationalHealthRecord(nationalHealthRecord);
        if(n==null) throw new APIRequestException("Invalid");
        return n;
    }

    @GetMapping("")
    public List<NationalHealthRecord> getAllNationalHealthRecord(){
        List<NationalHealthRecord> nationalHealthRecords = nationalhealthrecordservice.getAllNationalHealthRecord();
        return nationalHealthRecords;
    }

    @GetMapping("/{id}")
    public NationalHealthRecord getNationalHealthRecordByAbhaId(@PathVariable String id){
        return nationalhealthrecordservice.getNationalHealthRecordByAbhaId(id);
    }
}
