package com.sample.dao;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
	public void searchNDisplay(String fieldName, String fieldValue){
		String searchQuery;
		int currentRecordIndex = 1;
		if(("").equals(fieldValue)) {
			searchQuery = "select * from " + tableName +" where " + fieldName + " is null or " + fieldName + " = ''";
		}
		else {
			searchQuery = "select * from " + tableName +" where " + fieldName + "='" + fieldValue + "'";
		}
		try {
			Statement statement = DBInit.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(searchQuery);
			ResultSetMetaData metaData = resultSet.getMetaData();
			int totalColumnCount = metaData.getColumnCount();
			while(resultSet.next()) {
				int currentColumnIndex = 1;
				System.out.println("\n********* Record." + currentRecordIndex++);
				while(currentColumnIndex <= totalColumnCount) {
					System.out.println(String.format("%-18s %s" , 
							metaData.getColumnName(currentColumnIndex), 
							resultSet.getString(currentColumnIndex++)));
				}
			}
			statement.close();
		}
		catch (SQLException e) {
			System.out.println("__");
		}
		finally {
			if (currentRecordIndex == 1) {
				System.out.println("Searching users for " + fieldName + " with a value of " + fieldValue);
				System.out.println("No results found");
			}
		}
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
