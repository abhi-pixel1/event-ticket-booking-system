
package org.fest.fest.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fest.fest.HelloApplication;
import org.fest.fest.Organizer;
import org.fest.fest.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class inputController {
    public List<String> l;

    @FXML
    private TextField organizerEmailField;

    @FXML
    private PasswordField organizerPasswordField;

    @FXML
    private TextField studentEmailField;

    @FXML
    private PasswordField studentPasswordField;

    @FXML
    private void handleOrganizerLogin(ActionEvent event) {
        // Create an instance of Organizer
        Organizer organizer = new Organizer(organizerEmailField.getText(), organizerPasswordField.getText());

        // Call the login method
        l=organizer.login();
        try {
            // Load the FXML file for displaying the list
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/EventsListView.fxml"));
            Parent root = fxmlLoader.load();

            // Get the controller and pass the list of events
            EventsListController controller = fxmlLoader.getController();
            controller.setEventsList(l);

            // Get the controller and pass the org id
            controller.setOrgId(organizerEmailField.getText());


            // Create a new stage and set the scene
            Stage stage = new Stage();
            stage.setTitle("Events List");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleStudentLogin(ActionEvent event) {
        // Create an instance of Student
        Student student = new Student(studentEmailField.getText(), studentPasswordField.getText());

        // Call the login method
        l=student.login();
        try {
            // Load the FXML file for displaying the list
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/HomeEventListView.fxml"));
            Parent root = fxmlLoader.load();

            // Get the controller and pass the list of events
            HomeEventListController controller = fxmlLoader.getController();
            controller.setEventsList(l);

            // Get the controller and pass the org id
            controller.setCustId(studentEmailField.getText());

            // Create a new stage and set the scene
            Stage stage = new Stage();
            stage.setTitle("Events List");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleClubReg(ActionEvent event) {
        System.out.println("Club Reg");

        try {
            // Load the FXML file for displaying the list
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/ClubRegistrationView.fxml"));
            Parent root = fxmlLoader.load();

            // Create a new stage and set the scene
            Stage stage = new Stage();
            stage.setTitle("Events List");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handlePesuReg(ActionEvent event) {
        System.out.println("Pesu Reg");

        try {
            // Load the FXML file for displaying the list
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/PesuRegistrationView.fxml"));
            Parent root = fxmlLoader.load();

            // Create a new stage and set the scene
            Stage stage = new Stage();
            stage.setTitle("Events List");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleExtreg(ActionEvent event) {
        System.out.println("Extreg");

        try {
            // Load the FXML file for displaying the list
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/ExtRegistrationView.fxml"));
            Parent root = fxmlLoader.load();

            // Create a new stage and set the scene
            Stage stage = new Stage();
            stage.setTitle("Events List");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleStudentReg(ActionEvent event) {
        System.out.println("student reg");

        try {
            // Load the FXML file for displaying the list
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/hello-view.fxml"));
            Parent root = fxmlLoader.load();







            // Create a new stage and set the scene
            Stage stage = new Stage();
            stage.setTitle("Events List");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}