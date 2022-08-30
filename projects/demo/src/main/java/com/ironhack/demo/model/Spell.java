package com.ironhack.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Spell {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Level level;

    @ManyToMany(mappedBy = "spells")
    private List<Student> students;
}
