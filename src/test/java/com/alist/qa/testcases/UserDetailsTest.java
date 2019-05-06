package com.alist.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import com.alist.qa.base.BaseClass;
import com.alist.qa.locators.DashboardPage;
import com.alist.qa.locators.LoginPage;
import com.alist.qa.locators.UserDetailsPage;
import com.alist.qa.locators.UserManagementPage;

public class UserDetailsTest extends BaseClass{

	LoginPage loginpg;
	DashboardPage Dashpag;
	UserManagementPage UserManagement;
	UserDetailsPage UsrDetailPg;
	
	
	public UserDetailsTest()
	{
		super();
	}
	
	@BeforeClass
	public void SetUp() throws InterruptedException
	{
		 Initialization();
		loginpg = new LoginPage(driver);
		 Pair<DashboardPage, String> p = loginpg.login(prop.getProperty("email"), prop.getProperty("password"));
		Dashpag = p.first();
		UserManagement = Dashpag.clickOnHamburgerToUserManagement();
		UsrDetailPg = UserManagement.clickOnUser("Test Amyjohnson");
	}
	
	@Test(priority = 1)
	public void checkFileUploadTest() throws InterruptedException
	{
		UsrDetailPg.checkUploadImage();
	}
	
	
	@AfterClass 
	public void tearDown()
	{
		driver.quit();
	}
}
