package com.zendesk.java;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TicketsResponse {

    public static final TicketsResponse FAIL = new TicketsResponse(null, null, null);

    private List<Ticket> tickets;
    private Meta meta;
    private Links links;

    public TicketsResponse() {}

    public TicketsResponse(
            @JsonProperty("tickets") List<Ticket> tickets,
            @JsonProperty("meta") Meta meta,
            @JsonProperty("links") Links links
    ) {
        this.setTickets(tickets);
        this.setMeta(meta);
        this.setLinks(links);
    }

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}
}
