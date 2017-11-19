package com.sample.common;

import com.sample.dao.DBInit;
import com.sample.services.AskForInput;
import com.sample.services.JSONToDB;

/**
 * App Entry Point Class
 */
public class AppEntryPoint
{	
    public static void main( String[] args )
    {
    	try {
    		// Display welcome message
    		AskForInput askForInput = new AskForInput();
    		askForInput.showWelcomeMessage();
    		// Initialize DB connection with SQLite
    		DBInit.init();
    		// Move data from JSON files to DB
	        JSONToDB jsonToJava = new JSONToDB();
	        jsonToJava.loadJSONDataIntoDB();
	        // Ask user to start searching
	        askForInput.seekUserInput();
	    } catch ( Exception e ) {
	        e.printStackTrace();
	        //System.exit(0);
	    }
    }
}