package com.ironhack.bootcamp.w5_3.intefaces;

public class Main {
    public static void main(String[] args) {
        Character champion1 = new Warrior();
        Character champion2 = new Wizard();


        while (champion1.isAlive() && champion2.isAlive()) {
            fight(champion1, champion2);
        }

        Character winner = champion1.isAlive() ? champion1 : champion2;

        System.out.println("Congrats! " + winner.getName() + " You are the winner");
    }

    private static void fight(Character champion1, Character champion2) {
        int turn = new Double(Math.random() * 10).intValue();
        if (turn % 2 == 0) {
            champion1.throwAttack(champion2);
            champion2.throwAttack(champion1);
        } else {
            champion2.throwAttack(champion1);
            champion1.throwAttack(champion2);
        }
    }
}
