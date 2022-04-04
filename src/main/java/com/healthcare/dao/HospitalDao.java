package com.healthcare.dao;

import com.healthcare.entity.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalDao extends CrudRepository<Hospital, Integer> {

}
