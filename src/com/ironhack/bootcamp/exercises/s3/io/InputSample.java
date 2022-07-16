package com.ironhack.bootcamp.exercises.s3.io;

import java.util.Scanner;

public class InputSample {
    public static void main(String[] args) throws NumberFormatException {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int count = 0;
        String[] words = line.split(" ");

        System.out.println("Please introduce a phrase to be counted");

        for (String word : words) {
            if (word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u")) {
                count++;
            } else {
                System.err.println("Word skipped " + word);
            }
        }

        System.out.println("Words: " + count);

        scanner.close();
    }
}