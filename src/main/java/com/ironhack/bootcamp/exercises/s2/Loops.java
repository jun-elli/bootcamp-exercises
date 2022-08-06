package com.ironhack.bootcamp.exercises.s2;

public class Loops {

    public void execute(int n) {
        forExamples();
    }

    public void forExamples() {
        String[] names = {"Juan", "Pedro", "Ines"};

        for (int idx=0; idx < names.length; idx = idx +2 ) {
            System.out.println(names[idx]);
        }

        for( String name : names ) {
            System.out.println(name);
        }

        int idx = 3;
        while(++idx < names.length) {
            System.out.println(names[idx]);
        }

        idx = 3;
        do {
            System.out.println(names[idx]);
        } while (idx < names.length);
    }
}
