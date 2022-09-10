package com.ironhack.demo.controller;

import com.ironhack.demo.model.Spell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class SpellController {

//    @Autowired
//    SpellService spellService;
//
//    @Autowired
//    StudentService studentService;
//
//
//    @GetMapping("/spells/byStudent/{studentId}")
//    public List<Spell> getSpellsByStudent(@PathVariable Integer studentId) {
//        List<Spell> allSpells = studentService.getStudent(studentId).getSpells();
//        List<Spell> spellsByName = new ArrayList<>();
//
//        for (Spell spell : allSpells) {
//            if (spell.getName().equals('name')) {
//                spellsByName.add(spell);
//            }
//        }
//        return  spellsByName;
//
//    }
}
