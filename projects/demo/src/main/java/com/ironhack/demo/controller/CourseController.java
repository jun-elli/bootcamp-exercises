package com.ironhack.demo.controller;

import com.ironhack.demo.model.Course;
import com.ironhack.demo.repository.CourseRepository;
import com.ironhack.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.listCourses();
    }

    @GetMapping("/courses/{name}")
    public Course getCourseByName(@PathVariable(value="name") String name) {
        return courseService.getCourseByName(name);
    }

    @GetMapping("/courses/containing")
    //http://localhost:8080/courses/containing?text=Databases
    public List<Course> getCourseContaining(@RequestParam(value="text") String text) {
        return courseRepository.findByCourseNameContaining(text);
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }


}
