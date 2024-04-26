package org.fest.fest;

import org.fest.fest.Model.EventCreationModel;
import org.fest.fest.Model.UserModel;

public class Event {
    private EventCreationModel eventCreationModel;
    public int event_id;
    public String org_id;
    public String event_name;
    public String description;
    public String start_time;
    public String end_time;
    public String place;
    public String location;
    public Ticket platinum_ticket;
    public Ticket gold_ticket;
    public Ticket silver_ticket;


    public Event(int event_id, String org_id, String event_name, String description, String start_time, String end_time, String place, Ticket platinum_ticket, Ticket gold_ticket, Ticket silver_ticket){
        this.event_id = event_id;
        this.org_id = org_id;
        this.event_name = event_name;
        this.description = description;
        this.start_time = start_time;
        this.end_time = end_time;
        this.place = place;

        this.platinum_ticket = platinum_ticket;
        this.gold_ticket = gold_ticket;
        this.silver_ticket = silver_ticket;
        eventCreationModel = new EventCreationModel();
    }

    public void save_event(){
        System.out.println("Saving event");
        System.out.println("Event ID: " + event_id);
        System.out.println("Organization ID: " + org_id);

        eventCreationModel.addEventToDb(event_id, org_id, event_name, description, start_time, end_time, place, platinum_ticket, gold_ticket, silver_ticket);

    }


}
