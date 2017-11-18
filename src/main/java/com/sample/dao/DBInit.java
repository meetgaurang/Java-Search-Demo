package com.sample.dao;

import java.io.File;
import java.sql.*;

/**
 * DB Init Class
 */
public class DBInit
{
	static private Connection connection;
	static public void init() throws Exception{
		cleanup();
		initDBConnection();
		prepareStructure();
	}
	static private void cleanup() {
		// Remove SQLite DB file
        File file = new File("zendesk.db");
        file.delete();    		
	}
	static private void initDBConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:zendesk.db");
	}
	static private void prepareStructure() throws Exception {
		Statement statement = connection.createStatement();
		statement.executeUpdate(SQLQueries.CREATE_USERS_TABLE_QUERY);
		statement.executeUpdate(SQLQueries.CREATE_TICKETS_TABLE_QUERY);
		statement.executeUpdate(SQLQueries.CREATE_ORGANIZATIONS_TABLE_QUERY);
		statement.close();
	}
	static public Connection getConnection() {
		return connection;
	}
}