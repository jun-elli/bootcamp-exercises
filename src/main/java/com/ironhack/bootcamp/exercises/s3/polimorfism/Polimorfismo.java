package com.ironhack.bootcamp.exercises.s3.polimorfism;

public class Polimorfismo {


    public static void main(String[] args) {
        Vehicle generic = new Vehicle();
        Vehicle car = new Car();
        Vehicle bike = new MotorBike();

        generic.startEngine();
        car.startEngine();
        bike.startEngine();
    }
}
