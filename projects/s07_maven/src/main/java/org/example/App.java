package org.example;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            File usersJson = new File("fixtures/users.json");
            Scanner scanner = new Scanner(usersJson);

            String json = "";
            while (scanner.hasNextLine()) {
                json += scanner.nextLine();
            }

            UserLoader userLoader = new UserLoader();
            List<User> users = userLoader.loadUsers(json);

            userLoader.printUsers(users);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Couldn't find fixtures/users.json");
        }

    }


}
