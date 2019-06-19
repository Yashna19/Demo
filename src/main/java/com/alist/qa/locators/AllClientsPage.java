package com.alist.qa.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AllClientsPage {
	
	
WebDriver driver;
	
	
	
	public AllClientsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
         PageFactory.initElements(driver, this);
	}
	
	
	
	
}
