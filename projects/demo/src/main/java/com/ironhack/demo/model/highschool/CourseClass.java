package com.ironhack.demo.model.highschool;

import javax.persistence.*;

@Entity
@Table(name = "course_class")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CourseClass {

    @Id
    @GeneratedValue
    Integer id;

    Integer level;

}
