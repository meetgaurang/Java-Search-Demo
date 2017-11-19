package com.sample.services;

import java.sql.SQLException;
import java.util.Scanner;

import com.sample.dao.OrganizationDAO;
import com.sample.dao.TicketDAO;
import com.sample.dao.UserDAO;

public class AskForInput {
	Scanner scanner;
	UserDAO userDAO;
	TicketDAO ticketDAO;
	OrganizationDAO organizationDAO;
	
	public void showWelcomeMessage() {
		System.out.println("\n*************************");
		System.out.println("Welcome to Zendesk Search");
		System.out.println("*************************");
		System.out.println("It may take upto 30 seconds to setup a Database at first. But we gurantee that further searches will be lightening fast! :)");
		System.out.println("\nLoading...");
	}
	public void seekUserInput() throws SQLException {
		userDAO = new UserDAO();
		ticketDAO = new TicketDAO();
		organizationDAO = new OrganizationDAO();
		scanner = new Scanner(System.in);
		
		String welcomeSearchOption = " ";
		System.out.println("\nLoading complete.");
		System.out.println("\nType 'quit' to exit at any time, Press 'Enter' to continue");
		
		while(!("").equals(welcomeSearchOption)) {
			welcomeSearchOption = scanner.nextLine();
			if (("quit").equals(welcomeSearchOption)) {
				return;
			}
		}
		seekInput();
	}
	public void seekInput() throws SQLException {
		String searchOption;
		String entityType;
		String searchTerm;
		String searchValue;
		
		System.out.println("\n\t Select Search options:");
		System.out.println("\t **********************");
		System.out.println("\t * Press 1 to search Zendesk");
		System.out.println("\t * Press 2 to view a list of searchable fields");
		System.out.println("\t * Type 'quit' to exit");
		searchOption = scanner.nextLine();

		if(("1").equals(searchOption)) {
			System.out.println("Select 1) Users or 2) Tickets or 3) Organizations");
			entityType = scanner.nextLine();
			
			System.out.println("Enter search term");
			searchTerm = scanner.nextLine();
			System.out.println("Enter search value");
			searchValue = scanner.nextLine();
			if("1".equals(entityType)) {
				userDAO.searchNDisplay(searchTerm, searchValue);
			}
			else if("2".equals(entityType)) {
				ticketDAO.searchNDisplay(searchTerm, searchValue);
			}
			else if("3".equals(entityType)) {
				organizationDAO.searchNDisplay(searchTerm, searchValue);
			}
		}
		else if(("2").equals(searchOption)) {
			// Show search options
			userDAO.displayAllColumnNames();
		}
		else if (("quit").equals(searchOption)) {
			scanner.close();
			return;
		}
		seekInput();
		scanner.close();
	}
}
