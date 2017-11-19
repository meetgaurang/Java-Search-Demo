package com.sample.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sample.dto.OrganizationDO;

public class OrganizationDAOTest {
	@BeforeClass
	public static void initOrganizationDAO() throws Exception{
        // Cleanup residual of previous test run, if any
		File file = new File("null");
        file.delete();    		
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
		assertEquals("Testing insertion and retrival operation", 
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
}
