package com.example.f23comp1011tasks;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static final String userName = "root";
    private static final String password = "grafic@R00t!";
    private static final String connectionString = "jdbc:mysql://localhost:3306/comp1011Tasks";

    /**
     * This method will add a user to the database
     * @param user The user to be added
     * @return response message
     */
    public static String addUser(User user) {
        String response = "broken";

        String sql = "INSERT INTO users VALUES (?, ?, ?)";

        // Try with resources will close anything that is opened in the try block: db connections
        try (
                Connection conn = DriverManager.getConnection(connectionString, userName, password);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getUserName());
            stmt.setString(3, user.getPhone());

            stmt.executeUpdate();

            response = "User added successfully";

        } catch (SQLIntegrityConstraintViolationException e) {
            response = "Email address already exists";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * This method will return a list of all the users in the database
     * @return ArrayList<User> of type User
     */
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        // Use a try with resources block to connect to the database
        String sql = "SELECT * FROM users ORDER BY userName ASC";

        try (
                Connection conn = DriverManager.getConnection(connectionString, userName, password);
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                User user = new User(resultSet.getString("email"),
                        resultSet.getString("userName"),
                        resultSet.getString("phone"));

                users.add(user);

                //q: how to sort by username?
                //a: add a method to the User class that implements the Comparable interface
                //   and then use the Collections.sort() method

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * This method will add a task to the database
     * @param task The task to be added
     * @return response message
     */
    public static String addTask(Task task) {
        String response = "broken";

        String sql = "INSERT INTO tasks (title, taskDescription, dueDate, createdAt, estimatedLengthInMins, email, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        ResultSet resultSet = null;

        // Try with resources will close anything that is opened in the try block: db connections
        try (
                Connection conn = DriverManager.getConnection(connectionString, userName, password);
                PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"taskID"});
        ) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, Date.valueOf(task.getDueDate()).toString());
            stmt.setString(4, Date.valueOf(task.getCreationDate()).toString());
            stmt.setInt(5, task.getEstimatedTimeLengthInMin());
            stmt.setString(6, task.getUser().getEmail());
            stmt.setString(7, task.getStatus().toString());

            stmt.executeUpdate();

            int taskID = -1;

            resultSet = stmt.getGeneratedKeys();
            while (resultSet.next())
                taskID = resultSet.getInt(1);

            response = "Task save with ID: " + taskID;

        } catch (SQLIntegrityConstraintViolationException e) {
            response = "Email address already exists";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}