package com.ironhack.demo.model;

public class ScienceSection extends Section {
    private final int scienceCredit;
    private Integer labRoomNum;

    public ScienceSection(int scienceCredit) {
        super(30);
        this.scienceCredit = scienceCredit;
    }

    // other constructors, getters, and setters omitted for brevity
}
