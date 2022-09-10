package com.ironhack.demo.controller;

import com.ironhack.demo.dtos.GradeMaxOutput;
import com.ironhack.demo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;

    @GetMapping("/grades/max")
    public List<GradeMaxOutput> getMaxScoreBySection() {

        return gradeRepository.findMaxScoreBySection();

    }
}
