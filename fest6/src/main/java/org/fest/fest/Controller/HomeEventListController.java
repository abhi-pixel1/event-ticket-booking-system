package org.fest.fest.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.fest.fest.HelloApplication;
import org.fest.fest.Model.UserModel;
import org.fest.fest.Ticket;
import org.fest.fest.TicketBuilder;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;


public class HomeEventListController {
    private UserModel userModel;
    private String cust_id;


    @FXML
    private ListView<String> eventsListView;


    // Method to set the list of events
    public void setCustId(String custId) {
        cust_id = custId;
    }



    public void initialize() {
        // Set the cell factory for the ListView
        eventsListView.setCellFactory(listView -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setOnMouseClicked(null);
                } else {
                    setText(item);
                    // Set an event listener for each item
                    setOnMouseClicked(event -> handleItemClick(item, event));
                }
            }
        });
    }


    // Method to handle item click events
    private void handleItemClick(String item, MouseEvent event) {
        userModel = new UserModel();

        try {
            System.out.println("s1 complete ");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("View/EventDetailsView.fxml"));
            Parent root = fxmlLoader.load();
            System.out.println("s2 complete ");

            List<List<String>> eventDetailsList = new ArrayList<>();
            eventDetailsList = userModel.getEventByName(item);

            Ticket platinumTicket = new TicketBuilder()
                    .setTicketId(Integer.parseInt(eventDetailsList.get(0).get(10)))
                    .setEventId(Integer.parseInt(eventDetailsList.get(0).get(9)))
                    .setCost(Float.parseFloat(eventDetailsList.get(0).get(7)))
                    .setNoOfSeats(Integer.parseInt(eventDetailsList.get(0).get(8)))
                    .setType(eventDetailsList.get(0).get(6))
                    .setDiscount(90)
                    .getTicket();

            Ticket goldTicket = new TicketBuilder()
                    .setTicketId(Integer.parseInt(eventDetailsList.get(1).get(10)))
                    .setEventId(Integer.parseInt(eventDetailsList.get(1).get(9)))
                    .setCost(Float.parseFloat(eventDetailsList.get(1).get(7)))
                    .setNoOfSeats(Integer.parseInt(eventDetailsList.get(1).get(8)))
                    .setType(eventDetailsList.get(1).get(6))
                    .setDiscount(90)
                    .getTicket();

            Ticket silverTicket = new TicketBuilder()
                    .setTicketId(Integer.parseInt(eventDetailsList.get(1).get(10)))
                    .setEventId(Integer.parseInt(eventDetailsList.get(1).get(9)))
                    .setCost(Float.parseFloat(eventDetailsList.get(1).get(7)))
                    .setNoOfSeats(Integer.parseInt(eventDetailsList.get(1).get(8)))
                    .setType(eventDetailsList.get(1).get(6))
                    .setDiscount(90)
                    .getTicket();

            System.out.println("s3 complete ");

            // Get the controller and pass the event details
            EventDetailsController controller = fxmlLoader.getController();
            controller.setEventDetails(eventDetailsList);
            controller.setTicketDetails(platinumTicket, goldTicket, silverTicket);
            controller.setCustId(cust_id);



            for (List<String> innerList : eventDetailsList) {
                for (String element : innerList) {
                    System.out.print(element + ",");
                }
                System.out.println(); // New line after each inner list
            }

            // Create a new stage and set the scene
            Stage stage = new Stage();
            stage.setTitle("Events List");
            stage.setScene(new Scene(root));
            stage.show();

        }catch (IOException e) {
            e.printStackTrace();
        }


        // Handle the item click event
        // For example, you can print the item or perform any action you want
        System.out.println("Clicked on item: " + item);
        // You can also perform additional actions here
    }




    // Method to set the list of events
    public void setEventsList(List<String> events) {
        // Convert the list to an ObservableList
        ObservableList<String> observableList = FXCollections.observableArrayList(events);

        // Set the items of the ListView
        eventsListView.setItems(observableList);
    }
}
