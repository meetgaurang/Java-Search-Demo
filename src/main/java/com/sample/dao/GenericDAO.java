package com.sample.dao;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenericDAO {
	PreparedStatement preparedStatement;
	String tableName;
	String searchQuery;
	DatabaseMetaData dbMetaData;
	
	public GenericDAO(String queryString) throws SQLException {
		preparedStatement = DBInit.getConnection().prepareStatement(queryString);
		dbMetaData = DBInit.getConnection().getMetaData();
	}
	public ResultSet search(String fieldName, String fieldValue) throws SQLException{
		String searchQuery;
		if(("").equals(fieldValue)) {
			searchQuery = "select * from " + tableName +" where " + fieldName + " is null or " + fieldName + " = ''";
		}
		else {
			searchQuery = "select * from " + tableName +" where " + fieldName + "='" + fieldValue + "'";
		}
		Statement statement = DBInit.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery);
		return resultSet;
	}
	
	public void displayAllColumnNames() throws SQLException {
		displayColumnNames("users");
		displayColumnNames("tickets");
		displayColumnNames("organizations");
	}
	private void displayColumnNames(String tableName) throws SQLException {
		ResultSet columns = dbMetaData.getColumns(null, null, tableName, null);
		System.out.println("\n--------------------------------------");
		System.out.println("Search " + tableName + " with ");
		while (columns.next()) {
			System.out.println(columns.getString("COLUMN_NAME"));
		}
	}
}
