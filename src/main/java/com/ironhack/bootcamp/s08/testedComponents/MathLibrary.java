package com.ironhack.bootcamp.s08.testedComponents;

public class MathLibrary {

    public static int multiply(int a, int b) {

        int product = a * b;
        if (product/a != b) {
            throw new IllegalArgumentException("Product of input is too great for int");
        }
        return a * b;
    }
}