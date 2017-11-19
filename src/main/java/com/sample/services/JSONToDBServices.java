package com.sample.services;
	
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	public JSONToDBServices() throws SQLException {
		userDAO = new UserDAO();
		ticketDAO = new TicketDAO();
		organizationDAO = new OrganizationDAO();
	}
	public void loadJSONDataIntoDB() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		InputStream userInputStream = JSONToDBServices.class.getResourceAsStream("/users.json");
		List<UsersDO> userList = objectMapper.readValue(userInputStream, 
				objectMapper.getTypeFactory().constructCollectionType(
	                    List.class, UsersDO.class));
		for(UsersDO user: userList) {
			userDAO.insert(user);
		}
		userInputStream.close();
		
		InputStream ticketInputStream = JSONToDBServices.class.getResourceAsStream("/tickets.json");
		List<TicketsDO> ticketList = objectMapper.readValue(ticketInputStream, 
				objectMapper.getTypeFactory().constructCollectionType(
	                    List.class, TicketsDO.class));
		for(TicketsDO ticket: ticketList) {
			ticketDAO.insert(ticket);
		}
		ticketInputStream.close();
		
		InputStream organizationInputStream = JSONToDBServices.class.getResourceAsStream("/organizations.json");
		List<OrganizationDO> organizationList = objectMapper.readValue(organizationInputStream, 
				objectMapper.getTypeFactory().constructCollectionType(
	                    List.class, OrganizationDO.class));
		for(OrganizationDO organization: organizationList) {
			organizationDAO.insert(organization);
		}
		organizationInputStream.close();
	}
}
