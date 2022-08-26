package com.ironhack.demo.repository;

import com.ironhack.demo.model.Grade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GradeRepositoryTest {

    @Autowired
    private GradeRepository gradeRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAllByScoreGreaterThan() {
        List<Grade> response = gradeRepository.findAllByScoreGreaterThan(50);

        assertEquals(3, response.size());
    }

    @Test
    void findAllByScoreGreaterThanOrderByStudentName() {
    }

    @Test
    void findAllBySectionIdNot() {
    }

    @Test
    void findAll() {
        Iterable<Grade> response = gradeRepository.findAll();
        int i = 0;
        for (Grade item: response) {
           i++;
        }
        assertEquals(8, i);
    }

    @Test
    void update() {
        Grade grade = gradeRepository.findById(1).get();
        grade.setScore(95);
        gradeRepository.save(grade);


        Grade savedGrade = gradeRepository.findById(1).get();
        assertEquals(95, savedGrade.getScore());

    }

    @Test
    void delete() {
        Grade grade = gradeRepository.findById(1).get();
        gradeRepository.delete(grade);

        assertFalse(gradeRepository.findById(1).isPresent());

    }
}