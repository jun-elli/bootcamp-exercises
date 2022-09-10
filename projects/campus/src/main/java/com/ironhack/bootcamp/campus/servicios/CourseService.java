package com.ironhack.bootcamp.campus.servicios;

import com.ironhack.bootcamp.campus.models.Course;
import com.ironhack.bootcamp.campus.models.CourseUpdateHoursDto;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course get(String id);

    Course save(Course course);

    Course update(String id, Course course);

    Course updateCourseHours(String id, CourseUpdateHoursDto hours);

    void delete (Course course);

    List<Course> list();
}
