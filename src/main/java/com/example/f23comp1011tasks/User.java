package com.example.f23comp1011tasks;

import java.util.regex.Pattern;

public class User {
    private String email, userName, phone;

    // Constructors
    /**
     * This is the constructor that will be called whenever we create an instance of the User class
     * @param email The email address of the user
     * @param userName The username of the user
     * @param phone The phone number of the user
     */
    public User(String email, String userName, String phone) {
       setEmail(email);
       setUserName(userName);
       setPhone(phone);
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    /**
     * This method will validate the email address and set the instance variable
     * @param email The email address of the user
     */
    public void setEmail(String email) {
        if(isEmailValid(email))
            this.email = email;
        else
            throw new IllegalArgumentException("Email must match the RC822 standard");
        this.email = email;
    }

    /**
     * This method will validate the email address and set the instance variable
     * @param email The email address of the user
     */
    public static boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }


    public String getUserName() {
        return userName;
    }

    /**
     * This method will validate the username and set the instance variable
     * Cannot be null or empty
     * @param userName The username of the user
     */
    public void setUserName(String userName) {
        userName = userName.trim();

        if (userName.matches("[A-z1-9]+")) {
           this.userName = userName;
        } else {
            throw new IllegalArgumentException("Username must be only letters and numbers and must have at least one character");
        }

        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone.replaceAll("[^0-9]", "");

        // North American dialing plan
        //3 digit - area code [2-9]
        //3 digit - city code [2-9]
        //4 digit - line number [0-9]{4}

        if(phone.matches("[2-9][0-9]{2}[2-9][0-9]{6}")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone number must be 10 digits and follow the North American dialing plan");
        }
    }
}
