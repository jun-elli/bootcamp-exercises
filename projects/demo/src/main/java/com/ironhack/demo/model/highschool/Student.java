package com.ironhack.demo.model.highschool;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;
    private String gpa;
    private Integer studentId;

    @Embedded
    private Address currentAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "perm_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "perm_postal")),
            @AttributeOverride(name = "street", column = @Column(name = "perm_street"))
    })
    private Address permanentAddress;

    private List<Grade> grades;
}
