package org.fest.fest;

public class TicketBuilder {
    int ticketId;
    int eventId;
    float cost;
    int noOfSeats;
    String type;
    int discount;

    public TicketBuilder setTicketId(int ticketId) {
        this.ticketId = ticketId;
        return this;
    }

    public TicketBuilder setEventId(int eventId) {
        this.eventId = eventId;
        return this;
    }

    public TicketBuilder setCost(float cost) {
        this.cost = cost;
        return this;
    }

    public TicketBuilder setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
        return this;
    }

    public TicketBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public TicketBuilder setDiscount(int discount) {
        this.discount = discount;
        return this;
    }

    public Ticket getTicket() {
        return new Ticket(ticketId,eventId,cost,noOfSeats,type,discount);
    }
}
