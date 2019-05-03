package com.alist.qa.testcases;



import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import com.alist.qa.base.BaseClass;
import com.alist.qa.locators.AllClientsPage;
import com.alist.qa.locators.AllContactsPage;
import com.alist.qa.locators.AllProductsPage;
import com.alist.qa.locators.AllVendorsPage;
import com.alist.qa.locators.DashboardPage;
import com.alist.qa.locators.DataUtilityProductsPage;
import com.alist.qa.locators.FormatsPage;
import com.alist.qa.locators.LoginPage;
import com.alist.qa.locators.UserManagementPage;
import com.alist.qa.locators.UserRolesPage;

public class DashboardTest extends BaseClass{

	DashboardPage Dashpag;
	LoginPage loginpg;
	FormatsPage Formatpg;
	UserManagementPage UserManagement;
	UserRolesPage UserRoles;
	AllClientsPage AllClients;
	AllVendorsPage AllVendors;
	AllProductsPage AllProducts;
	AllContactsPage AllContacts;
	DataUtilityProductsPage DataUtilityProducts;
	
	public DashboardTest()
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
	}
	
	@Test(priority = 1)
	public void checkPageTtileTest() throws InterruptedException
	{
		
		System.out.println("***************************");
		System.out.println("**VERIFY PAGE TITLE**");
		System.out.println(Dashpag.verifyPageTitle());
		Thread.sleep(1000);
	}
	
	@Test(priority = 2)
	public void checkTextAndCountTest()
	{
		Pair<List<String>,List<String>> textandcount = Dashpag.verifyTextAndCount();
		System.out.println(textandcount.first().size());
		System.out.println(textandcount.second().size());
		
		Assert.assertEquals(textandcount.first().get(0), "TOTAL USERS");
		Assert.assertEquals(textandcount.first().get(1), "TOTAL CLIENTS");
		Assert.assertEquals(textandcount.first().get(1), "TOTAL VENDORS");
		Assert.assertEquals(textandcount.first().get(1), "TOTAL FORMATS");
	System.out.println(textandcount.second().get(0));
	System.out.println(textandcount.second().get(1));
	System.out.println(textandcount.second().get(2));
	System.out.println(textandcount.second().get(3));
	
	}
	
	//@Test(priority = 3)
	public void checkAddLinksTest() throws InterruptedException
	{
		String[] str = Dashpag.verifyAddButtons("Albertsons LLC (ALBC)");
		Assert.assertEquals(str[0], "Albertsons LLC (ALBC)");
		System.out.println(str[1]);
	}
	
	@Test(priority = 4)
	public void checkLogoTest()
	{
		Assert.assertTrue(Dashpag.verifyLogo());
	}
	
	
	
	@Test(priority = 5)
	public void clickOnUserManagementTest() throws InterruptedException
	{
		UserManagement = Dashpag.clickOnHamburgerToUserManagement();
	}
	
	
	@Test(priority = 6)
	public void clickOnUserRolesTest() throws InterruptedException
	{
		UserRoles = Dashpag.clickOnHamburgerToUserRoles();
	}
	
	@Test(priority = 7)
	public void clickOnAllClientsTest() throws InterruptedException
	{
		AllClients = Dashpag.clickOnHamburgerToAllClients();
	}
	
	@Test(priority = 8)
	public void clickOnAllVendorsTest() throws InterruptedException
	{
		AllVendors = Dashpag.clickOnHamburgerToAllVendors();
	}
	
	@Test(priority = 9 )
	public void clickOnAllFormatsTest() throws InterruptedException
	{
		Formatpg = Dashpag.clickOnHamburgerToFormats();
	}
	
	@Test(priority = 10)
	public void clickOnAllProductsTest() throws InterruptedException
	{
		AllProducts = Dashpag.clickOnHamburgerToAllProducts();
	}
	
	
	@Test(priority = 11)
	public void clickOnAllContactsTest() throws InterruptedException
	{
		AllContacts = Dashpag.clickOnHamburgerToAllContacts();
	}
	
	@Test(priority = 12)
	public void clickOnDataUtilityProductsTest() throws InterruptedException
	{
		DataUtilityProducts = Dashpag.clickOnHamburgerToDataUtilityProducts();
	}
	
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
