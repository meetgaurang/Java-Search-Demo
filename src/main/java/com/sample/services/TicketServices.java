package com.sample.services;

import java.sql.SQLException;

import com.sample.dao.TicketDAO;

public class TicketServices extends GenericServices{
	public TicketServices() throws SQLException {
		super();
		dao = new TicketDAO();
	}
}
