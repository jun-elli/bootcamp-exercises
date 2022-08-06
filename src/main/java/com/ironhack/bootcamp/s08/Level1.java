package com.ironhack.bootcamp.s08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Level1 {
    public void treeCall1() {
        Level2 level2 = new Level2();
        level2.treeCall2();
    }

    public void uncheckedExample(Integer throwsNPEIfNull) {
        if (throwsNPEIfNull == null) {
            throw new NullPointerException();
        } else {
            System.out.println("You passed the tests");
        }

    }

    public void checkedExample(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            // Antonio;2;Mas
            // Fernando;Gimenez;4
            String line = scanner.nextLine();
            processStudent(line);

        }
//        List<Student> students =
//            ...
//        return students
    }

    private void processStudent(String line) {
        try {
            String[] fields = line.split(";");
            Map<String, Object> student = new HashMap<>();
            student.put("name", Integer.parseInt(fields[2]));
        } catch (NumberFormatException nfe) {
            System.err.println("para " + line + " no se ha podido procesar ");
        }
    }
}
