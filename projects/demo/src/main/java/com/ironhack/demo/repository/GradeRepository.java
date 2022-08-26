package com.ironhack.demo.repository;

import com.ironhack.demo.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends CrudRepository<Grade, Integer> {

    List<Grade> findAllByScoreGreaterThan(Integer score);

    List<Grade> findAllByScoreGreaterThanOrderByStudentName(Integer score);

    List<Grade> findAllBySectionIdNot(String sectionId);

}
