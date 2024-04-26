package org.fest.fest.Model;

import org.fest.fest.Ticket;

import java.sql.*;

public class EventCreationModel {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/event_management";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Connection object
    private Connection connection;

    public EventCreationModel() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEventToDb(int event_id, String org_id, String event_name, String description, String start_time, String end_time, String place, Ticket platinumTicket, Ticket goldTicket, Ticket silverTicket){
        // SQL query to insert the event data
        // String query = "INSERT INTO event (event_id, org_id, event_name, description, start_time, end_time, place) VALUES (?, ?, ?, ?, ?, ?, ?);";
        int event_id_temp=0;

        String query = "INSERT INTO event (org_id, event_name, description, start_time, end_time, place) VALUES (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the all event parameters
            // String event_id_str = String.valueOf(event_id);

            // stmt.setString(1, event_id_str);
            stmt.setString(1, org_id);
            stmt.setString(2, event_name);
            stmt.setString(3, description);
            stmt.setString(4, start_time);
            stmt.setString(5, end_time);
            stmt.setString(6, place);


            // Execute the query
            //ResultSet resultSet = stmt.executeQuery();
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Event added successfully!");
            } else {
                System.out.println("Failed to add event.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }




        query = "SELECT event_id FROM event WHERE org_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the email parameter
            stmt.setString(1, org_id);

            // Execute the query
            ResultSet resultSet = stmt.executeQuery();


            // If a result is found, compare the provided password with the one in the database
            if (resultSet.next()) {
                event_id_temp = resultSet.getInt("event_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }





        // SQL query to insert the event data
        // query = "INSERT INTO ticket (ticket_id, event_id, type, cost, no_of_seats) VALUES (?, ?, ?, ?, ?);";
        query = "INSERT INTO ticket (event_id, type, cost, no_of_seats) VALUES (?, ?, ?, ?);";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            // stmt.setString(1, String.valueOf(platinumTicket.ticketId));
            stmt.setString(1, String.valueOf(event_id_temp));
            stmt.setString(2, platinumTicket.type);
            stmt.setString(3, String.valueOf(platinumTicket.cost));
            stmt.setString(4, String.valueOf(platinumTicket.noOfSeats));


            // Execute the query
            //ResultSet resultSet = stmt.executeQuery();
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Platinum Ticket added successfully!");
            } else {
                System.out.println("Platinum Failed to add event.");
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------------------------------------------------------

        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            //stmt.setString(1, String.valueOf(event_id_temp));
            stmt.setString(1, String.valueOf(goldTicket.eventId));
            stmt.setString(2, goldTicket.type);
            stmt.setString(3, String.valueOf(goldTicket.cost));
            stmt.setString(4, String.valueOf(goldTicket.noOfSeats));


            // Execute the query
            //ResultSet resultSet = stmt.executeQuery();
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("gold Ticket added successfully!");
            } else {
                System.out.println("gold Failed to add event.");
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------------------------------------------------------

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the all event parameters
            String event_id_str = String.valueOf(event_id);

            //stmt.setString(1, String.valueOf(silverTicket.ticketId));
            stmt.setString(1, String.valueOf(event_id_temp));
            stmt.setString(2, silverTicket.type);
            stmt.setString(3, String.valueOf(silverTicket.cost));
            stmt.setString(4, String.valueOf(silverTicket.noOfSeats));


            // Execute the query
            //ResultSet resultSet = stmt.executeQuery();
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("silver Ticket added successfully!");
            } else {
                System.out.println("silver Failed to add event.");
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
