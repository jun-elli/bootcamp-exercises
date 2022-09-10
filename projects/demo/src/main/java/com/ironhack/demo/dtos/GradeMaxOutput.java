package com.ironhack.demo.dtos;

public class GradeMaxOutput {
    private Integer score;
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
