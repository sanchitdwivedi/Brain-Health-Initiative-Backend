package com.healthcare.service;

import com.healthcare.dao.LevelDao;
import com.healthcare.entity.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {
    @Autowired
    private LevelDao levelDao;

    public Level createLevel(Level level){
        return levelDao.save(level);
    }

    public List<Level> getAllLevels(){
        List<Level> levels = (List<Level>) levelDao.findAll();
        return levels;
    }

    public Level getLevelByName(String levelName){
        return levelDao.findByLevelName(levelName);
    }
}
