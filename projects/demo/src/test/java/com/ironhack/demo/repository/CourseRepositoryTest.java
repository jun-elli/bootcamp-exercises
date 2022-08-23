package com.ironhack.demo.repository;

import com.ironhack.demo.model.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @AfterEach
    public void tearDown() {
        courseRepository.deleteAll();
    }

    @Test
    public void test_listCourses() {
        Course course = new Course();
        course.setCourseCode("CS105");
        course.setCourseName("Data Structures and Algorithms");

        courseRepository.save(course);

        Optional<Course> courseFromDb = courseRepository.findById("CS105");
        assertTrue(courseFromDb.isPresent());
        assertEquals(course.getCourseCode(), courseFromDb.get().getCourseCode());
        assertEquals(course.getCourseName(), courseFromDb.get().getCourseName());

    }

}
