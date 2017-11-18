package com.sample.common;

import com.sample.dao.DBInit;
import com.sample.services.AskForInput;
import com.sample.services.JSONToJava;

/**
 * App Entry Point Class
 */
public class AppEntryPoint
{	
    public static void main( String[] args )
    {
    	try {
    		DBInit.init();
	        JSONToJava jsonToJava = new JSONToJava();
	        jsonToJava.loadJSONDataIntoDB();
	        
	        AskForInput askForInput = new AskForInput();
	        askForInput.showWelcomeMessage();
	        askForInput.seekInput();
	    } catch ( Exception e ) {
	        e.printStackTrace();
	        System.exit(0);
	    }
    }
}