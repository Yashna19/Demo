package com.alist.qa.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserDetailsPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath = "//*[@class = 'file-drop-zone']/input")
	WebElement userimage;
	
	@FindBy(name = "firstName")
	WebElement fname;
	
	public UserDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
         PageFactory.initElements(driver, this);
	}
	
	
	public void checkUploadImage() throws InterruptedException
	{
		//userimage.click();
		Thread.sleep(2000);
		String filepath = "//home//enterpi//Downloads//image.png";
		userimage.sendKeys(filepath);
		Thread.sleep(4000);
		fname.clear();
		
	}
	
	

}
