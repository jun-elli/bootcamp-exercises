package com.ironhack.demo.model;

import javax.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name = "id")
public class MathSection extends Section{
    private int mathCredit;

    public MathSection(int mathCredit) {
        super(30);
        this.mathCredit = mathCredit;
    }
}
