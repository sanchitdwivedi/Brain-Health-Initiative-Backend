package com.healthcare.entity;

import javax.persistence.*;

@Entity
public class QuestionnaireOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;

    @Column(nullable = false, unique = true)
    private String optionText;

    public QuestionnaireOptions() {}

    public QuestionnaireOptions(int uuid, String optionText) {
        this.uuid = uuid;
        this.optionText = optionText;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }
}
