package com.zendesk.java;

import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;
public class Controller {

	Main_view view = new Main_view();
	private Scanner sc;
	// MenuController menu = new MenuController();

	public String getInput() {
		sc = new Scanner(System.in);
		String input = "";
		input = sc.next();
		return input;
	}

	public void runMainMenu() throws JSONException {

		String input = "";

		while (true) {

			// display the menu and receive input
			view.printMainMenu();
			input = getInput();

			// check input and act accordingly
			if (input.contains("1")) { // Display All Tickets
				displayAllTickets();
			} else if (input.contains("2")) { // Display A Single Ticket
				displaySingleTicket();
			} else if (input.contains("3") || input.contains("q")) { // Quit Program
				view.quit();
				return;
			} else {
				view.unrecognizedInput();
			}

			// clear previous input
			input = "";
		}

	}

	public void runWelcomeMenu() throws JSONException {
		Main_view view = new Main_view();
		// MenuController menu = new MenuController();
		String input = "";

		view.printWelcome();
		input = getInput();

		while (true) {
			if (input.contains("menu")) {
				runMainMenu();
				return;

			} else if (input.contains("q")) {
				view.quit();
				return;
			} else {
				view.unrecognizedInput();
			}

			// clear previous input
			input = "";
			input = getInput();
		}

	}

	public void displayAllTickets() throws JSONException {
		API_handler api = new API_handler(); // connect to api
		Ticket_view ticketV = new Ticket_view();
		String input = "";
		int pageNumber = 1;
		TicketsResponse ticketsJSON = null;

		try {
			ticketsJSON = api.getTickets(); // get the tickets
		} catch (Exception e) {
			System.out.println("ERROR: Could not successfully get your tickets.");
			return;
		}
		pageNumber = ticketV.displayTickets(ticketsJSON, pageNumber); // display current ticket page

		while (true) {
			input = getInput();

			if (input.contains("q") || input.contains("menu")) {
				break; // return to menu
			} else if (input.contains("n")) {
				pageNumber++;
				pageNumber = ticketV.displayTickets(ticketsJSON, pageNumber); // display next ticket page
			} else if (input.contains("b")) {
				pageNumber--;
				pageNumber = ticketV.displayTickets(ticketsJSON, pageNumber); // display previous ticket page
			} else {
				view.invalidPageCommand();
				// api.displayTickets(ticketsJSON, offset); //display current ticket page
			}
			input = "";
		}
		return;
	}

	public void displaySingleTicket() throws JSONException {
		String id = "";
		TicketResponse ticketsJSON = null;
		Ticket_view ticketV = new Ticket_view();

		view.askTicketID();
		id = getInput();

		API_handler api = new API_handler(); // connect to api
		try {
			Long input = Long.valueOf(id).longValue();
			ticketsJSON = api.getTicketByID(input); // get the ticket
		} catch (Exception e) {
			System.out.println("ERROR: Could not find ticket " + id + ". Please check the ID and try again.");
			return;
		}

		ticketV.displaySingleTicket(ticketsJSON); // display the ticket

		return;
	}

}