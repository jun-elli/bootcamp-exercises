package com.ironhack.bootcamp.s07;

import java.util.List;

public class MathLibrary {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    // Method to create array of a specified length
    public int[] createArray(int length) {
        return null; //returning null case
    }

    public int sumList(List<Integer> intList) {
        int sum = 0;

        for(int num : intList) {
            sum += num;
        }

        return sum;
    }
}