package com.sample.dao;

public interface SQLQueries {
	final String CREATE_USERS_TABLE_QUERY = "CREATE TABLE users " +
            "(_id 		INT," +
            " url       TEXT, " + 
            " external_id		TEXT, " + 
            " name		TEXT, " + 
            " alias     TEXT," +
            " created_at 		TEXT," +
            " active    BOOLEAN, " + 
            " verified	BOOLEAN, " + 
            " shared	BOOLEAN, " + 
            " locale    TEXT," +
            " timezone 	TEXT," +
            " last_login_at		TEXT," +
            " email 	TEXT," +
            " phone     TEXT, " + 
            " signature	TEXT, " + 
            " organization_id	INT, " + 
            " tags     	TEXT," +
            " suspended BOOLEAN," +
            " role 		TEXT" +
            ")";
	final String INSERT_INTO_USERS_TABLE_QUERY = "INSERT INTO users " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
}
