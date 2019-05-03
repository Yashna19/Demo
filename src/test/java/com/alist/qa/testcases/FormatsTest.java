package com.alist.qa.testcases;

import java.awt.AWTException;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import com.alist.qa.base.BaseClass;
import com.alist.qa.locators.DashboardPage;
import com.alist.qa.locators.FormatDetailsPage;
import com.alist.qa.locators.FormatsPage;
import com.alist.qa.locators.LoginPage;

public class FormatsTest extends BaseClass {

	FormatsPage Formatpg;
	LoginPage loginpg;
	DashboardPage Dashpag;
	FormatDetailsPage DetailsPg;
	
	
	public FormatsTest()
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
		Thread.sleep(1000);
		 Formatpg = Dashpag.clickOnHamburgerToFormats();
		
	}
	
	@Test(priority = 1)
	public void checkPageTitleTest() 
	{
		System.out.println(Formatpg.verifyTitle());
	}
	
	@Test(priority = 2)
	public void checkFormatMandatoryFieldsTest() throws InterruptedException 
	{
		Thread.sleep(3000);
		List<String> str = Formatpg.checkAddFormatMandatoryFields();
		System.out.println("********MANDATORY FIELDS*******");
		for(int i = 0; i<str.size(); i++)
		{
			System.out.println(str.get(i));
		}
		
	}
	
	@Test(priority = 3)
	public void checkAddFormatWindowFieldsTest() throws AWTException, InterruptedException
	{
		Thread.sleep(2000);
		Formatpg.checkAddFormatFields("24 Tab", "Format", "Format", "33.32", "Lorem ipsum");
		
		
	}
	
	@Test(priority = 4)
	public void checkAddFormatWindowValidationsTest() throws InterruptedException {
		
		List<String> string = Formatpg.checkAddFormatValidations();
		System.out.println("**** ADD FORMAT WINDOW VALIDATIONS*****");
		for(int i = 0; i<string.size(); i++)
		{
			System.out.println(string.get(i));
		}
		
	}
	
	@Test(priority = 5)
	public void checkFormatDetailsPageTest() throws InterruptedException
	{
		DetailsPg = Formatpg.goToFormatDetailsTab("4 Pg Std");
		
		
	}
	
	
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
