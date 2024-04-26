package org.fest.fest.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.fest.fest.Club;
import org.fest.fest.Organizer;
import org.fest.fest.OrganizerFactory;

public class ClubRegistrationController {
    @FXML
    private TextField userNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField clubNameField;

    @FXML
    private TextField departmentField;

    @FXML
    private TextField facultyField;

    @FXML
    private TextField passwordField;

    @FXML
    private void clubReg() {
        // Retrieve input values from the text fields

        OrganizerFactory organizerFactory = new OrganizerFactory(emailField.getText(), passwordField.getText());
        System.out.println("controller----" + emailField.getText());
        Organizer organizer = organizerFactory.getInstance("Club");

        Club club = (Club) organizer;
        club.setClub(passwordField.getText(), emailField.getText(), userNameField.getText(), clubNameField.getText(), departmentField.getText(), facultyField.getText());
        club.register();
    }
}
