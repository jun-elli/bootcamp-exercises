package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserLoaderTest{

    private UserLoader userLoader;

    @BeforeEach
    public void init() {
        userLoader = new UserLoader();
    }

    @Test
    @DisplayName("Make sure a list with a single user loads properly")
    public void testLoadUsers() throws FileNotFoundException {
        File fixture = new File("fixtures/oneUserList.json");
        Scanner scanner = new Scanner(fixture);

        StringBuilder json = new StringBuilder();
        while (scanner.hasNextLine()) {
            json.append(scanner.nextLine());
        }

        List<User> users = userLoader.loadUsers(json.toString());

        assertEquals(users.size(), 1);
        assertEquals(users.get(0).getId(), 1);
        assertEquals(users.get(0).getName(), "Marissa Rogers");
        assertEquals(users.get(0).getFriends().size(), 2);
        assertEquals(users.get(0).getFriends().get(0).getId(), 0 );
    }

    @Test
    @DisplayName("Make sure a list with a single user without friends loads properly")
    public void testLoadUsersNoFriends() throws FileNotFoundException {
        File fixture = new File("fixtures/oneUserListNoFriends.json");
        Scanner scanner = new Scanner(fixture);

        StringBuilder json = new StringBuilder();
        while (scanner.hasNextLine()) {
            json.append(scanner.nextLine());
        }

        List<User> users = userLoader.loadUsers(json.toString());

        assertEquals(users.size(), 1);
        assertEquals(users.get(0).getId(), 1);
        assertEquals(users.get(0).getName(), "Marissa Rogers");
        assertEquals(users.get(0).getFriends(), null);
    }
}
