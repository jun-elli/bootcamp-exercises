package com.ironhack.demo.repository;

import com.ironhack.demo.model.Grade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
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
    private Grade grade4;

    @BeforeEach
    void setUp() {
        gradeRepository.deleteAll();
        grade1 = new Grade();
        grade1.setScore(101);
        grade1.setSectionId(SECTION_ID);
        grade1.setStudentName("John Carpenter");
        gradeRepository.save(grade1);

        grade2 = new Grade();
        grade2.setScore(151);
        grade2.setSectionId(SECTION_ID);
        grade2.setStudentName("Danny DeVito");
        gradeRepository.save(grade2);

        grade3 = new Grade();
        grade3.setScore(201);
        grade3.setSectionId(SECTION_ID);
        grade3.setStudentName("Quentin Tarantino");
        gradeRepository.save(grade3);

        grade4 = new Grade();
        grade4.setScore(201);
        grade4.setSectionId("CS101-A");
        grade4.setStudentName("Quentin Tarantino");
        gradeRepository.save(grade4);
    }

    @AfterEach
    void tearDown() {
        gradeRepository.deleteAll();
    }

    @Test
    void findAllByScoreGreaterThan() {
        List<Grade> response = gradeRepository.findAllByScoreGreaterThan(50);
        assertEquals(4, response.size());
    }

    @Test
    void findAllByScoreGreaterThanOrderByStudentName() {
        List<Grade> response = gradeRepository.findAllByScoreGreaterThanOrderByStudentName(50);
        assertEquals(4, response.size());
        assertEquals("Danny DeVito", response.get(0).getStudentName());
        assertEquals("John Carpenter", response.get(1).getStudentName());
        assertEquals("Quentin Tarantino", response.get(2).getStudentName());
    }

    @Test
    void findAllBySectionIdNot() {
        List<Grade> response = gradeRepository.findAllBySectionIdNot(SECTION_ID);

        assertEquals(1, response.size());
        assertEquals("CS101-A", response.get(0).getSectionId());
    }

    @Test
    void findAll() {
        Iterable<Grade> grades = gradeRepository.findAll();
        int count = 0;

        for (Grade grade : grades) {
            count++;
        }

        assertEquals(4, count);
    }

    @Test
    void update() {
        Grade grade = gradeRepository.findBySectionIdAndStudentName(SECTION_ID, "John Carpenter");
        grade.setScore(95);
        gradeRepository.save(grade);


        Grade savedGrade = gradeRepository.findById(grade.getId()).get();
        assertEquals(95, savedGrade.getScore());

    }

    @Test
    void delete() {
        gradeRepository.delete(grade1);
        assertFalse(gradeRepository.findById(grade1.getId()).isPresent());
    }

    @Test
    void findAverageScoreBySection() {
        List<Object[]> result = gradeRepository.findAverageScoreBySection();

        assertEquals(151.0d, result.get(0)[0]);
        assertEquals(SECTION_ID, result.get(0)[1]);

        assertEquals(201.0d, result.get(1)[0]);
        assertEquals("CS101-A", result.get(1)[1]);
    }

    @Test
    void findMaxScoreBySection() {
        List<Object[]> result = gradeRepository.findMaxScoreBySection();

        assertEquals(201, result.get(0)[0]);
        assertEquals("CS101-A", result.get(0)[1]);

        assertEquals(201, result.get(1)[0]);
        assertEquals(SECTION_ID, result.get(1)[1]);
    }
}