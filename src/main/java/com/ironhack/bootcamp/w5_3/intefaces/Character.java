package com.ironhack.bootcamp.w5_3.intefaces;

public abstract class Character implements Attacker {
    public static final int DEFAULT_RECOVERY = 1;
    public static final int DEFAULT_WASTE = 1;

    private String name;

    public Character() {
        this.name = "generic";
    }

    public Character(String name) {
        this.name = name;
    }

    public abstract boolean isAlive();
    public abstract void hit(Long points);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
