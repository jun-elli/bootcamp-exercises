package com.ironhack.demo.service;

import com.ironhack.demo.model.Course;
import com.ironhack.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> listCourses() throws ResponseStatusException {
        try {
            return courseRepository.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "En estos momentos no tenemos lo que estas buscando");
        }
    }

    @Override
    public Course getCourseByName(String name) {
        return courseRepository.findByCourseName(name);
    }
}
