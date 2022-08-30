package com.ironhack.demo.repository;

import com.ironhack.demo.model.Faculty;
import com.ironhack.demo.model.Office;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FacultyRepositoryTest {

    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private OfficeRepository officeRepository;

    private Office office;
    private Office office1;
    private Faculty faculty;
    private Faculty faculty1;

    @BeforeEach
    void setUp() {
        facultyRepository.deleteAll();
        office = new Office(1, "North building");
        officeRepository.save(office);
        faculty = new Faculty("firstName", "lastName", "department", true, office);
        facultyRepository.save(faculty);

        office1 = new Office(2, "East building");
        officeRepository.save(office1);
        faculty1 = new Faculty("otherName", "otherLast", "otherDepartment", true, office1);
        facultyRepository.save(faculty1);
    }

    @Test
    void findOfficeNumbersByFacultyLastName() {
        Object o = facultyRepository.findOfficeNumbersByFacultyLastName("otherLast");

        assertEquals(2, o);
    }

    @Test
    void findByLastName() {
        Faculty faculty = facultyRepository.findByLastName("otherLast");

        assertEquals(2, faculty.getOffice().getRoomNumber());
    }

    @Test
    void testSetup() {
        List<Faculty> faculties = facultyRepository.findAll();

        assertEquals(2, faculties.size());
    }
}