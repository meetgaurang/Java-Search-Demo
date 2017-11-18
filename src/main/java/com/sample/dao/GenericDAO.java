package com.sample.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class GenericDAO {
	PreparedStatement preparedStatement;
	String tableName;
	String searchQuery;
	
	public GenericDAO(String queryString) throws SQLException {
		preparedStatement = DBInit.getConnection().prepareStatement(queryString);	
	}
	public void searchNDisplay(String fieldName, String fieldValue) throws SQLException {
		String searchQuery = "select * from " + tableName +" where " + fieldName + "='" + fieldValue + "'";
		Statement statement = DBInit.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(searchQuery);
		ResultSetMetaData metaData = resultSet.getMetaData();
		int totalColumnCount = metaData.getColumnCount();
		int currentRecordIndex = 1;
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
}
