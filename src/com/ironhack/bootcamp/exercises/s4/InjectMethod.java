package com.ironhack.bootcamp.exercises.s4;

public class InjectMethod {

    public static void main(String[] args) {
        int[] testArr = {1, 5, 28, 3, 8};

        injectSort(testArr);
    }

    public static void injectSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int current = arr[j];
            int i = j-1;
            while ((i > -1) && (arr[i] > current)) {
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = current;
        }


        for (int i: arr) {
            System.out.println(i);
        }
    }
}
