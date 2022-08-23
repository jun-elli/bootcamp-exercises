package com.ironhack.demo.repository;

import com.ironhack.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByFirstNameAndLastName(String firstName, String lastName);
    List<Student> findByFirstNameLike(String firstName); // "M%"
    List<Student> findByFirstNameContaining(String firstName); // "Mich"

}
