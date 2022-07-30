package com.ironhack.bootcamp.s08;

/*
Create a method that concatenates a String firstName and a String lastName into a String fullName.
The method should throw an exception if either String is null or empty.
In your main method call the method and handle this exception using a try/catch block.
 */
public class BuildNameExerciseMain {

    public static void main(String[] args) {
        try {
            System.out.println(concat("", "Alvarez"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String concat(String str1, String str2) throws IllegalArgumentException {

        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            throw new IllegalArgumentException("Strings cannot be null or empty");
        }

        return str1 + " " + str2;
    }
}