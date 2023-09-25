package com.example.f23comp1011tasks;

public class TempUser {
    public static void main(String[] args) {
        User newUser = new User("basil@email.com",
                "basil1",
                "5555555555");

        System.out.println(DBUtility.addUser(newUser));
    }
}
