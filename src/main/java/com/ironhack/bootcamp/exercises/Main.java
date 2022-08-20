package com.ironhack.bootcamp.exercises;

import com.ironhack.bootcamp.exercises.s2.ArrayLoop;

import java.util.ArrayList;
import java.util.List;

public class Main {

    SubscritionTypes subscriptionType;
    Integer points;


    /**
     * TODOS:
     * Import the classes with the examples and exercises and run them from this Main class
     * all of them should have a execute method that can be invoked with a number to choose a method to run in the class.
     * @param args
     */
    public static void main (String[] args) {
        ArrayLoop arrayLoop = new ArrayLoop();
        arrayLoop.execute(1);

        int index = 2;
        List<Integer> numbers = new ArrayList<>();
    }


//    incrementAtIndex([1,2,3], 1)
    public List<Integer> incrementAtIndex(List<Integer> numList, int index) {
       numList.get(index);
       numList.set(index, numList.get(index) + 1);

       return numList;
    }

    public void applyReward(int reward) {
       if (subscriptionType.equals(SubscritionTypes.BOLD)) {
            points = points + 3* reward;
       }

       switch (subscriptionType)  {
           case BOLD:
               points = points + 3* reward;
               break;
           case SYLVER:
               points = points + 3* reward;
               break;
       }
    }
}

enum SubscritionTypes {
    BOLD,
    SYLVER,
    FREE;
}
