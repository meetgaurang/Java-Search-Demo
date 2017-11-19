package com.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.dto.UsersDO;

public class UserDAO extends GenericDAO{
	public UserDAO() throws SQLException {
		super(SQLQueries.INSERT_INTO_USERS_TABLE_QUERY);
		tableName = "users";
	}	
	public void insert(UsersDO userDO) throws SQLException {
		preparedStatement.setInt(1, userDO.get_id());
		preparedStatement.setString(2, userDO.getUrl());
		preparedStatement.setString(3, userDO.getExternalId());
		preparedStatement.setString(4, userDO.getName());
		preparedStatement.setString(5, userDO.getAlias());
		preparedStatement.setString(6, userDO.getCreatedAt());
		preparedStatement.setBoolean(7, userDO.getActive());
		preparedStatement.setBoolean(8, userDO.getVerified());
		preparedStatement.setBoolean(9, userDO.getShared());
		preparedStatement.setString(10, userDO.getLocale());
		preparedStatement.setString(11, userDO.getTimeZone());
		preparedStatement.setString(12, userDO.getLastLoginAt());
		preparedStatement.setString(13, userDO.getEmail());
		preparedStatement.setString(14, userDO.getPhone());
		preparedStatement.setString(15, userDO.getSignature());
		preparedStatement.setInt(16, userDO.getOrganizationId());
		preparedStatement.setString(17, userDO.getTags().toString());
		preparedStatement.setBoolean(18, userDO.getSuspended());
		preparedStatement.setString(19, userDO.getRole());
		preparedStatement.executeUpdate();
	}
	@Override
	public ResultSet search(String fieldName, String fieldValue) throws SQLException {
		// TODO Auto-generated method stub
		return super.search(fieldName, fieldValue);
	}
}
