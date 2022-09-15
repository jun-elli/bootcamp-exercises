package com.ironhack.bootcamp.campus.controllers;

import com.ironhack.bootcamp.campus.models.Course;
import com.ironhack.bootcamp.campus.models.CourseUpdateHoursDto;
import com.ironhack.bootcamp.campus.servicios.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping("/courses")
    public List<Course> list() {
        return courseService.list();
    }

    @GetMapping("/courses/{id}")
    public Course get(@PathVariable String id)  {
        return courseService.get(id);
    }

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@Valid @RequestBody Course course) {
        return courseService.save(course);
    }

    @PutMapping("/courses/{id}")
    public Course update(@PathVariable String id, @RequestBody Course course) {
        return courseService.update(id, course);
    }

    @PatchMapping("/courses/{id}/update/hours")
    public Course updateCourseHours(@PathVariable String id, @RequestBody CourseUpdateHoursDto hours) {
        return courseService.updateCourseHours(id, hours);
    }

    @DeleteMapping("/courses/{id}")
    public void delete(@PathVariable String id) {
        Course course = courseService.get(id);
        courseService.delete(course);
    }

}
