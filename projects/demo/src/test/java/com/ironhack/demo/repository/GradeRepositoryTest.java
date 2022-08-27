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

    @BeforeEach
    void setUp() {
        gradeRepository.deleteAll();
        Grade newGrade = new Grade();
        newGrade.setScore(101);
        newGrade.setSectionId(SECTION_ID);
        newGrade.setStudentName("John Carpenter");
        gradeRepository.save(newGrade);

        Grade newGrade2 = new Grade();
        newGrade2.setScore(151);
        newGrade2.setSectionId(SECTION_ID);
        newGrade2.setStudentName("Danny DeVito");
        gradeRepository.save(newGrade2);

        Grade newGrade3 = new Grade();
        newGrade3.setScore(201);
        newGrade3.setSectionId(SECTION_ID);
        newGrade3.setStudentName("Quentin Tarantino");
        gradeRepository.save(newGrade3);
    }

    @AfterEach
    void tearDown() {
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
        Long i = gradeRepository.count();
        assertEquals(3l, i);
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
        Grade grade = gradeRepository.findById(1).get();
        gradeRepository.delete(grade);

        assertFalse(gradeRepository.findById(1).isPresent());

    }
}