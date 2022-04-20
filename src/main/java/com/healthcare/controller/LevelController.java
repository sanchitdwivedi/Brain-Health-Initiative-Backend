package com.healthcare.controller;

import com.healthcare.entity.Admin;
import com.healthcare.entity.Level;
import com.healthcare.service.LevelService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "Brain Health Initiative API")
@Tag(name = "Level", description = "Endpoint to maintain different levels of hospitals present")
@RequestMapping("/level")
public class LevelController {
    @Autowired
    private LevelService levelService;

    @PostMapping("")
    public Level createLevel(@RequestBody Level level){
        return levelService.createLevel(level);
    }

    @GetMapping("")
    public List<Level> getAllLevels(){
        return levelService.getAllLevels();
    }

    @GetMapping("/{levelName}")
    public Level getLevel(@PathVariable String levelName){
        return levelService.getLevelByName(levelName);
    }

    @DeleteMapping("/{id}")
    private void deleteLevel(@PathVariable("id") int id)
    {
        levelService.deleteLevel(id);
        //System.out.println("Deleted");
    }

    @PutMapping("/{id}")
    private Level update(@RequestBody Level level,@PathVariable int id)
    {
        level.setLevelId(id);
        return levelService.updateLevel(level);

    }
}
