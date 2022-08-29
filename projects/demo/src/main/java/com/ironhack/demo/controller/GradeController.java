package com.ironhack.demo.controller;

import com.ironhack.demo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping("/grades/max")
    public List<Object[]> getMaxScoreBySection() {

        return gradeRepository.findMaxScoreBySection();

    }
}
