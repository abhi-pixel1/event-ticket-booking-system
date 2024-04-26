package org.fest.fest.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.fest.fest.Event;
import org.fest.fest.Model.EventCreationModel;
import org.fest.fest.Ticket;
import org.fest.fest.TicketBuilder;

public class EventCreationController {
    private String org_id;

    // @FXML
    // private TextField eventIdField;

    // @FXML
    // private TextField organizerIdField;

    @FXML
    private TextField eventNameField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField startTimeField;

    @FXML
    private TextField endTimeField;

    @FXML
    private TextField placeField;

    @FXML
    private TextField platinumCostField;

    @FXML
    private TextField platinumNOSField;

    @FXML
    private TextField goldCostField;

    @FXML
    private TextField goldNOSField;

    @FXML
    private TextField silverCostField;

    @FXML
    private TextField silverNOSField;



    // Method to set the org_id
    public void setOrgId(String orgId) {
        org_id = orgId;
    }

    // Method to handle event creation
    @FXML
    private void createEvent() {
        // Retrieve input values from the text fields
        // int eventId = Integer.parseInt(eventIdField.getText());
        // String organizerId = organizerIdField.getText();
        String eventName = eventNameField.getText();
        String description = descriptionField.getText();
        String startTime = startTimeField.getText();
        String endTime = endTimeField.getText();
        String place = placeField.getText();

        int platinumCost = Integer.parseInt(platinumCostField.getText());
        int platinumNOS = Integer.parseInt(platinumNOSField.getText());

        int goldCost = Integer.parseInt(goldCostField.getText());
        int goldNOS = Integer.parseInt(goldNOSField.getText());

        int silverCost = Integer.parseInt(silverCostField.getText());
        int silverNOS = Integer.parseInt(silverNOSField.getText());

        // Create an instance of EventModel to interact with the database
        Ticket platinumTicket = new TicketBuilder()
                .setTicketId(10)
                .setEventId(10)
                .setCost(platinumCost)
                .setNoOfSeats(platinumNOS)
                .setType("platinum")
                .setDiscount(90)
                .getTicket();

        Ticket goldTicket = new TicketBuilder()
                .setTicketId(11)
                .setEventId(11)
                .setCost(goldCost)
                .setNoOfSeats(goldNOS)
                .setType("gold")
                .setDiscount(90)
                .getTicket();

        Ticket silverTicket = new TicketBuilder()
                .setTicketId(12)
                .setEventId(12)
                .setCost(silverCost)
                .setNoOfSeats(silverNOS)
                .setType("silver")
                .setDiscount(90)
                .getTicket();

        Event new_event = new Event(1, org_id, eventName, description, startTime, endTime, place, platinumTicket, goldTicket, silverTicket);

        // Call a method in EventModel to add the event to the database
        new_event.save_event();

        // Optionally, you can provide feedback to the user about the success or failure of the operation
        // For example, show a confirmation message or handle exceptions if event creation fails
    }
}
