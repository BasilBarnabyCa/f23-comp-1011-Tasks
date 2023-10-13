package com.example.f23comp1011tasks;

import java.time.LocalDate;

public class Task {
    private int taskID;
    private String title, description;
    private LocalDate dueDate, creationDate;
    private int estimatedTimeLengthInMin;
    private User user;

    private Status status;

    // Constructors
    public Task( String title, String description, LocalDate dueDate, int estimatedTimeLengthInMin, User user) {
        creationDate = LocalDate.now();
        status = Status.CREATED;
        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
        setEstimatedTimeLengthInMin(estimatedTimeLengthInMin);
        setUser(user);
    }

    /**
     * This constructor will be used when we are retrieving a task from the database
     * @param taskID The ID of the task
     * @param title The title of the task
     * @param description The description of the task
     * @param dueDate The due date of the task
     * @param creationDate The creation date of the task
     * @param estimatedTimeLengthInMin The estimated time length of the task
     * @param user The user assigned to the task
     * @param status The status of the task
     */
    public Task(int taskID, String title, String description, LocalDate dueDate, LocalDate creationDate, int estimatedTimeLengthInMin, User user, Status status) {
        setTaskID(taskID);
        setTitle(title);
        setDescription(description);
        setEstimatedTimeLengthInMin(estimatedTimeLengthInMin);
        setCreationDate(creationDate);
        this.dueDate = dueDate;
        this.user = user;
        this.status = status;
    }

    // Getters and Setters
    public int getTaskID() {
        return taskID;
    }

    public int setTaskID(int taskID) {
        return this.taskID = taskID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        if(creationDate.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Creation date cannot be in the future");
        this.creationDate = creationDate;
    }

    public int getEstimatedTimeLengthInMin() {
        return estimatedTimeLengthInMin;
    }

    public void setEstimatedTimeLengthInMin(int estimatedTimeLengthInMin) {
        this.estimatedTimeLengthInMin = estimatedTimeLengthInMin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
