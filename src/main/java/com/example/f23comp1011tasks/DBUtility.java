package com.example.f23comp1011tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class DBUtility {
    private static final String userName = "root";
    private static final String password = "grafic@R00t!";

    private static final String connectionString = "jdbc:mysql://localhost:3306/comp1011Tasks";

    public static String addUser(User user) {
        String response = "broken";

        String sql = "INSERT INTO users VALUES (?, ?, ?)";

        // Try with resources will close anything that is opened in the try block: db connections
        try(
                Connection conn  = DriverManager.getConnection(connectionString, userName, password);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getUserName());
            stmt.setString(3, user.getPhone());

            stmt.executeUpdate();

            response = "User added successfully";

        } catch (SQLIntegrityConstraintViolationException e) {
            response = "Email address already exists";
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
