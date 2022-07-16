package com.ironhack.bootcamp.exercises.s3.polimorfism;

public class Vehicle {
    // make them private
    Boolean engineStart;
    String color;
    Integer numberTiers;

    public void startEngine() {
        System.out.println("Vehicle is starting its engine");
    }

    public void inflateTier() {
        System.out.println("Inflating tier from vehicle");
    }
}
