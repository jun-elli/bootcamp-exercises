package com.ironhack.bootcamp.s12_practiceII;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GsonExampleMain {

    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
            Scanner scanner = new Scanner(new File("MOCK_DATA.json"));
            String str = "";
            while (scanner.hasNextLine()) {
                str += scanner.nextLine();
            }


            List<Map<String, Object>> usersList = gson.fromJson(str, List.class);
            String name = "Doralyn";
            Map foundUser = null;

            for (Map user : usersList) {

                if (user.get("first_name").equals(name) ) {
                    foundUser = user;
                }
            }

            System.out.println("Found user " + gson.toJson(foundUser));

            System.out.println(gson.toJson(usersList));
        } catch (FileNotFoundException fileNotFoundException){
            System.err.println("Couldn't find MOCK_DATA.json");
        }


    }
}
