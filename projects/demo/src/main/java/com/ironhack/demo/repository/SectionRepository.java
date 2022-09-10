package com.ironhack.demo.repository;

import com.ironhack.demo.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, String> {
    @Query("SELECT s from Section s where s.course.courseName = :name")
    List<Section> findByCourseName(@Param("name") String name);
}
