package com.alist.qa.locators;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.alist.qa.base.BaseClass;


public class AllContactsPage extends BaseClass {

	WebDriver driver;
	public static Logger log = LogManager.getLogger(AllContactsPage.class);
	
	
	
	@FindBy(xpath = "//*[@class = 'aims-container d-flex align-items-center justify-content-between']//h1")
	WebElement pageheading;
	
	@FindBy(xpath = "//*[@class = 'ag-header-cell ag-header-cell-sortable']/div/div/span[1]")
	List<WebElement> columnnames;
	
	@FindBy(xpath = "//*[@class = 'ag-header-cell ag-header-cell-sortable']/div/div/span[1]")
	List<WebElement> columnnames1;
	
	
		public AllContactsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
         PageFactory.initElements(driver, this);
	}
		
		
		public String  verifyPageTitle()
		{
			return driver.getTitle();
		}
		
		public String verifyPageHeadingAndCount()
		{
			return pageheading.getText();
		}
		
		public List<String> verifyColumnValues()
		{
			List<String> allcol = new ArrayList<String>();
			for (WebElement eachcolumn : columnnames)
			{
				allcol.add(eachcolumn.getText());
			}
			return allcol;
		}
		
}
