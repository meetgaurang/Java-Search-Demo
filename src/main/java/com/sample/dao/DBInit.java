package com.sample.dao;

import java.sql.*;

/**
 * DB Init Class
 */
public class DBInit
{
	static private Connection connection;
	static public void init() throws Exception{
		initDBConnection();
		prepareStructure();
	}
	static private void initDBConnection() throws Exception {
		Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:test.db"); 
        System.out.println("Opened database successfully");
	}
	static private void prepareStructure() throws Exception {
		Statement statement = connection.createStatement();
		statement.executeUpdate(SQLQueries.CREATE_USERS_TABLE_QUERY);
		statement.close();
	}
	static public Connection getConnection() {
		return connection;
	}
}