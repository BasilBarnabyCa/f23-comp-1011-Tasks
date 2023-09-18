package com.example.f23comp1011tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User newUser;

    @BeforeEach
    void setUp() {
        newUser = new User("basil@email.com", "basil1", "555-555-5555");
    }

    @Test
    void setEmail() {
        newUser.setEmail("basil@georgian.ca");
    }

    @Test
    void setInvalidUserEmail() {
        assertThrows(IllegalArgumentException.class, () -> newUser.setEmail(""));
        assertThrows(IllegalArgumentException.class, () -> newUser.setEmail("   "));
        assertThrows(IllegalArgumentException.class, () -> newUser.setEmail("basil"));
        assertThrows(IllegalArgumentException.class, () -> newUser.setEmail("basil@"));
//        assertThrows(IllegalArgumentException.class, () -> newUser.setEmail("basil@georgian"));
        assertThrows(IllegalArgumentException.class, () -> newUser.setEmail("basil@georgian."));
    }

    @Test
    void setUserName() {
        newUser.setUserName("Barney");
        assertEquals("Barney", newUser.getUserName());
    }

    @Test
    void setInvalidUserName() {
        assertThrows(IllegalArgumentException.class, ()-> newUser.setUserName(""));
        assertThrows(IllegalArgumentException.class, ()-> newUser.setUserName("   "));
//        assertThrows(IllegalArgumentException.class, ()-> newUser.setUserName(" Basil "));
    }

    @Test
    void setPhone() {
    }
}