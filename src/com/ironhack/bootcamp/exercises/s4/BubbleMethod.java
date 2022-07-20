package com.ironhack.bootcamp.exercises.s4;

public class BubbleMethod {

    public static void main(String[] args) {
        int[] testArr = {1, 5, 28, 3, 8};

        injectSort(testArr);
    }


    public static void injectSort(int[] arr) {
        for (int i=0; i < arr.length -2; i++) {
            for (int j=0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }


        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
