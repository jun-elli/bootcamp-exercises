package com.ironhack.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Faculty {

    public Faculty(String firstName, String lastName, String department, Boolean tenure, Office office) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.tenure = tenure;
        this.office = office;
    }

    public Faculty () {}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String department;

    private Boolean tenure;

    @OneToOne
    @JoinColumn(name = "office_id")
    Office office;


    @OneToMany(mappedBy = "faculty")
    List<Section> sections;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Boolean getTenure() {
        return tenure;
    }

    public void setTenure(Boolean tenure) {
        this.tenure = tenure;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
