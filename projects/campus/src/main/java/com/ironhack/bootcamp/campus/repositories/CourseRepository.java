package com.ironhack.bootcamp.campus.repositories;

import com.ironhack.bootcamp.campus.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course, String> {
}
