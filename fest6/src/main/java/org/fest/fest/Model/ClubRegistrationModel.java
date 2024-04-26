package org.fest.fest.Model;

import java.sql.*;

public class ClubRegistrationModel {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/event_management";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private String org_id;

    // Connection object
    private Connection connection;

    public ClubRegistrationModel() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveOrgToDb(String email, String password, String userName, String clubName, String department, String faculty){
        String query = "INSERT INTO organizer (user_name, email, password, org_type) VALUES (?, ?, ?, ?);";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the all event parameters
            stmt.setString(1, userName);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, "1");



            // Execute the query
            //ResultSet resultSet = stmt.executeQuery();
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Organizer added successfully!");
            } else {
                System.out.println("Failed to add Organizer.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        query = "SELECT * FROM organizer WHERE email = ?;";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the all event parameters
            stmt.setString(1, email);



            // Execute the query
            ResultSet resultSet = stmt.executeQuery();

            // Set org_id

            if (resultSet.next()) {
                org_id = resultSet.getString("org_id");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


        query = "INSERT INTO club (org_id, name, clubName, department, faculty) VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the all event parameters
            stmt.setString(1, org_id);
            stmt.setString(2, userName);
            stmt.setString(3, clubName);
            stmt.setString(4, department);
            stmt.setString(5, faculty);



            // Execute the query


            // Set org_id
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Organizer added successfully!");
            } else {
                System.out.println("Failed to add Organizer.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
