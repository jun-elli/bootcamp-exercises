package com.ironhack.demo.repository;

import com.ironhack.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{

    Course findByCourseName(String courseName);

    Course findByCourseNameAndCourseCode(String courseName, String courseCode);

    List<Course> findByCourseNameContaining(String text); // text = "Databases"
    // select * from course where course_name like '%Databases%';

    List<Course> findByCourseNameLike(String expr); // expr = "%Databases";
    // select * from Course where courseName like :expr


    @Query(value = "from Course where courseName between :start and :end"/*, nativeQuery = true*/)
    List<Course> findCourseByNameBetween(String start, String end);

    @Query(value="select hours, courseName from Course where courseCode = :courseCode")
    List<Object[]> findCourseByCourseCode(String courseCode );
    // [{"hours": 124, "courseCode": "CS101"}, {...}, ...]





}
