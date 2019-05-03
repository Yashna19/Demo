package com.alist.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import com.alist.qa.base.BaseClass;
import com.alist.qa.locators.DashboardPage;
import com.alist.qa.locators.LoginPage;
import com.alist.qa.locators.UserDetailsPage;
import com.alist.qa.locators.UserManagementPage;

public class UserManagementTest extends BaseClass{

	DashboardPage Dashpag;
	LoginPage loginpg;
	UserManagementPage UserManagement;
	UserDetailsPage UsrDetailPg;
	public static Logger log = LogManager.getLogger(UserManagementTest.class);
	
	
	public UserManagementTest()
	{
		super();
	}
	
	@BeforeClass
	public void SetUp() throws InterruptedException
	{
		
		
		log.debug("Initialising the browser");
		 Initialization();
		loginpg = new LoginPage(driver);
		 Pair<DashboardPage, String> p = loginpg.login(prop.getProperty("email"), prop.getProperty("password"));
		Dashpag = p.first();
		UserManagement = Dashpag.clickOnHamburgerToUserManagement();
	}
	
	@Test(priority = 1)
	public void checkPageTitleTest()
	{
		log.info(UserManagement.verifyPageTitle());
		log.info("Verified Page Title");
	}
	
	@Test(priority = 2)
	public void checkPageHeadingTest()
	{
		log.info(UserManagement.verifyPageHeading());
		log.info("Verified Page Heading");
	
	}
	
	@Test(priority = 3)
	public void checkAddUserMandatoryFieldsTest() throws InterruptedException
	{
		List<String> userfields = UserManagement.addUserMandatoryFields();
		log.info("***********ADD USER MANDATORY FIELDS*********");
		log.info(userfields);
		log.info("Printed Mandatory Fields");
	}
	
	@Test(priority = 4)
	public void checkAddUserValidationMessagesTest()
	{
		List<String> uvals = UserManagement.addUserValidationMessages();
		log.info("***********ADD USER VALIDATION MESSAGES*********");
		log.info(uvals);
		log.info("Printed Validation Messages");
	}
	
	@Test(priority = 5)
	public void checkAddUserTest() throws IOException, InterruptedException
	{
		log.debug("Entering values in the Add User window");
		UserManagement.verifyAddUser();
		log.info("Added details in Add User window");
	}
	
	@Test(priority = 6)
	public void checkDashboardUsersTest()
	{
		Pair<List<String>,List<String>> textandcount = UserManagement.checkUserDashboardDetails();
//		
			log.debug("Checking the total users text");
			Assert.assertEquals(textandcount.first().get(0), "TOTAL USERS");
			log.info("Verified total users text");
			log.debug("Checking the Active users text");
			Assert.assertEquals(textandcount.first().get(1), "ACTIVE USERS");
			log.info("Verified active users text");
			log.debug("Checking the Inactive users text");
			Assert.assertEquals(textandcount.first().get(2), "INACTIVE USERS");
			log.info("verified inactive users text");
			log.info("**** USERS COUNT****");
		log.debug("Printing the All users count");
		log.info("TOTAL USERS  " +textandcount.second().get(0));
		log.info("ACTIVE USERS  " +textandcount.second().get(1));
		log.info("INACTIVE USERS  " +textandcount.second().get(2));
		log.info("LOGGED IN USERS  " +textandcount.second().get(3));
		log.info("Printed Users count");
	}
	
	
	@Test(priority = 6)
	public void checkUserDetailsTest()
	{
		log.debug("Clicking on the user in the left block");
		UsrDetailPg = UserManagement.clickOnUser("Test Amyjohnson");
	}
	
	@AfterClass
	public void tearDown()
	{
		log.debug("Closing the Browser");
		driver.quit();
	}
	
}
