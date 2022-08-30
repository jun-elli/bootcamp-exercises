package com.ironhack.demo.model;

import javax.persistence.*;

@Entity
public class HouseAssignment {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    private House house;

    @Enumerated(EnumType.STRING)
    private Wing wing;

    private Integer assignedBed;

    @OneToOne(mappedBy = "houseAssignment")
    private Student student;

}