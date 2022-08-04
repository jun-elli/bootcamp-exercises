package com.ironhack.bootcamp.s10;

public class S10Main {
    public static void main(String[] args) {
        User toni = new User("toni", "mas", "iron-toni", "mystrongpassword", UserStatus.DISABLED);
//        for (UserStatus status : toni.getStatus()) {
//
//        }

        UserStatus toniStatus= toni.getStatus();

        if (!UserStatus.isActive(toniStatus)) {
            System.err.println("Este usuario no está activo en el sistema");
        }

        if (!toniStatus.isActive()) {
            System.err.println("Este usuario no está activo en el sistema");
        }


        System.out.println(toni.getStatus().name());

    }
}


enum TravelOptions {
    CAR,
    PLANE,
    SHIP;
}
