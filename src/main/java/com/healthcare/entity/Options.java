package com.healthcare.entity;

import javax.persistence.*;

public class Options {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="uuid")
    private Integer uuid;

    @Column(nullable = false)
    private String optionText;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Options() {}

    public Options(Integer uuid, String optionText) {
        this.uuid = uuid;
        this.optionText = optionText;
    }

    @Override
    public String toString() {
        return "Options{" +
                "uuid=" + uuid +
                ", optionText='" + optionText + '\'' +
                '}';
    }
}
