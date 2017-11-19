package com.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.dto.TicketsDO;

public class TicketDAO extends GenericDAO{
	public TicketDAO() throws SQLException {
		super(SQLQueries.INSERT_INTO_TICKETS_TABLE_QUERY);
		tableName = "tickets";
	}
	public void insert(TicketsDO ticketDO) throws SQLException {
		preparedStatement.setString(1, ticketDO.get_id());
		preparedStatement.setString(2, ticketDO.getUrl());
		preparedStatement.setString(3, ticketDO.getExternalId());
		preparedStatement.setString(4, ticketDO.getCreatedAt());
		preparedStatement.setString(5, ticketDO.getType());
		preparedStatement.setString(6, ticketDO.getSubject());
		preparedStatement.setString(7, ticketDO.getDescription());
		preparedStatement.setString(8, ticketDO.getPriority());
		preparedStatement.setString(9, ticketDO.getStatus());
		preparedStatement.setInt(10, ticketDO.getSubmitterId());
		preparedStatement.setInt(11, ticketDO.getAsigneeId());
		preparedStatement.setInt(12, ticketDO.getOrganizationId());
		preparedStatement.setString(13, ticketDO.getTags().toString());
		preparedStatement.setBoolean(14, ticketDO.getHasIncidents());
		preparedStatement.setString(15, ticketDO.getDueAt());
		preparedStatement.setString(16, ticketDO.getVia());
		preparedStatement.executeUpdate();
	}
	@Override
	public ResultSet search(String fieldName, String fieldValue) throws SQLException {
		// TODO Auto-generated method stub
		return super.search(fieldName, fieldValue);
	}
}
