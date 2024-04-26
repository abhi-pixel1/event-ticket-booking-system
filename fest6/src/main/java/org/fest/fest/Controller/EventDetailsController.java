package org.fest.fest.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.fest.fest.Booking;
import org.fest.fest.Ticket;

import java.util.List;
import java.util.Objects;

public class EventDetailsController {
    private List<List<String>> eventDetailsList;
    private String cust_id;
    private Ticket platimunTicket;
    private Ticket goldTicket;
    private Ticket silverTicket;


    @FXML
    private TextField no_of_tickets;

    @FXML
    private Label eventNameLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label startTimeLabel;

    @FXML
    private Label endTimeLabel;

    @FXML
    private Label placeLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label ticketTypeLabel1;

    @FXML
    private Label priceLabel1;

    @FXML
    private Label noOfSeatsLabel1;

    @FXML
    private Label ticketTypeLabel2;

    @FXML
    private Label priceLabel2;

    @FXML
    private Label noOfSeatsLabel2;

    @FXML
    private RadioButton platinum;

    @FXML
    private RadioButton gold;

    @FXML
    private RadioButton silver;

    private ToggleGroup toggleGroup;


    @FXML
    private Button submitButton;


    // Method to set the event details
    public void setCustId(String custId) {
        cust_id = custId;
    }

    // Method to set the event details
    public void setEventDetails(List<List<String>> eventDetails) {
        eventNameLabel.setText(eventDetails.get(0).get(0));
        descriptionLabel.setText(eventDetails.get(0).get(1));
        startTimeLabel.setText(eventDetails.get(0).get(2));
        endTimeLabel.setText(eventDetails.get(0).get(3));
        placeLabel.setText(eventDetails.get(0).get(4));
        dateLabel.setText(eventDetails.get(0).get(5));



        ticketTypeLabel1.setText(eventDetails.get(0).get(6));
        priceLabel1.setText(String.format("$%s", eventDetails.get(0).get(7)));
        noOfSeatsLabel1.setText(String.valueOf(eventDetails.get(0).get(8)));

        ticketTypeLabel2.setText(eventDetails.get(1).get(6));
        priceLabel2.setText(String.format("$%s", eventDetails.get(0).get(7)));
        noOfSeatsLabel2.setText(String.valueOf(eventDetails.get(1).get(8)));

//        priceLabel.setText(String.format("$%.2f", price));
//        noOfSeatsLabel.setText(String.valueOf(noOfSeats));
    }


    // Method to set the event details
    public void setTicketDetails(Ticket platimunTicket, Ticket goldTicket, Ticket silverTicket) {
        this.platimunTicket = platimunTicket;
        this.goldTicket = goldTicket;
        this.silverTicket = silverTicket;


        System.out.println("-------------------------");
        System.out.println(platimunTicket.type);
        System.out.println(goldTicket.type);
        System.out.println(silverTicket.type);
        System.out.println("-------------------------");
    }



    @FXML
    private void handleSubmit(ActionEvent event) {
        // Retrieve data from text fields and perform submit action
        toggleGroup = new ToggleGroup();

        // Add radio buttons to the toggle group
        platinum.setToggleGroup(toggleGroup);
        gold.setToggleGroup(toggleGroup);
        silver.setToggleGroup(toggleGroup);
       // String no_of_s =no_of_tickets.getText();

        // Perform action with the retrieved data
        Toggle selectedToggle = toggleGroup.getSelectedToggle();
        String selectedRadioButton = "";
        if (selectedToggle != null) {
            selectedRadioButton = ((RadioButton) selectedToggle).getText();
        }
        String numberOfTickets = no_of_tickets.getText();

        // Print the selected radio button and text field value
        System.out.println("Selected Radio Button: " + selectedRadioButton);
        System.out.println("Number of Tickets: " + numberOfTickets);

        // You can perform further actions here, such as saving the data or processing it
        if (Objects.equals(selectedRadioButton, "Platinum")){
            Booking book = new Booking(10, cust_id, platimunTicket.eventId, platimunTicket.ticketId, platimunTicket.type, Integer.parseInt(numberOfTickets));
            platimunTicket.bookTicket(book);
        }

        if (Objects.equals(selectedRadioButton, "Gold")){
            Booking book = new Booking(10, cust_id, goldTicket.eventId, goldTicket.ticketId, goldTicket.type, Integer.parseInt(numberOfTickets));
            goldTicket.bookTicket(book);
        }

        if (Objects.equals(selectedRadioButton, "Silver")){
            Booking book = new Booking(10, cust_id, silverTicket.eventId, silverTicket.ticketId, silverTicket.type, Integer.parseInt(numberOfTickets));
            silverTicket.bookTicket(book);
        }
    }

}
