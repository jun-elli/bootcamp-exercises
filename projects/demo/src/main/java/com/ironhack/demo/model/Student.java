package com.ironhack.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;

    @Embedded
    Address currentAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress", column = @Column(name = "perm_street")),
            @AttributeOverride(name = "city", column = @Column(name = "perm_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "perm_postal"))
    })
    @Embedded
    private Address permanentAddress;

    // constructors, getters, and setters omitted for brevity
}


/*
 CREATE TABLE student(
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    street_address VARCHAR(255),
    city VARCHAR (255),
    postal_code VARCHAR(10),
    perm_street VARCHAR(255),
    perm_city VARCHAR(255),
    perm_postal VARCHAR(10),
    PRIMARY KEY (id)
 );
 */