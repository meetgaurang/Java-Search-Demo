package com.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.dto.OrganizationDO;

public class OrganizationDAO extends GenericDAO {
	public OrganizationDAO() throws SQLException {
		super(SQLQueries.INSERT_INTO_ORGANIZATIONS_TABLE_QUERY);
		tableName = "organizations";
	}
	public void insert(OrganizationDO organizationDO) throws SQLException {
		preparedStatement.setInt(1, organizationDO.get_id());
		preparedStatement.setString(2, organizationDO.getUrl());
		preparedStatement.setString(3, organizationDO.getExternalId());
		preparedStatement.setString(4, organizationDO.getName());
		preparedStatement.setString(5, organizationDO.getDomainNames().toString());
		preparedStatement.setString(6, organizationDO.getCreatedAt());
		preparedStatement.setString(7, organizationDO.getDetails());
		preparedStatement.setBoolean(8, organizationDO.getSharedTickets());
		preparedStatement.setString(9, organizationDO.getTags().toString());
		preparedStatement.executeUpdate();
	}
	@Override
	public ResultSet search(String fieldName, String fieldValue) throws SQLException {
		// TODO Auto-generated method stub
		return super.search(fieldName, fieldValue);
	}
}
