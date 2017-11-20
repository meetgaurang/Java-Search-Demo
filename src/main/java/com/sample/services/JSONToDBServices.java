package com.sample.services;
	
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.dao.GenericDAO;
import com.sample.dao.OrganizationDAO;
import com.sample.dao.TicketDAO;
import com.sample.dao.UserDAO;
import com.sample.dto.OrganizationDO;
import com.sample.dto.TicketsDO;
import com.sample.dto.UsersDO;

public class JSONToDBServices {
	UserDAO userDAO;
	TicketDAO ticketDAO;
	OrganizationDAO organizationDAO;
	GenericDAO genericDAO;
	ObjectMapper objectMapper;
	
	public JSONToDBServices() throws SQLException {
		userDAO = new UserDAO();
		ticketDAO = new TicketDAO();
		organizationDAO = new OrganizationDAO();
		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	public void loadJSONDataIntoDB() throws Exception {
		List<UsersDO> userList = convertJSONFileToInMemoryObject("users.json", UsersDO.class);
		for(UsersDO user: userList) {
			userDAO.insert(user);
		}
		List<TicketsDO> ticketList = convertJSONFileToInMemoryObject("tickets.json", TicketsDO.class);
		for(TicketsDO ticket: ticketList) {
			ticketDAO.insert(ticket);
		}
		List<OrganizationDO> organizationList = convertJSONFileToInMemoryObject("organizations.json", OrganizationDO.class);
		for(OrganizationDO organization: organizationList) {
			organizationDAO.insert(organization);
		}
	}
	public List convertJSONFileToInMemoryObject(String fileName, Class classType) throws Exception {
		InputStream inputStream = JSONToDBServices.class.getResourceAsStream("/" + fileName);
		List list = objectMapper.readValue(inputStream, 
				objectMapper.getTypeFactory().constructCollectionType(
	                    List.class, classType));
		inputStream.close();
		return list;
	}
}
