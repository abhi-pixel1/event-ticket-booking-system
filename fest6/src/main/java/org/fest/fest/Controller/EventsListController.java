package org.fest.fest.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import org.fest.fest.HelloApplication;

import java.io.IOException;
import java.util.List;

public class EventsListController {


    @FXML
    private ListView<String> eventsListView;
    private String org_id;

    // Method to set the list of events
    public void setEventsList(List<String> events) {
        // Convert the list to an ObservableList
        ObservableList<String> observableList = FXCollections.observableArrayList(events);

        // Set the items of the ListView
        eventsListView.setItems(observableList);
    }

    // Method to set the org_id
    public void setOrgId(String orgId) {
        org_id = orgId;
    }



    // Method to handle button click to redirect to the event creation page
    public void redirectToEventCreationPage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/EventCreationView.fxml"));
        Parent root = fxmlLoader.load();

        // Get the controller and pass the org id
        EventCreationController controller = fxmlLoader.getController();
        controller.setOrgId(org_id);

        // Get the stage from the event source
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}

