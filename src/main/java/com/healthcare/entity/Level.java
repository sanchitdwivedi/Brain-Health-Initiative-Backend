package com.healthcare.entity;

import javax.persistence.*;

@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private Integer levelId;
    @Column(name = "level_name", nullable = false, unique = true)
    private String levelName;
    @Column(name = "level_description")
    private String levelDescription;

    public Level() {
    }

    public Level(Integer levelId, String levelName, String levelDescription) {
        this.levelId = levelId;
        this.levelName = levelName;
        this.levelDescription = levelDescription;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription = levelDescription;
    }

    @Override
    public String toString() {
        return "Level{" +
                "levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                ", levelDescription='" + levelDescription + '\'' +
                '}';
    }
}
