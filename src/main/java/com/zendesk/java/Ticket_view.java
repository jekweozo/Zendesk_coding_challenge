package com.zendesk.java;

import java.util.List;

import org.json.JSONException;

public class Ticket_view {
	
private static int PAGE_LIMIT = 25; //max tickets to display per page
	
	public int displayTickets(TicketsResponse ticketsJSON, int pageNumber) throws JSONException{
		List<Ticket> tickets = ticketsJSON.getTickets();
		
		int ticketCount = tickets.size();
		int pageTotal = ticketCount / PAGE_LIMIT;
		
		if(pageNumber > pageTotal){
			//we've reached a page that doesn't exist
			pageNumber = 1;
		}else if(pageNumber < 1){
			//we've reached a page that doesn't exist
			pageNumber = pageTotal;
		}
		
		int ticketsOnPage = 0;
		//int offset = (pageNumber - 1)*PAGE_LIMIT;
		
		for(int i = 0; i < tickets.size(); i++){
			//check we haven't run out of tickets to display
			if(tickets.get(i).getId() == 0L){
				break;
			}
			//display the ticket information
			printTicket(tickets.get(i).getId(),
					tickets.get(i).getStatus(),
					tickets.get(i).getSubject(),
					tickets.get(i).getRequesterId(),
					tickets.get(i).getUpdatedAt());
			ticketsOnPage++;
		}
		
		System.out.println("---------------------------------");
		System.out.println("Displaying " + ticketsOnPage + " tickets on Page " + pageNumber + " of " + pageTotal
				+ " (n for next, b for prev, menu to return to menu)");
		
		
		return pageNumber;
	}
	
	public void displaySingleTicket(TicketResponse ticketJSON) throws JSONException{
		//display the ticket information
		Ticket ticket = ticketJSON.getTicket();
		printTicket(ticket.getId(), ticket.getStatus(),
				ticket.getSubject(), ticket.getRequesterId(),
				ticket.getUpdatedAt());
	}
	
	public void printTicket(Long id, String status, String subject, Long requesterID, String updatedAt){
		System.out.println("Status:[" + status + "];" +
				" Ticket "+ id + ";" +  
				" subject: '" + subject + "'" +
				" opened by " + requesterID +
				" updated " + updatedAt);
		
	}
	
	
}