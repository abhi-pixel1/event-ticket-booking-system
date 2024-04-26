package org.fest.fest.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.fest.fest.Organizer;
import org.fest.fest.OrganizerFactory;
import org.fest.fest.PesuManagement;

public class PesuRegistrationController {
    @FXML
    private TextField userNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField departmentField;

    @FXML
    private TextField passwordField;

    @FXML
    private void pesuReg() {
        OrganizerFactory organizerFactory = new OrganizerFactory(emailField.getText(), passwordField.getText());
        Organizer organizer = organizerFactory.getInstance("Pesu");

        PesuManagement pesuManagement = (PesuManagement) organizer;
        pesuManagement.setPesuManagement(emailField.getText(), passwordField.getText(), userNameField.getText(),departmentField.getText());
        pesuManagement.register();
    }

}
