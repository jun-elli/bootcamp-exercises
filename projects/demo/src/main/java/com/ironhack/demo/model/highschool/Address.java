package com.ironhack.demo.model.highschool;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    String city;
    String postalCode;
    String street;
}
