Zendesk task to list and view the ticket details.

Prerequisites Java (SE 1.8) Maven 3.3.1

Run the Runner.java class, user will receive the following prompt:

"Hello and welcome to the Zendesk ticket viewer!
Please type menu to view the menu, or q to quit the program: " 


user must type "menu" to display menu or "q" to quit the program

"Menu:
1: Display All Tickets
2: Display A Single Ticket
3: Quit Program
---------------------------------"
Please type a number to select a menu option (or type q to quit): 

If user enter 1, then all tickets will be displayed on the console

If user enter 2, then the following prompt will be displayed, asking for a ticket Id

"Please enter a ticket ID:"

If user enter a valid ticket id, then the corresponding ticket will be displayed on the console 

If user enter an invalid ticket id, then the following prompt will be displayed, followed by a nullPointerException

"ERROR: Ooops! Something went wrong fetching your ticket(s)."

If user enter 3, then program ends
