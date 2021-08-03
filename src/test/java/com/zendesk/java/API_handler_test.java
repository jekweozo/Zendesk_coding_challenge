package com.zendesk.java;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

class API_handler_test {

	@Test
	public void testExceptionFetchFalseTicketID(){
		Long ID = -1L;
		API_handler api = new API_handler();
		TicketResponse ticket = null;
		try {
			ticket = api.getTicketByID(ID);
			System.out.println(ticket);
			assertEquals(ticket,null);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			System.out.println("You passed!");
		}
	}
	
	@Test
	public void testFetchTicketByID(){
		String id = "1";
		Long ID = Long.valueOf(id).longValue();
		API_handler api = new API_handler();
		TicketResponse ticket = null;
		
		try {
			ticket = api.getTicketByID(ID);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		assertEquals(1, ticket.getTicket().getId());	
	}
	
	@Test
	public void testFormatRequesterIDOutput(){
		API_handler api = new API_handler();
		int requester_id = -123456;
		String str = "";
		
		str = api.formatRequesterID(requester_id);
		
		assertEquals(str, "123456");
		
	}

}
