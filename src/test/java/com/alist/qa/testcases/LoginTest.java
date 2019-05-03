package com.alist.qa.testcases;

import org.testng.internal.collections.Pair;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.alist.qa.base.BaseClass;
import com.alist.qa.locators.DashboardPage;
import com.alist.qa.locators.LoginPage;


public class LoginTest extends BaseClass{
	
	LoginPage loginpg;
	DashboardPage Dashpag;
	String messagetext;
	
	public LoginTest(){
		super();
	}
	
	@BeforeClass
	public void SetUp() throws InterruptedException
	{
		 Initialization();
		loginpg = new LoginPage(driver);
		Thread.sleep(1000);
	}
	

	@Test(priority = 1)
	public void validationsTest() throws InterruptedException
	{
		
		System.out.println("***************************");
		System.out.println("**Sign In without entering values in Username and Password fields**");
		String[] str = loginpg.invalidLogin();
		System.out.println(str[0]);
		System.out.println(str[1]);
	}
	
	
	@Test(priority = 2)
	public void invalidUsernameTest() 
	{
		Pair<DashboardPage, String> p = loginpg.login(prop.getProperty("iemail"), prop.getProperty("ipassword"));
		messagetext = p.second();
		System.out.println("***************************");
		System.out.println("**Sign In with Invalid Username/Password values**");
		System.out.println(messagetext);
		
	}
	
	
	@Test(priority = 3)
	public void validLoginTest() 
	{
		System.out.println("***************************");
		System.out.println("**Sign In with valid details**");
		Pair<DashboardPage, String> p = loginpg.login(prop.getProperty("email"), prop.getProperty("password"));
		Dashpag = p.first();
		
		
	}

//	@Test(priority = 4)
//	public void ReadExcel() throws IOException
//	{
//		ReadDataFromExcel ex = new ReadDataFromExcel();
//		ArrayList<String> data = ex.ReadData("//home//enterpi//Desktop//eclipse-workspace//A-List//src//test//resources//com//qa//alist//testdata//TestData.xlsx", "TestData.xlsx", "Login Data", "Format Name", "13 Tab");
//		System.out.println(data);
//		
//	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}


