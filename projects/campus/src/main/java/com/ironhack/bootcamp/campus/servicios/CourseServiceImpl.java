package com.ironhack.bootcamp.campus.servicios;

import com.ironhack.bootcamp.campus.models.Course;
import com.ironhack.bootcamp.campus.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Course get(String id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(String courseCode, Course requestCourse) {
        Course storedCourse = get(courseCode);

        return courseRepository.save(requestCourse);
    }

    @Override
    public void delete(Course course) {
        courseRepository.delete(course);

    }

    @Override
    public List<Course> list() {
        return courseRepository.findAll();
    }
}
