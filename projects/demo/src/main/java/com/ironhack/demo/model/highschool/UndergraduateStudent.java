package com.ironhack.demo.model.highschool;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name="student_type")
@DiscriminatorValue("u")
public class UndergraduateStudent extends Student{

    public void addGrade(Grade grade) {

    }
}
