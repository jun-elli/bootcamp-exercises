package com.ironhack.demo.model;


import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetAddress;
    private String city;
    private String postalCode;

    // constructors, getters, and setters omitted for brevity
}
