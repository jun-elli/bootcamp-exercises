package com.ironhack.demo.controller;

import com.ironhack.demo.model.Course;
import com.ironhack.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/myCourses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
