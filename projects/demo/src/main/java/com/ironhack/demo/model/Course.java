package com.ironhack.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    String courseCode;

    @Column(name = "course_name")
    String courseName;

    @OneToMany(mappedBy = "course")
    List<Section> sections;

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    Integer hours;

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
