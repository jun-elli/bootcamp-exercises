package com.ironhack.bootcamp.exercises.s3.io;

import java.util.Scanner;

public class FindTheNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numero = new Double(Math.random() * 10).intValue();

        System.out.println("Adivina qué número estoy pensando");
        int intento = 0;
        try {
            intento = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Esto no es un número así no juego");
            intento = 0;
        }
        int numerIntento = 5;

        if (intento == 0) {
            System.exit(1);
        }

        while ((intento != numero) && numerIntento > 0) {
            if (intento > numero) {
                System.err.println("Uuuuy, te has pasado " + "te quedan " + numerIntento + " intentos");
                intento = Integer.parseInt(scanner.nextLine());
            } else if (intento < numero) {
                System.err.println("vaya!, te has quedado corto " + "te quedan " + numerIntento + " intentos ");
                Integer.parseInt(scanner.nextLine());
            }
            numerIntento--;
        }

        System.out.println("Muy bien, justo en el clavo!");

        scanner.close();
    }
}
