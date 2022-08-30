package com.ironhack.demo.repository;

import com.ironhack.demo.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    @Query("Select o.roomNumber from Office o join FETCH Faculty f on f.office.id = o.id where f.lastName=:lastName ")
    Object findOfficeNumbersByFacultyLastName(@Param("lastName") String lastName);

    Faculty findByLastName(String lastName);

}
