package com.sample.services;

import java.sql.SQLException;
import java.util.Scanner;

import com.sample.dao.UserDAO;

public class AskForInput {
	Scanner scanner;
	UserDAO userDAO;
	
	public AskForInput() throws SQLException {
		userDAO = new UserDAO();
		scanner = new Scanner(System.in);
	}
	public void showWelcomeMessage() {
		System.out.println("\nWelcome to Zendesk Search");
		System.out.println("Type 'quit' to exit at any time, Press 'Enter' to continue");
		
	}
	public void seekInput() throws SQLException {
		String searchOption;
		String searchTerm;
		String searchValue;
		
		System.out.println("\n\t **********************");
		System.out.println("\t Select Search options:");
		System.out.println("\t **********************");
		System.out.println("\t * Press 1 to search Zendesk");
		System.out.println("\t * Press 2 to view a list of searchable fields");
		System.out.println("\t * Type 'quit' to exit");
		searchOption = scanner.nextLine();
		//scanner.nextLine();
		if(("1").equals(searchOption)) {
			System.out.println("Enter search term");
			searchTerm = scanner.nextLine();
			System.out.println("Enter search value");
			searchValue = scanner.nextLine();
			userDAO.searchNDisplay(searchTerm, searchValue);
			seekInput();
		}
		else if (("quit").equals(searchOption)) {
			return;
		}	
		scanner.close();
	}
}
