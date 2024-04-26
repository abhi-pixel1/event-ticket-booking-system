package org.fest.fest;

import org.fest.fest.Model.EventCreationModel;
import org.fest.fest.Model.EventDetailsModel;

public class Ticket {
   private EventDetailsModel eventDetailsModel;
   public int ticketId;
   public int eventId;
   public float cost;
   public int noOfSeats;
   public String type;
   public int discount;

    public  Ticket(int ticketId, int eventId, float cost, int noOfSeats,String type, int discount){
        this.ticketId=ticketId;
        this.eventId=eventId;
        this.cost=cost;
        this.noOfSeats=noOfSeats;
        this.type=type;
        this.discount=discount;
        eventDetailsModel = new EventDetailsModel();
    }

    public void bookTicket(Booking book){
        System.out.println("Booking Ongoing");
        System.out.println("Event ID: " + book.event_id);
        System.out.println("No of tickets booked: " + book.no_of_tickets);

        eventDetailsModel.addSalesToDb(book);
    }

}
