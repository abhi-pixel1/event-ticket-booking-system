package org.fest.fest;

public class Booking {
    public int sale_id;
    public String cust_id;
    public int event_id;
    public int ticket_id;
    public String ticket_type;
    public int no_of_tickets;

    public Booking(int sale_id, String cust_id, int event_id, int ticket_id, String ticket_type, int no_of_tickets) {
        this.sale_id = sale_id;
        this.cust_id = cust_id;
        this.event_id = event_id;
        this.ticket_id = ticket_id;
        this.ticket_type = ticket_type;
        this.no_of_tickets = no_of_tickets;
    }
}
