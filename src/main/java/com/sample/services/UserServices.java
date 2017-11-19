package com.sample.services;

import java.sql.SQLException;

import com.sample.dao.UserDAO;

public class UserServices extends GenericServices{
	public UserServices() throws SQLException {
		super();
		dao = new UserDAO();
	}
}
