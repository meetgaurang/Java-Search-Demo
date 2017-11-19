package com.sample.services;

import java.sql.SQLException;

import com.sample.dao.OrganizationDAO;

public class OrganizationServices extends GenericServices{
	public OrganizationServices() throws SQLException {
		super();
		dao = new OrganizationDAO();
	}
}
