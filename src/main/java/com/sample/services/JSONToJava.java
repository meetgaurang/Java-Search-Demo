package com.sample.services;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.dto.UsersDO;

public class JSONToJava {
	public static void main(String args[]) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		// File file = new File("student.json");
		InputStream inputStream = JSONToJava.class.getResourceAsStream("/users.json");
		List<UsersDO> userList = objectMapper.readValue(inputStream, 
				objectMapper.getTypeFactory().constructCollectionType(
	                    List.class, UsersDO.class));
		System.out.println(userList.size());
		System.out.println(userList.get(0));
	}
}
