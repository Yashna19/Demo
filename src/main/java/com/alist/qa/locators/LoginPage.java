package com.alist.qa.locators;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.collections.Pair;

import com.alist.qa.base.BaseClass;



public class LoginPage extends BaseClass  {
	 
	
	
	WebDriver driver;
	public String messagetext;
	public String validation1;
	public String validation2;
	DashboardPage Dashpag;
	
	
	@FindBy(id = "username")
	 public WebElement Email;
	@FindBy(name = "password")
	public  WebElement Password;
	@FindBy(css = ".submit_btn.primary.button.wave")
	 public WebElement Signin;
	@FindBy(xpath = "//input[@id = 'password']/following-sibling::div")
	 public WebElement Invalidvalidation;
	@FindBy(xpath = "//div[@class='input-layout email_input']/span[1]")
	public WebElement EmptyEmail;
	@FindBy(xpath = "//div[@class='input-layout']/span[1]")
	public  WebElement EmptyPassword;
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
         PageFactory.initElements(driver, this);
	}

	public String[] invalidLogin() throws InterruptedException 
	{
		Signin.click();
		Thread.sleep(1000);
		validation1 = EmptyEmail.getText();
		validation2 = EmptyPassword.getText();
		return new String[] {validation1, validation2};
	}



	public Pair<DashboardPage, String> login(String user, String ps)
	{
		
		Email.clear();
		Password.clear();
		Email.sendKeys(user);
		Password.sendKeys(ps);
		Signin.click();
		
		
		if(driver.getCurrentUrl().contains("dashboard"))
		{
			
			Dashpag = new DashboardPage(driver);
		
		}
		else
		{

			messagetext = Invalidvalidation.getText();
			
		}
		
		return new Pair<DashboardPage, String>(Dashpag, messagetext );
	}
	
	
	

}
	
	

