package com.sample.services;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.sample.dao.GenericDAO;

public class GenericServices {
	GenericDAO dao;
	
	public void search(String fieldName, String fieldValue) {
		int currentRecordIndex = 1;
		try {
			ResultSet resultSet = dao.search(fieldName, fieldValue);
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
		dao.displayAllColumnNames();
	}
}
