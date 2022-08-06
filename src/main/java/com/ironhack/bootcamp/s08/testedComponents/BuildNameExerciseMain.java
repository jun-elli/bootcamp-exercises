package com.ironhack.bootcamp.s08.testedComponents;

public class BuildNameExerciseMain {

    public String concat(String first, String last) {
        if (first == null || last == null) {
            throw new IllegalArgumentException("Arguments should not be null");
        }

        return first + " " + last;
    }
}
