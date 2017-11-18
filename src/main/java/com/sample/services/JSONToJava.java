package com.sample.services;
	
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.dao.UserDAO;
import com.sample.dto.UsersDO;

public class JSONToJava {
	UserDAO userDAO;
	
	public JSONToJava() throws SQLException {
		userDAO = new UserDAO();
	}
	public void loadJSONDataIntoDB() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		InputStream inputStream = JSONToJava.class.getResourceAsStream("/users.json");
		List<UsersDO> userList = objectMapper.readValue(inputStream, 
				objectMapper.getTypeFactory().constructCollectionType(
	                    List.class, UsersDO.class));
		for(UsersDO user: userList) {
			userDAO.insert(user);
		}
		System.out.println(userList.size());
		System.out.println(userList.get(0));
	}
}
