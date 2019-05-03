package com.alist.qa.testcases;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import com.alist.qa.base.BaseClass;
import com.alist.qa.locators.AllContactsPage;
import com.alist.qa.locators.DashboardPage;
import com.alist.qa.locators.LoginPage;

public class AllContactsTest extends BaseClass {
	
	LoginPage loginpg;
	AllContactsPage contcts;
	DashboardPage Dashpag;
	public static Logger log = LogManager.getLogger(AllContactsTest.class);

		@BeforeClass
		public void SetUp() throws InterruptedException
		{
	
	
			log.debug("Initialising the browser");
			Initialization();
			loginpg = new LoginPage(driver);
			Pair<DashboardPage, String> p = loginpg.login(prop.getProperty("email"), prop.getProperty("password"));
			Dashpag = p.first();
			contcts = Dashpag.clickOnHamburgerToAllContacts();
		}
	
		@Test(priority = 1)
		public void checkPageTitleTest()
		{
			log.debug("Printing the Page Title");
			log.debug(contcts.verifyPageTitle());
			log.info("Printed the Page Title");
		}
	
		@Test(priority = 2)
		public void checkPageHeadingAndCountTest()
		{
			log.debug("Printing the Page Heading");
			log.debug(contcts.verifyPageHeadingAndCount());
			log.info("Printed the Page Heading");
		}

		@Test(priority = 3)
		public void checkContactColumnsTest()
		{
			List<String> columnvals = contcts.verifyColumnValues();
			log.debug("List of Column names in Contacts Page");
			log.debug(columnvals);
			log.info("Column names printed successfully");
			
		}
		
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
}
