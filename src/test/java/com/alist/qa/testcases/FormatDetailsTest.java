package com.alist.qa.testcases;



import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import com.alist.qa.base.BaseClass;
import com.alist.qa.locators.DashboardPage;
import com.alist.qa.locators.FormatDetailsPage;
import com.alist.qa.locators.FormatPagesTabPage;
import com.alist.qa.locators.FormatsPage;
import com.alist.qa.locators.LoginPage;

public class FormatDetailsTest extends BaseClass{
	
	FormatsPage Formatpg;
	LoginPage loginpg;
	DashboardPage Dashpag;
	FormatDetailsPage DetailsPg;
	FormatPagesTabPage PagesTb;
	
	public FormatDetailsTest()
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
		 DetailsPg =  Formatpg.goToFormatDetailsTab("4 Pg Std");
		 
		
	}
	
	@Test(priority = 1)
	public void checkFormatNameTest()
	{
		System.out.println(DetailsPg.getFormatName());
		//Assert.assertEquals(DetailsPg.getFormatName(), "4 Pg");
		
	}
	
	@Test(priority = 2)
	public void checkMandatoryFieldsTest() throws InterruptedException
	{
		List<String> mandatory =  DetailsPg.checkMandatoryFieldsInDetailsPage();
		for ( int i = 0; i<mandatory.size(); i++)
		{
			System.out.println(mandatory.get(i));
		}
	}
	
	@Test(priority = 3)
	public void checkEditFormatDetailsTest() throws InterruptedException
	{
		
		Boolean[] cancel = DetailsPg.editFormatDetails();
		System.out.println("******STATUS OF CANCEL BUTTON*****");
		System.out.println("Cancel button status before editing:" +cancel[0]);
		System.out.println("Cancel button status after editing:" +cancel[1]);
		
		
	}
	
	@Test(priority = 4)
	public void formatDetailsValidationsTest() throws InterruptedException
	{
		List<String> val=  DetailsPg.checkFieldValidationMessages();
		System.out.println("******VALIDATION MESSAGES IN FORMAT DETAILS PAGE*******");
		for ( int i = 0; i<val.size(); i++)
		{
			System.out.println(val.get(i));
		}
	}
	
	public void checkFormatPagesTabTest()
	{
		PagesTb = DetailsPg.clickOnPagesTab();
	}
	
	
	
	
	
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

}
