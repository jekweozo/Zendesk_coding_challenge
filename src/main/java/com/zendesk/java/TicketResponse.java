package com.zendesk.java;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketResponse {

    private Ticket ticket;

    @JsonCreator
    public TicketResponse(@JsonProperty("ticket") Ticket ticket) {
        this.setTicket(ticket);
    }

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}