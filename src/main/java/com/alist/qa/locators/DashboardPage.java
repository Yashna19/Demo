package com.alist.qa.locators;

import org.openqa.selenium.interactions.Action;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.collections.Pair;

import com.alist.qa.base.BaseClass;

public class DashboardPage extends BaseClass {

	WebDriver driver;
	public String totalusers, userscount, totalclients, clientscount, totalvendors, vendorscount, totalformats, formatscount ;
	public String selectedclientvalue, selectedvendorvalue;
	
	
	@FindBy(css = "h5.dashboard-heading")
	WebElement pageHeading;
	
//	@FindBy(xpath = "//div[@class = 'dashboard-counts d-flex']/div[1]/h3")
//	WebElement totaluserstext;
//	
//	@FindBy(xpath = "//div[@class = 'dashboard-counts d-flex']/div[1]/div/div/span[2]")
//	WebElement totaluserscount;
//	
//	@FindBy(xpath = "//div[@class = 'dashboard-counts d-flex']/div[2]/h3")
//	WebElement totalclientstext;
//	
//	@FindBy(xpath = "//div[@class = 'dashboard-counts d-flex']/div[2]/div/div/span[2]")
//	WebElement totalclientscount;
//	
//	@FindBy(xpath = "//div[@class = 'dashboard-counts d-flex']/div[3]/h3")
//	WebElement totalvendorstext;
//	
//	@FindBy(xpath = "//div[@class = 'dashboard-counts d-flex']/div[3]/div/div/span[2]")
//	WebElement totalvendorscount;
//	
//	@FindBy(xpath = "//div[@class = 'dashboard-counts d-flex']/div[4]/h3")
//	WebElement totalformatstext;
//	
//	@FindBy(xpath = "//div[@class = 'dashboard-counts d-flex']/div[4]/div/div/span[2]")
//	WebElement totalformatscount;
	
	@FindBy(xpath = "//*[@class = 'dashboard-counts d-flex']//h3")
	List<WebElement> userslist;
	
	@FindBy(xpath = "//*[@class = 'dashboard-counts d-flex']//span[@class = 'count']")
	List<WebElement> alluserscount;
	
	@FindBy(xpath = "//div[@class = 'dashboard-content d-flex']/div[1]/div[2]/div")
	WebElement adduserlink;
	
	@FindBy(css = "button.text-button")
	WebElement addusercancelbutton;
	
	@FindBy(xpath = "//div[@class = 'dashboard-content d-flex']/div[2]/div[2]/div")
	WebElement addclientlink;
	
	@FindBy(xpath = "//div[@class='mat-select-value']")
	WebElement addclientdropdown;
	
	@FindBy(css = "mat-option.mat-option.ng-star-inserted")
	List<WebElement> getclientdropdownvalues;
		
	@FindBy(css = "button.text-button.m-r-15")
	WebElement addclientcancelbutton;
		
	@FindBy(xpath = "//div[@class = 'dashboard-content d-flex']/div[3]/div[2]/div")
	WebElement addvendorlink;
	
	@FindBy(css = "div.pi-select-input.single>div")
	WebElement addvendordropdown;
	
	@FindBy(css= "div.pi-select-input.single active")
	List<WebElement> getvendordropdownvalues;
	
	@FindBy(xpath= "//div[@class = 'opt ng-star-inserted']/div")
	WebElement selectedvendor;
	
	@FindBy(xpath = "//div[@class = 'btn-actions dialog-footer-actions']/div[2]/button[1]")
	WebElement addvendorcancelbutton;
		
	@FindBy(xpath = "//div[@class = 'dashboard-content d-flex']/div[4]/div[2]/div")
	WebElement addformatlink;
	
	@FindBy(xpath = "//div[@class = 'dialog-footer-actions structure-dialog-actions']/div[2]/button[1]")
	WebElement addformatcancelbutton;
	
	@FindBy(xpath = "//figure[@class='ng-tns-c1-0']//img[@class='ng-tns-c1-0']")
	WebElement logo;
	
	@FindBy(css = "i.pixel-icons.icon-hamburger")
	WebElement hamburger;
	
	@FindBy(xpath = "//div[@class = 'item ng-tns-c1-0 ng-star-inserted']/a[6]")
	WebElement allformatslink;
	
	@FindBy(xpath = "//div[@class = 'item ng-tns-c1-0 ng-star-inserted']/a[2]")
	WebElement usermanagementlink;
	
	@FindBy(xpath = "//div[@class = 'item ng-tns-c1-0 ng-star-inserted']/a[3]")
	WebElement userroleslink;
	
	@FindBy(xpath = "//div[@class = 'item ng-tns-c1-0 ng-star-inserted']/a[4]")
	WebElement allclientslink;
	
	@FindBy(xpath = "//div[@class = 'item ng-tns-c1-0 ng-star-inserted']/a[5]")
	WebElement allvendorslink;
	
	@FindBy(xpath = "//div[@class = 'item ng-tns-c1-0 ng-star-inserted']/a[7]")
	WebElement allproductslink;
	
	@FindBy(xpath = "//div[@class = 'item ng-tns-c1-0 ng-star-inserted']/a[8]")
	WebElement allcontactslink;
	
	@FindBy(xpath = "//div[@class = 'list']/div[2]/a")
	WebElement datautilityproductslink;
	
	
	
	public DashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
         PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyPageHeading()
	{
		return pageHeading.getText();
	}
	
	public  Pair<List<String>,List<String>> verifyTextAndCount()
	{
		List<String> allusers = new ArrayList<String>();
		for(WebElement usr : userslist)
		{
			allusers.add(usr.getText());
		}
		
		List<String> usrcount = new ArrayList<String>();
		for(WebElement usrc : alluserscount)
		{
			usrcount.add(usrc.getText());
		}	
		return new Pair<List<String>,List<String>>(allusers, usrcount);
	}
		
	
	public String[] verifyAddButtons(String clientvalue) throws InterruptedException
	{
		adduserlink.click();
		addusercancelbutton.click();
		Thread.sleep(2000);
		
		addclientlink.click();
		Thread.sleep(1000);
		addclientdropdown.click();
		for(WebElement client : getclientdropdownvalues)
		{
			
			if(client.getText().equalsIgnoreCase(clientvalue))
			{
				client.click();
				selectedclientvalue = client.getText();
				break;
			}
			
		}
		Thread.sleep(1000);
		addclientcancelbutton.click();
		
		addvendorlink.click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		Actions actions = new Actions(driver);
		actions.moveToElement(addvendordropdown).click().perform();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfAllElements(addvendordropdown));
		Action a = actions.sendKeys(Keys.DOWN).build();
		a.perform();
		actions.sendKeys(Keys.DOWN).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		selectedvendorvalue = selectedvendor.getText();
		Thread.sleep(1000);
		addvendorcancelbutton.click();
		
		addformatlink.click();
		addformatcancelbutton.click();
		
		return new String[] {selectedclientvalue,selectedvendorvalue};
	}
	
	
	public Boolean verifyLogo()
	{
		return logo.isDisplayed();
	}
	
	public FormatsPage clickOnHamburgerToFormats() throws InterruptedException 
	{
		hamburger.click();
		Thread.sleep(2000);
		allformatslink.click();
		Thread.sleep(3000);
		return new FormatsPage(driver);
		
	}
	
	public UserManagementPage clickOnHamburgerToUserManagement() throws InterruptedException
	{
		hamburger.click();
		Thread.sleep(2000);
		usermanagementlink.click();
		return new UserManagementPage(driver);
	}
	
	public UserRolesPage clickOnHamburgerToUserRoles() throws InterruptedException
	{
		hamburger.click();
		Thread.sleep(2000);
		userroleslink.click();
		return new UserRolesPage(driver);
	}
	
	public AllClientsPage clickOnHamburgerToAllClients() throws InterruptedException
	{
		hamburger.click();
		Thread.sleep(2000);
		allclientslink.click();
		return new AllClientsPage(driver);
	}
	
	public AllVendorsPage clickOnHamburgerToAllVendors() throws InterruptedException
	{
		hamburger.click();
		Thread.sleep(2000);
		allvendorslink.click();
		return new AllVendorsPage(driver);
	}
	
	public AllProductsPage clickOnHamburgerToAllProducts() throws InterruptedException
	{
		hamburger.click();
		Thread.sleep(2000);
		allproductslink.click();
		return new AllProductsPage(driver);
	}
	
	public AllContactsPage clickOnHamburgerToAllContacts() throws InterruptedException
	{
		Thread.sleep(2000);
		hamburger.click();
		Thread.sleep(2000);
		allcontactslink.click();
		return new AllContactsPage(driver);
	}
	
	public DataUtilityProductsPage clickOnHamburgerToDataUtilityProducts() throws InterruptedException
	{
		hamburger.click();
		Thread.sleep(2000);
		datautilityproductslink.click();
		return new DataUtilityProductsPage(driver);
	}
	
}
