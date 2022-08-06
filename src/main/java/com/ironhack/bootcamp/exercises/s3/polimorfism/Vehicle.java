package com.ironhack.bootcamp.exercises.s3.polimorfism;

public class Vehicle {
    // make them private
    Boolean engineStart;
    String color;
    Integer numberTiers;
    private String license;

    public Vehicle() {
        this.license = "valid";
    }

    public void startEngine() {
        if (license.equals("valid")) {
            this.engineStart = true;
        } else {
            this.engineStart = false;
        }
        System.out.println("Vehicle is starting its engine");
    }

    public void inflateTier() {
        System.out.println("Inflating tier from vehicle");
    }
}
