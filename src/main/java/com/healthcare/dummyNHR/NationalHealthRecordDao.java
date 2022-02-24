package com.healthcare.dummyNHR;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NationalHealthRecordDao extends CrudRepository<NationalHealthRecord, Integer> {

    @Query("From NationalHealthRecord n where n.abhaId=?1")
    public NationalHealthRecord findByAbhaId(String abhaId);

}
