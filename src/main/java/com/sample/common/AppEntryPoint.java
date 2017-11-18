package com.sample.common;

import com.sample.dao.DBInit;
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
	    } catch ( Exception e ) {
	        e.printStackTrace();
	        System.exit(0);
	    }
    }
}