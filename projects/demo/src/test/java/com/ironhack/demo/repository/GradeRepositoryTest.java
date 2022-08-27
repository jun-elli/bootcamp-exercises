package com.ironhack.demo.repository;

import com.ironhack.demo.model.Grade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GradeRepositoryTest {

    public static final String SECTION_ID = "CS901-A";
    @Autowired
    private GradeRepository gradeRepository;

    private Grade grade1;
    private Grade grade2;
    private Grade grade3;

    @BeforeEach
    void setUp() {
        gradeRepository.deleteAll();
        grade1 = new Grade();
        grade1.setStudentName("Juan Elías");
        grade1.setSectionId(SECTION_ID);
        grade1.setScore(102);
        gradeRepository.save(grade1);

        grade2 = new Grade();
        grade2.setStudentName("Juan Elías");
        grade2.setSectionId(SECTION_ID);
        grade2.setScore(102);
        gradeRepository.save(grade2);

        grade3 = new Grade();
        grade3.setStudentName("Juan Elías");
        grade3.setSectionId(SECTION_ID);
        grade3.setScore(102);
        gradeRepository.save(grade3);

    }

    @AfterEach
    public void tearDown() {
        gradeRepository.deleteAll();
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
        Long count = gradeRepository.count();
        assertEquals(3, count);
    }

    @Test
    void update() {
        grade1.setScore(95);
        gradeRepository.save(grade1);


        Grade savedGrade = gradeRepository.findById(grade1.getId()).get();
        assertEquals(95, savedGrade.getScore());

    }

    @Test
    void delete() {
        gradeRepository.delete(grade1);

        assertFalse(gradeRepository.findById(grade1.getId()).isPresent());

    }
}