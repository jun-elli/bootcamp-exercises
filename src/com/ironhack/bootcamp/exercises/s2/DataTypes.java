package com.ironhack.bootcamp.exercises.s2;

public class DataTypes {

    public void execute(int n) {
        ArrayLoop al = new ArrayLoop();
        // Fill in this switch structure to run each method based on the method argument n
        // ***** See ArrayLoop for an example ****
        switch (n) {
            default:
                System.out.println("fill me in!!!");
        }
    }

    public void printVariables() {
        // Data types
        int var1 = 655;
        short var4 = 100;
        double var2 = 5.5;
        String var3 = "Hello World";

        boolean isOk = false;

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
    }

    public void printOperators() {
        // Operators
        System.out.println(10 + 5);
        System.out.println(10 - 5);
        System.out.println(10 * 5);
        System.out.println(10 / 2);
        System.out.println(9 % 2);

        int var5 = 1;
        var5 = var5 + 1;
        var5 = var5++;
        System.out.println(var5++); // Show differences between var5++ and ++var5
        System.out.println(var5);
    }

    public void conditionalPaths() {
        int var1 = 654;
        // If...Else
        if (!(var1 > 10)) {
            System.out.println("Too much!");
        } else if (var1 < 10) {
            System.out.println("Too little!");
        } else {
            System.out.println("Just right!");
        }
    }

    public void switchExample() {
        // Switch
        Days day = Days.WEDNESDAY;
        switch (day) {
            case MONDSY:
                System.out.println("Monday");
                break;
            case TUESDAY:
                System.out.println("Tuesday");
                break;
            case WEDNESDAY:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Weekend");
                break;
        }

        if (isWorkingDay(1)) {
            System.out.println("Is a working Day");
        } else {
            System.out.println("weekend!!!");
        }
    }

    public static boolean isWorkingDay(int day) {
        boolean isWorkingDay = false;
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                isWorkingDay = true;
                break;
            case 6:
            case 7:
                isWorkingDay = false;
                break;
        }
        return isWorkingDay;
    }


    class Child {
        String name;
    }

    enum Days {
        MONDSY,
        TUESDAY,
        WEDNESDAY
    }
}
