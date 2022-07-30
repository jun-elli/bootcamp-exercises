package com.ironhack.bootcamp.exercices.jun;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Test {
    public static void main(String[] args) {
        // askName();
        guessNumber();
    }

    private static void askName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi! Write your name: ");
        String line = scanner.nextLine();
        System.out.println("Your name is " + line);
    }
    private static void guessNumber() {
        double d = Math.random() * 10;
        int correctNum = (int) d;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your guess number: ");
        int guess = Integer.parseInt(scanner.nextLine());

        while (guess != correctNum) {
            if (guess > correctNum) {
                System.err.println("The number has to be lower.");
                guess = Integer.parseInt(scanner.nextLine());
            } else {
                System.err.println("The number has to be bigger.");
                guess = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("You guessed correctly!");



    }
}
