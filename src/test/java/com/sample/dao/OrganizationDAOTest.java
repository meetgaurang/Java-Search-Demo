package com.sample.dao;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sample.dto.OrganizationDO;
import com.sample.dto.TicketsDO;
import com.sample.services.JSONToDBServices;

public class OrganizationDAOTest {
	@BeforeClass
	public static void initOrganizationDAO() throws Exception{
        // Cleanup residual of previous test run, if any
		new File("zendesktest.db").delete();    		
        // Initialize Test DB
		DBInit.init("zendesktest.db");			
	}
	@Test
	public void testInsert() throws Exception{
		OrganizationDAO organizationDAO = new OrganizationDAO();
		// Initialize object to be inserted
		OrganizationDO sampleOrganizationDO = initOrganizationDO();
		// Insert operation
		organizationDAO.insert(sampleOrganizationDO);
		// Retrieve record and verify its integrity
		ResultSet resultSet = organizationDAO.search("name", "Heer");
		resultSet.next();
		assertEquals("Testing SQL insertion and retrival operation of an entity", 
				resultSet.getString("url"), "http://test.com");
	}	
	private static OrganizationDO initOrganizationDO() {
		// Initialize Test object with some random values
		OrganizationDO organizationDO = new OrganizationDO();
		organizationDO.set_id(1001);
		organizationDO.setUrl("http://test.com");
		organizationDO.setExternalId("9270ed79-35eb-4a38-a46f-35725197ea8d");
		organizationDO.setName("Heer");
		ArrayList<String> domainNames = new ArrayList<String>();
		domainNames.add("domain1");
		domainNames.add("domain2");
		domainNames.add("domain3");
		organizationDO.setDomainNames(domainNames);
		organizationDO.setCreatedAt("2016-05-21T11:10:28 -10:00");
		organizationDO.setDetails("Non profit");
		organizationDO.setSharedTickets(false);
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("tag1");
		tags.add("tag2");
		tags.add("tag3");
		organizationDO.setTags(tags);
		return organizationDO;
	}
	@Test
	public void testJSONLoadingFunctionality() throws Exception {
		JSONToDBServices jsonToDBServices = new JSONToDBServices();
		List<OrganizationDO> organizationList = jsonToDBServices.convertJSONFileToInMemoryObject("organizations-test-1.json", OrganizationDO.class);
		assertEquals("JSON File Read Test: 1. Test the size of an retrieved list", 
				organizationList.size(), 2);
		assertEquals("JSON File Read Test: 2. Test the integrity of a retrieved element", 
				organizationList.get(0).getName(), "Child Welfare Society");
	}
}
