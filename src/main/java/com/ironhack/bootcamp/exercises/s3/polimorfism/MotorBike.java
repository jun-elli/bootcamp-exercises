package com.ironhack.bootcamp.exercises.s3.polimorfism;

public class MotorBike extends Vehicle{

    @Override
    public void startEngine() {
        System.out.println("starting bike engine boom boom!");
    }

    public void changeFlatTire() {
        System.out.println("Put your bike aside");
        System.out.println("Call the insurance service");
        System.out.println("wait for them");
        System.out.println("go home depress");
        System.out.println("Pick your bike the next 3-4 working days");
    }

}
