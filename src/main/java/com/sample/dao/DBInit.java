package com.sample.dao;

import java.sql.*;

/**
 * DB Init Class
 */
public class DBInit
{
	static private Connection c;
	static private Statement statement;
	static private void init() {
		try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");         
            System.out.println("Opened database successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
	}	
	static public Connection getConnection() {
		if(c == null) {
			init();
		}
		return c;
	}
	static public Statement getStatement() {
		try {
			return getConnection().createStatement();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
            return null;
        }
	}
}