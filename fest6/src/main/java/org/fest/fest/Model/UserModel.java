package org.fest.fest.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/event_management";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Connection object
    private Connection connection;

    // Constructor to establish a connection to the database
    public UserModel() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to verify the password for a student
    public boolean verifyStudentPassword(String email, String password) {
        boolean isValid = false;

        // SQL query to retrieve the password from the student table
        String query = "SELECT password FROM student WHERE email = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the email parameter
            stmt.setString(1, email);

            // Execute the query
            ResultSet resultSet = stmt.executeQuery();

            // If a result is found, compare the provided password with the one in the database
            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                isValid = password.equals(dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValid;
    }

    // Method to verify the password for an organizer
    public boolean verifyOrganizerPassword(String email, String password) {
        boolean isValid = false;

        // SQL query to retrieve the password from the organizer table
        String query = "SELECT password FROM organizer WHERE email = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Set the email parameter
            stmt.setString(1, email);

            // Execute the query
            ResultSet resultSet = stmt.executeQuery();

            // If a result is found, compare the provided password with the one in the database
            if (resultSet.next()) {
                String dbPassword = resultSet.getString("password");
                isValid = password.equals(dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValid;
    }


    public List<String> getEventsByOrganizerEmail(String email) {
        List<String> eventList = new ArrayList<>();

        // SQL query to retrieve the organizer_id from the organizer table
        String eventQuery = "SELECT event_name FROM event where org_id = ?";
        try (PreparedStatement eventStmt = connection.prepareStatement(eventQuery)) {
            // Set the organizer_id parameter
             eventStmt.setString(1, email);

            // Execute the query and retrieve the events
            ResultSet eventResultSet = eventStmt.executeQuery();

            // Add each event to the list
            while (eventResultSet.next()) {
                eventList.add(eventResultSet.getString("event_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventList;
    }


    public List<String> getAllEvents() {
        List<String> eventList = new ArrayList<>();

        String eventQuery = "SELECT event_name FROM event";
        try (PreparedStatement eventStmt = connection.prepareStatement(eventQuery)) {
            // Set the organizer_id parameter
            // eventStmt.setInt(1, organizerId);

            // Execute the query and retrieve the events
            ResultSet eventResultSet = eventStmt.executeQuery();

            // Add each event to the list
            while (eventResultSet.next()) {
                 eventList.add(eventResultSet.getString("event_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventList;
    }

    public List<List<String>> getEventByName(String eventName) {
        List<List<String>> eventDetailsList = new ArrayList<>();

        String eventQuery = "SELECT * FROM event INNER JOIN ticket ON event.event_id = ticket.event_id WHERE event.event_name = ?;";

        try (PreparedStatement eventStmt = connection.prepareStatement(eventQuery)) {
            // Set the organizer_id parameter
             eventStmt.setString(1, eventName);

            // Execute the query and retrieve the events
            ResultSet eventResultSet = eventStmt.executeQuery();




            // Add each event to the list
            while (eventResultSet.next()) {
                List<String> eventDetails = new ArrayList<>();

                System.out.println(eventResultSet);

                eventDetails.add(eventResultSet.getString("event_name"));
                eventDetails.add(eventResultSet.getString("description"));
                eventDetails.add(eventResultSet.getString("start_time"));
                eventDetails.add(eventResultSet.getString("end_time"));
                eventDetails.add(eventResultSet.getString("place"));
                eventDetails.add(eventResultSet.getString("date"));
                eventDetails.add(eventResultSet.getString("type"));
                eventDetails.add(eventResultSet.getString("cost"));
                eventDetails.add(eventResultSet.getString("no_of_seats"));
                eventDetails.add(eventResultSet.getString("event_id"));
                eventDetails.add(eventResultSet.getString("ticket_id"));

                eventDetailsList.add(eventDetails);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventDetailsList;
    }

}