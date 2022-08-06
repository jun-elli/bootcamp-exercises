package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserLoader {

    public List<User> loadUsers(String jsonStr) {
        Gson gson = new Gson();
//        User[] users =  gson.fromJson(jsonStr, User[].class);
//
//        return Arrays.asList(users);
        return new ArrayList<>();
    }

    public void printUsers(List<User> users) {
        Gson gson = new Gson();

        System.out.println(gson.toJson(users));
    }
}
