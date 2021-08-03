package com.zendesk.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;



/*
 * The APIHandler does as the name suggests, it handles connecting
 * to the Zendesk servers, fetching ticket information, as well as
 * formatting the data.
 */
public class API_handler {
	//a date format to follow
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
	private Scanner sc;


	//Get ALL the tickets
	public TicketsResponse getTickets() throws JSONException{
		//connect to API and get the tickets in JSON format
		System.out.println("SYSTEM STATUS: Fetching Ticket(s), please wait...");
		InputStream ticketsJSON;
		TicketsResponse ticketsResponse = null;  // initialize variable
		boolean multi = true;
		
		//get tickets JSON
		ticketsJSON = connectToAPI(multi, 0L);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			ticketsResponse = mapper.readerFor(TicketsResponse.class).readValue(ticketsJSON);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return the formatted tickets
		return ticketsResponse;
	}
	
	//Get a SINGULAR ticket by ID
	public TicketResponse getTicketByID(Long ticketID) throws JSONException{
		//connect to API and get the individual ticket
		System.out.println("SYSTEM STATUS: Fetching Ticket " + ticketID + ", please wait...");
		InputStream ticketJSON;
		TicketResponse ticketResponse = null;  // initialize ticket response
		boolean multi = false;
		
		//get tickets JSON
		ticketJSON = connectToAPI(multi, ticketID);
		if(ticketJSON == null) {
			return null;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			ticketResponse = mapper.readerFor(TicketResponse.class).readValue(ticketJSON);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//return the formatted tickets
		return ticketResponse;
	}
	
	//connect to the API and handle API issues
	public InputStream connectToAPI(boolean multi, Long id) {
		
		//connection information
		String subdomain = "zccstudentticketviewerhelp";
		String email_address = "jesseekweozoh@gmail.com";
		String password = "@Complan123";
		String stringURL = "";
		if(multi == true){
			stringURL = "https://"+ subdomain +".zendesk.com/api/v2/tickets.json?page[size]=25";
		}else if(multi == false){
			stringURL = "https://"+ subdomain +".zendesk.com/api/v2/tickets/"+ id+".json" ;
			
		}
		
		String basicAuth = "";
		InputStream inputStream;
		//connecting
		URL url;
		try {
			//initialize url and connection object
			url = new URL(stringURL);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();  // cast url connection
			//urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:221.0) Gecko/20100101 Firefox/31.0");
			//encode authentication details
			basicAuth = basicAuthentication(email_address, password);
			
			//set authentication details
			urlConnection.setRequestProperty ("Authorization", "Basic " + basicAuth);
		
			//connect to the URL with authorization
			urlConnection.connect();
			//get the data as an InputStream
			inputStream = urlConnection.getInputStream();
			//System.out.println("this is where I've failed :(");
			
		} catch (MalformedURLException e) {
			System.out.println("ERROR: Failed connection. Malformed URL.");
			return null;
			
		} catch (Exception e) {
			System.out.println("ERROR: Ooops! Something went wrong fetching your ticket(s).");
			return null;
		}
		
		//return JSON
		return inputStream;
	}
	
	//encode the user details with basic authentication
	public String basicAuthentication(String email_address, String password){		
		//authenticating administration details
		String userAuthentication = email_address + ":" + password;
		//basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userAuthentication.getBytes());
		return Base64.getEncoder().encodeToString(userAuthentication.getBytes());
	}
	
	//format the JSON
	public JSONObject formatMultiJSON(JSONObject ticketsJSON) throws JSONException{
		//format the tickets into a display-able format
		JSONArray ticketsArr = new JSONArray();
		ticketsArr = ticketsJSON.getJSONArray("tickets");
		int fetchedID = -1;
		String formattedID = "";
		
		//DateFormat format = new SimpleDateFormat("YYYY'-'MM'-'dd'T'HH':'mm':'ss'Z'", Locale.ENGLISH);
		Date date = new Date();
		String dateStr = "";
		
		//go over each JSON array object and get data
		for(int i = 0; i < ticketsArr.length(); i++){			
			//format the date of the ticket for display
			try {
				date = dateFormat.parse(ticketsArr.getJSONObject(i).getString("updated_at"));
				dateStr = date.toString();
			} catch (ParseException e) {
				System.out.println("ERROR: There was an issue regarding the last updated date on one of the tickets. Skipping Ticket...");
				continue;
			}
			
			//format requester_id
			fetchedID = ticketsArr.getJSONObject(i).getInt("requester_id");
			formattedID = formatRequesterID(fetchedID);
			
			//set formatted data in JSON Object
			ticketsJSON.getJSONArray("tickets").getJSONObject(i).put("requester_id", formattedID);
			ticketsJSON.getJSONArray("tickets").getJSONObject(i).put("updated_at", dateStr);
		
		}
		return ticketsJSON;
	}
	
	public JSONObject formatSingleJSON(JSONObject ticketsJSON) throws JSONException{
		//format the tickets into a display-able format
		JSONObject ticket = new JSONObject();
		ticket = ticketsJSON.getJSONObject("ticket");   // get value of ticket by it's key
		
		int fetchedID = -1;
		String formattedID = "";
		
		//DateFormat format = new SimpleDateFormat("YYYY-MM-DD'T'mm:ss:SS'Z'", Locale.ENGLISH);
		Date date = new Date();
		String dateStr = "";
	
		//format the date of the ticket for display
		try {
			date = dateFormat.parse(ticket.getString("updated_at"));
			dateStr = date.toString();
		} catch (ParseException e) {
			System.out.println("ERROR: There was an issue regarding the last updated date on one of the tickets. Date may not appear correctly.");
			return null;
		}
		
		//format requester_id
		fetchedID = ticket.getInt("requester_id");
		formattedID = formatRequesterID(fetchedID);
		
		//set formatted data in JSON Object
		ticket.put("requester_id", formattedID);
		ticket.put("updated_at", dateStr);
		
		return ticket;
	}
	
	
	public String formatRequesterID(int requesterID){
		String strReqID = "";
		strReqID = Integer.toString(requesterID);
		strReqID = strReqID.replace("-", "");
		return strReqID;
		
	}


}