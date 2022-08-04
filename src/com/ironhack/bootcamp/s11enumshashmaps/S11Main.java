package com.ironhack.bootcamp.s11enumshashmaps;

import java.math.BigDecimal;
import java.util.UUID;

public class S11Main {
    public static void main(String[] args) {
        runUserExample();

        runAccountExample();
    }

    private static void runAccountExample() {
        Account holdedAccount = new Account("blocked account", "tax free paradise", new BigDecimal(10000000l), UUID.randomUUID().toString(), Hold.FRAUD);
        if (holdedAccount.getHold().isOnHold()) {
            System.err.println("This account is on hold because there was a illegal action attempt");
        }

        Account activeAccount = new Account("active account", "paid tax non paradise", new BigDecimal(100l), UUID.randomUUID().toString(), Hold.NONE);
        if (activeAccount.getHold().isOnHold()) {
            System.err.println("This account is on hold because there was a illegal action attempt");
        }

        if (!Hold.getIllegitHoldingStates().contains(activeAccount.getHold())) {
            // generate a payment transaction on this account
            System.out.println();
        }

    }


    public static void runUserExample() {
        User toni = new User("toni", "mas", "iron-toni", "mystrongpassword", UserStatus.DISABLED);

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
