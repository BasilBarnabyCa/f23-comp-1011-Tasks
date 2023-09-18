package com.example.f23comp1011tasks;

public class User {
    private String email, userName, phone;

    // Constructors
    /**
     * This is the constructor that will be called whenever we create an instance of the User class
     * @param email - the email address of the user
     * @param userName - the username of the user
     * @param phone - the phone number of the user
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
     * @param email - the email address of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    /**
     * This method will validate the username and set the instance variable
     * Cannot be null or empty
     * @param userName - the username of the user
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
        this.phone = phone;
    }
}
