package com.alist.qa.locators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;

import com.alist.qa.base.BaseClass;

import com.alist.qa.util.ReadDataFromExcel;



public class UserManagementPage extends BaseClass {
	
	public static Logger log = LogManager.getLogger(UserManagementPage.class);
	
	WebDriver driver;
	
	
	@FindBy(xpath ="//span[@class = 'ng-tns-c8-2']")
	WebElement usrheading;
	
	@FindBy(xpath = "//div[@class = 'plus-actions d-flex justify-content-end']")
	WebElement addusericon;
	
	@FindBy(xpath = "//div[@class = 'nodata-msg']//button[@class = 'primary-button m-r-15 ak-button ak-button__appearance-primary']")
	WebElement adduserbutton;
	
	@FindBy(css = "div.add-user-button.justify-content-end > button")
	WebElement adduserbutton2;
	
	@FindBy(css = "div.new-user")
	WebElement newuserstext;
	
	@FindBy(xpath = "//*[@class= 'm-0 pi-field-group row']/div/pi-form-field[@label='First Name*']/label")
	WebElement fnamelabel;
	
	@FindBy(xpath = "//*[@class= 'm-0 pi-field-group row']/div/pi-form-field[@label='Last Name*']/label")
	WebElement lnamelabel;
	
	@FindBy(xpath = "//*[@class= 'm-0 pi-field-group row']/following-sibling::pi-form-field/label")
	WebElement emaillabel;
	
	@FindBy(xpath = "//*[@formcontrolname= 'first_name']/following-sibling::div/mat-error")
	WebElement fnameval;
	
	@FindBy(xpath = "//*[@formcontrolname= 'last_name']/following-sibling::div/mat-error")
	WebElement lnameval;
	
	@FindBy(xpath = "//*[@label= 'Email*']/following-sibling::div/mat-error")
	WebElement emailval;
	
	@FindBy(xpath ="(//*[@formcontrolname = 'first_name'])")
	WebElement fnamefield;
	
	@FindBy(xpath ="(//*[@formcontrolname = 'last_name'])")
	WebElement lnamefield;
	
	@FindBy(xpath ="(//*[@formcontrolname = 'email'])")
	WebElement emailfield;
	
	@FindBy(xpath = "(//button[@class = 'text-button'])")
	WebElement cancelbutton;
	
	@FindBy(xpath = "//*[@class = 'ag-center-cols-container']//p[@class = 'user-name']")
	List<WebElement> userslist;
	
	@FindBy(xpath = "//*[@class = 'user-content d-flex']//h3")
	List<WebElement> alluserslist;
	
	@FindBy(xpath = "//*[@class = 'user-content d-flex']//span[@class = 'users-count']")
	List<WebElement> alluserscount; 
	
	public UserManagementPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
         PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle()
	{
		
		log.debug("Getting the Page Title");
		return driver.getTitle();
	}
	
	public String verifyPageHeading()
	{
		log.debug("Getting the Page Heading");
		return usrheading.getText();
	}
	
	
	public List<String> addUserMandatoryFields() throws InterruptedException
	{
		List<WebElement> aduser = new LinkedList<WebElement>();
		List<String> userfields = new ArrayList<>();
		aduser.add(fnamelabel);
		aduser.add(lnamelabel);
		aduser.add(emaillabel);
		Thread.sleep(4000);
		if(newuserstext.isDisplayed())
		{
			log.debug("Clicking on the Add User Button");
			adduserbutton2.click();
			Thread.sleep(2000);
			for(WebElement fldlabel : aduser)
			{
				if(fldlabel.getText().endsWith("*"))
				{
					
					userfields.add(fldlabel.getText());
					
				}
			}
			
		}
		else if (adduserbutton.isDisplayed())
		{
			log.debug("Clicking on the Add User icon");
			adduserbutton.click();
			Thread.sleep(2000);
			for(WebElement fldlabel : aduser)
			{
				if(fldlabel.getText().endsWith("*"))
				{
					userfields.add(fldlabel.getText());
					
				}
			}
		}	
		
		else
		{
			addusericon.click();
			Thread.sleep(2000);
			for(WebElement fldlabel : aduser)
			{
				if(fldlabel.getText().endsWith("*"))
				{
					
					userfields.add(fldlabel.getText());
					
				}
			}
		}
		return userfields;

	}
		
	
	
	public List<String> addUserValidationMessages()
	{
		addusericon.click();
		fnamefield.click();
		lnamefield.click();
		emailfield.click();
		fnamefield.click();
		List<WebElement> aduserval = new LinkedList<WebElement>();
		List<String> uvals = new ArrayList<>();
		aduserval.add(fnameval);
		aduserval.add(lnameval);
		aduserval.add(emailval);
		for(WebElement fldval : aduserval)
		{
			
				uvals.add(fldval.getText());
				
				
			
		}
		cancelbutton.click();
		return uvals;
		
		
	}
	
	public void verifyAddUser() throws IOException, InterruptedException
	{
		ReadDataFromExcel ex = new ReadDataFromExcel();
		Thread.sleep(3000);
		ArrayList<String> data = ex.ReadData("//home//enterpi//Desktop//eclipse-workspace//A-List//src//test//resources//TestData.xlsx", "TestData.xlsx", "Add New User", "Users", "User2");
		addusericon.click();
		Thread.sleep(3000);
		fnamefield.sendKeys(data.get(0));
		lnamefield.sendKeys(data.get(1));
		emailfield.sendKeys(data.get(2));
		cancelbutton.click();
	
	}
	
	public Pair<List<String>,List<String>>  checkUserDashboardDetails()
	{
		List<String> allusers = new ArrayList<>();
		for(WebElement detail : alluserslist)
		{
			allusers.add(detail.getText());
		}
		List<String> allusercount = new ArrayList<>();
		for(WebElement usercount : alluserscount)
		{
			allusercount.add(usercount.getText());
		}
		return new Pair<List<String>,List<String>>(allusers, allusercount);
	}
	
	public UserDetailsPage clickOnUser(String username)
	{
		for (WebElement user : userslist)
		{
			if(user.getText().equalsIgnoreCase(username))
			{
				user.getText();
				user.click();
				
			}
		}
		return new UserDetailsPage(driver);
	}
	
	
	

}
