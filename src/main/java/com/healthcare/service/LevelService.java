package com.healthcare.service;

import com.healthcare.dao.LevelDao;
import com.healthcare.entity.Admin;
import com.healthcare.entity.Level;
import com.healthcare.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelService {
    @Autowired
    private LevelDao levelDao;

    public Level createLevel(Level level){
        try {
            return levelDao.save(level);
        } catch (Exception e){
            throw new APIRequestException("A level is already present with name: " + level.getLevelName());
        }
    }

    public List<Level> getAllLevels(){
        List<Level> levels = (List<Level>) levelDao.findAll();
        return levels;
    }

    public Level getLevelByName(String levelName){
        return levelDao.findByLevelName(levelName);
    }


    public void deleteLevel(int id) {
        levelDao.deleteById(id);
    }

    public Level updateLevel(Level level) {
        return levelDao.save(level);
    }
}
