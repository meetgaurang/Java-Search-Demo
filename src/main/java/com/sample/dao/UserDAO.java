package com.sample.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.dto.UsersDO;

public class UserDAO {
	PreparedStatement preparedStatement;
	public UserDAO() throws SQLException {
		preparedStatement = DBInit.getConnection().
				prepareStatement(SQLQueries.INSERT_INTO_USERS_TABLE_QUERY);		
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
}