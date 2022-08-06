package com.ironhack.bootcamp.s08;

import java.io.File;
import java.io.FileNotFoundException;

public class ExceptionHandlingExample {

    public static void main(String[] args) {

        /* To handle an exception: */
        try {
            Float f = Float.parseFloat("a");
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Cannot parse a to float");
        }
        // throws NumberFormatException
//        Float f = Float.parseFloat("a");

        // throws FileNotFoundException
//        File file = new File("thisFileDoesntExist");

        //throws ArithmeticException
//        Float f2 = 12.2f/0f;

        Level1 level1 = new Level1();
        level1.treeCall1();
    }
}
