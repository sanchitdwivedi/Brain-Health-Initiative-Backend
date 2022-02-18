package com.healthcare.dao;

import com.healthcare.entity.Level;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface LevelDao extends CrudRepository<Level, Integer> {
    @Query("SELECT l FROM Level l WHERE l.levelName=?1")
    public Level findByLevelName(String levelName);
}
