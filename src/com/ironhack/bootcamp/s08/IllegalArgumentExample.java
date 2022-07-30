package com.ironhack.bootcamp.s08;


public class IllegalArgumentExample {
    public static void main(String[] args) {
        int product = multiply(900000000, 400000000);
        System.out.println(product);
    }

    public static int multiply(int a, int b) {
        return (a * b)/b;
    }

    public static int multiplyWithValidation(int a, int b) {
        int product = a * b;
        if (product / a != b) {
            throw new IllegalArgumentException("Product of input is too great for int");
        }
        return a * b;
    }
}

