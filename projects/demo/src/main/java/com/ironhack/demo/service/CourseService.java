package com.ironhack.demo.service;

import com.ironhack.demo.model.Course;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface CourseService {

    List<Course> listCourses() throws ResponseStatusException;
    Course getCourseByName(String name);
}
