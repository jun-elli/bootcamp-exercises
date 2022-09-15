package com.ironhack.bootcamp.campus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "course")
public class Course {

    public Course(String courseCode, String courseName, Integer hours) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.hours = hours;
    }

    public Course() {}

    @Id
    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "course_name")
    @Size(max = 25)
    private String courseName;

    @NotNull
    @Max(15)
    private Integer hours;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
