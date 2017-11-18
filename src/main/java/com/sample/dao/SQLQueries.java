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
	
	final String CREATE_TICKETS_TABLE_QUERY = "CREATE TABLE tickets " +
            "(_id 		TEXT," +
            " url       TEXT, " + 
            " external_id	TEXT, " + 
            " created_at	TEXT," +
            " type    	TEXT, " + 
            " subject	TEXT, " + 
            " description	TEXT, " + 
            " priority  TEXT," +
            " status 	TEXT," +
            " submitter_id	INT," +
            " assignee_id	INT," +
            " organization_id	INT," +
            " tags     	TEXT," +
            " has_incidents		BOOLEAN," +
            " due_at    TEXT, " + 
            " via		TEXT " +
            ")";
	final String INSERT_INTO_TICKETS_TABLE_QUERY = "INSERT INTO tickets " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	final String CREATE_ORGANIZATIONS_TABLE_QUERY = "CREATE TABLE organizations " +
            "(_id 		INT," +
            " url       TEXT, " + 
            " external_id	TEXT, " + 
            " name		TEXT," +
            " domain_names	TEXT, " + 
            " created_at	TEXT, " + 
            " details	TEXT, " + 
            " shared_tickets	BOOLEAN," +
            " tags 		TEXT" +
            ")";
	final String INSERT_INTO_ORGANIZATIONS_TABLE_QUERY = "INSERT INTO organizations " +
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
