package org.fest.fest;
//
//public class Organizer extends User {
//    public Organizer(String email, String password) {
//        super(email, password);
//    }
//
//    @Override
//    public void login() {
//        // Organizer-specific login logic
//        System.out.println("Organizer login attempt:");
//        System.out.println("Email: " + email);
//        System.out.println("Password: " + password);
//        // Handle the organizer login attempt
//    }
//}
//


import org.fest.fest.Model.UserModel;

import java.util.List;

public class Organizer extends User {
    // Instance of the UserModel to handle database interactions
    private UserModel userModel;

    public List<String> l;
    // Constructor that accepts email and password and initializes the UserModel
    public Organizer(String email, String password) {
        super(email, password);
        userModel = new UserModel();  // Initialize UserModel instance
    }



    // Override the login method to handle organizer login
    @Override
    public List<String> login() {
        System.out.println("Organizer login attempt:");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        // Verify the organizer's password using the UserModel
        boolean isValid = userModel.verifyOrganizerPassword(email, password);

        // Handle the result of password verification
        if (isValid) {
            System.out.println("Organizer login successful");
            l= userModel.getEventsByOrganizerEmail(email);
            // Add any additional logic for successful organizer login
            System.out.println("Events organized by " + email + ":");
            for (String event : l) {
                System.out.println(event);
            }


        } else {
            System.out.println("Invalid organizer credentials");
            // Add any additional logic for unsuccessful organizer login
        }
        return l;
    }
}
