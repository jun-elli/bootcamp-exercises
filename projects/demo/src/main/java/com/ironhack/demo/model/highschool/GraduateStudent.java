package com.ironhack.demo.model.highschool;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorColumn(name="student_type")
@DiscriminatorValue("g")
public class GraduateStudent extends Student{
}
