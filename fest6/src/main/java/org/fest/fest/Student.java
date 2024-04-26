package org.fest.fest;

import org.fest.fest.Model.UserModel;

import java.util.List;

// Subclass Student
public class Student extends User {
    // Instance of the UserModel to handle database interactions
    private UserModel userModel;

    public List<String> l;

    public Student(String email, String password) {
        super(email, password);
        userModel = new UserModel();  // Initialize UserModel instance
    }

    @Override
    public List<String> login() {
        // Student-specific login logic
        System.out.println("Student login attempt:");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);


        // Handle the student login attempt
        // Verify the organizer's password using the UserModel
        boolean isValid = userModel.verifyStudentPassword(email, password);

        // Handle the result of password verification
        if (isValid) {
            System.out.println("Organizer login successful");
            l= userModel.getAllEvents();
            // Add any additional logic for successful organizer login
            System.out.println("List of events " + ":");
            for (String event : l) {
                System.out.println(event);
            }


        } else {
            System.out.println("Invalid student credentials");
            // Add any additional logic for unsuccessful organizer login
        }
        return l;
    }
}
