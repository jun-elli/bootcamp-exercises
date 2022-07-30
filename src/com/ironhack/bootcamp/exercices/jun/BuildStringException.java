package com.ironhack.bootcamp.exercices.jun;
/*
Create a method that concatenates a String firstName and a String lastName into a String fullName.
The method should throw an exception if either String is null or empty.
In your main method call the method and handle this exception using a try/catch block.
 */
public class BuildStringException {
    public static void main(String[] args) {
        try {
            String fullName = buildName("Jun", null);
        } catch (IllegalArgumentException iae) {
            System.err.println("One or both of your arguments are null");
        }
    }

    public static String buildName(String name, String surname) throws IllegalArgumentException{
        if (name == null || surname == null) {
            throw new IllegalArgumentException();
        } else {
            return name + " " + surname;
        }
    }
}
