package com.ironhack.demo.repository;

import com.ironhack.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{

    Course findByCourseName(String courseName);
}
