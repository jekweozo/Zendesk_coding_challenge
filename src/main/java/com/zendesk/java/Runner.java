package com.zendesk.java;

import org.json.JSONException;

public class Runner {
	public static void main(String[] args) throws JSONException {
		Controller menu = new Controller();
		menu.runWelcomeMenu();
		
	}
}