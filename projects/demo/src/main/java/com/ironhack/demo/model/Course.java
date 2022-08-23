package com.ironhack.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    @Id
    String courseCode;

    @Column(name = "course_name")
    String courseName;

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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Course)) {
            return false;
        }

        Course courseObj = (Course) obj;

        if (courseCode.equals(courseObj.getCourseCode()) && courseName.equals(courseObj.getCourseName())) {
            return true;
        }
        return false;
    }
}
