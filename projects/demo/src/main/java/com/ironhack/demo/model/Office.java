package com.ironhack.demo.model;

import javax.persistence.*;

@Entity
public class Office {
    public Office(Integer roomNumber, String building) {
        this.roomNumber = roomNumber;
        this.building = building;
    }

    public Office(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer roomNumber;

    private String building;

    @OneToOne(mappedBy = "office")
    private Faculty faculty;

    public Integer getId() {
        return id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}
