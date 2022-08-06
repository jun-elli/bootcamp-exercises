package com.ironhack.bootcamp.exercises.s3.polimorfism;

public class Car extends Vehicle {
    Integer numberDoors;
    Double trunkCapacity;
    String wheel;


    public Car () {
        this.numberDoors = 5;
        this.trunkCapacity = 100.5;
        this.wheel = "Wheel is pointing front";
    }

    public Car (int numberDoors) {
        this.numberDoors = 5;
        this.trunkCapacity = 100.5;
        this.wheel = "Wheel is pointing front";
    }

    public Car (int numberDoors, Double trunkCapacity, String wheel) {
        this.numberDoors = numberDoors;
        this.trunkCapacity = trunkCapacity;
        this.wheel = wheel;
    }

    public void startEngine() {
        System.out.println("starting car engine boom boom!");
    }

    public void turnLeft() {
        System.out.println("turning left");
    }

    public void turnRight() {
        System.out.println("turning right");
    }

    public void changeFlatTire() {
        System.out.println("replacing flat tire");
        System.out.println("take out replacing tools");
        System.out.println("lift up flat tier side");
        System.out.println("remove wheel nuts");
        System.out.println("put on new wheel");
        System.out.println("put on wheel nuts");
        this.numberTiers--;


    }
}
