package com.ironhack.demo.model.highschool;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorColumn(name = "class_type")
@DiscriminatorValue("h")
public class HighLevelCourseClass extends CourseClass {
}
