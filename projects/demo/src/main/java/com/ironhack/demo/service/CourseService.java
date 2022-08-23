package com.ironhack.demo.service;

import com.ironhack.demo.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> listCourses();
    Course getCourseByName(String name);
}
