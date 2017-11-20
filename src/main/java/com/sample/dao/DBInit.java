package com.sample.dao;

import java.io.File;
import java.sql.*;

/**
 * DB Init Class
 */
public class DBInit
{
	static private Connection connection;
	static private String dbName;
	static public void init(String dbName) throws Exception{
		DBInit.dbName = dbName;
		cleanup();
		initDBConnection();
		prepareStructure();
	}
	static private void cleanup() {
		// Remove SQLite DB file
		new File("zendesk.db").delete();
	}
	static private void initDBConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
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