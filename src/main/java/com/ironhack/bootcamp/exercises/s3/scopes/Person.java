package com.ironhack.bootcamp.exercises.s3.scopes;
/*
    default modifier
    protected
    private
 */
public class Person {
    String name;
    String lastName;
    Address address;

    public Person (String name, String lastName, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    // Why to use getter and setters
    public void changeAddress(String newStreet, String city, String postalCode, Integer number)  {
        this.address.street = newStreet;
        this.address.city = city;
        this.address.postalCode = postalCode;
        this.address.number = number;
    }
}

class Address {
    String street;
    String city;
    String postalCode;
    Integer number;
}
