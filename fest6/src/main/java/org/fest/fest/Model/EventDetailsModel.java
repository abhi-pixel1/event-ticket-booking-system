package org.fest.fest.Model;

import org.fest.fest.Booking;

import java.sql.*;

public class EventDetailsModel {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/event_management";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Connection object
    private Connection connection;

    public EventDetailsModel() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSalesToDb(Booking booked){
        String query = "INSERT INTO sales (cust_id, event_id, ticket_id, ticket_type, no_of_tickets) VALUES (?, ?, ?, ?, ?);";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the all booking parameters
            String sale_id_str = String.valueOf(booked.sale_id);
            //String cust_id_str = String.valueOf(booked.cust_id);
            String event_id_str = String.valueOf(booked.event_id);
            String ticket_id_str = String.valueOf(booked.ticket_id);
            String no_of_tickets_str = String.valueOf(booked.no_of_tickets);


            //stmt.setString(1, sale_id_str);
            stmt.setString(1, booked.cust_id);
            stmt.setString(2, event_id_str);
            stmt.setString(3, ticket_id_str);
            stmt.setString(4, booked.ticket_type);
            stmt.setString(5, no_of_tickets_str);


            // Execute the query
            //ResultSet resultSet = stmt.executeQuery();
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("booking done successfully!");
            } else {
                System.out.println("Booking failed.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
