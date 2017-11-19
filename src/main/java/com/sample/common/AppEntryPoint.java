package com.sample.common;

import com.sample.dao.DBInit;
import com.sample.services.HandleUserInputServices;
import com.sample.services.JSONToDBServices;

/**
 * App Entry Point Class
 */
public class AppEntryPoint
{	
    public static void main( String[] args )
    {
    	try {
    		// Display welcome message
    		HandleUserInputServices handleUserInputServices = new HandleUserInputServices();
    		handleUserInputServices.showWelcomeMessage();
    		// Initialize DB connection with SQLite
    		DBInit.init();
    		// Move data from JSON files to DB
	        JSONToDBServices jsonToJava = new JSONToDBServices();
	        jsonToJava.loadJSONDataIntoDB();
	        // Ask user to start searching
	        handleUserInputServices.seekUserInput();
	    } catch ( Exception e ) {
	        e.printStackTrace();
	        //System.exit(0);
	    }
    }
}