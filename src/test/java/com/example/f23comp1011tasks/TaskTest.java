package com.example.f23comp1011tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    Task task;
    User user;
    @BeforeEach
    void setUp() {
        user = new User("basil@email.com", "basil1", "555-555-5555");
        task = new Task("Test Task", "This is a test task", LocalDate.now(), 60, user);
    }

    @Test
    void setTaskID() {
        task.setTaskID(1);
        assertEquals(1, task.getTaskID());
    }
}