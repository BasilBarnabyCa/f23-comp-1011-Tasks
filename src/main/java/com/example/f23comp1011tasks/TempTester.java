package com.example.f23comp1011tasks;

import java.util.ArrayList;
import java.util.Collections;

public class TempTester {
    public static void main(String[] args) {
//        createUser();
//        showUsers();
        showTasks();
    }

    private static void createUser()
    {
        User newUser = new User("basil@email.com",
                "basil1",
                "5555555555");

        System.out.println(DBUtility.addUser(newUser));
    }

    private static void showUsers()
    {
        ArrayList<User> users = DBUtility.getUsers();
//        Collections.sort(users);
        System.out.println(users);
    }

    private static void showTasks()
    {
        ArrayList<Task> tasks = DBUtility.getTasks();
        System.out.println(tasks);
    }

}
