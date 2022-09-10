package com.ironhack.demo.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class GradeMaxOutput {

    @Max(100)
    @Min(0)
    private Integer score;
    @NotNull
    @NotEmpty
    private String sectionId;

    public GradeMaxOutput(Integer score, String sectionId) {
        this.score = score;
        this.sectionId = sectionId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }
}
