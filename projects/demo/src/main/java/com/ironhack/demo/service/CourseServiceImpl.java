package com.ironhack.demo.service;

import com.ironhack.demo.model.Course;
import com.ironhack.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> listCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseByName(String name) {
        return courseRepository.findByCourseName(name);
    }
}
