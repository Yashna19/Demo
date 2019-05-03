package com.alist.qa.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserDetailsPage {
	
	WebDriver driver;
	
	
	
	
	public UserDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
         PageFactory.initElements(driver, this);
	}
	
	
	public void checkUploadImage()
	{
		
	}
	
	

}
