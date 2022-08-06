package com.ironhack.bootcamp.s11enumshashmaps;

import java.math.BigDecimal;
import java.util.*;

public class S11Main {
    public static void main(String[] args) {
        runUserExample();
        runAccountExample();


        List<User>  users = new ArrayList<>();
        users.add(new User("toni", "mas", "iron-toni", "mystrongpassword", UserStatus.DISABLED));
        users.add(new User("inma", "mas1", "iron-toni", "mystrongpassword", UserStatus.DISABLED));
        users.add(new User("luis", "mas2", "iron-toni", "mystrongpassword", UserStatus.DISABLED));
        users.add(new User("Joan", "mas3", "iron-toni", "mystrongpassword", UserStatus.DISABLED));

        users.get(0);
        users.get(users.size()-1);

        users.remove(0);


        Map<Integer, User> usersMap = new HashMap<>();
        usersMap.put(0, new User("toni", "mas", "iron-toni", "mystrongpassword", UserStatus.DISABLED));
        usersMap.put(1, new User("inma", "mas", "iron-toni", "mystrongpassword", UserStatus.DISABLED));
        usersMap.put(2, new User("luis", "mas", "iron-toni", "mystrongpassword", UserStatus.DISABLED));
        usersMap.put(3, new User("joan", "mas", "iron-toni", "mystrongpassword", UserStatus.DISABLED));

        usersMap.get("toni");
        usersMap.remove("toni");

        for (Integer key : usersMap.keySet()) {
            User user = usersMap.get(key);
            System.out.println("User: " + user.getFirstName() +  " last: " + user.getLastName());
        }

        for (User user: usersMap.values()) {
            System.out.println("User: " + user.getFirstName() +  " last: " + user.getLastName());
        }


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
