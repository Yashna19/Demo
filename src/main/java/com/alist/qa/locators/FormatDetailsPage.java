package com.alist.qa.locators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormatDetailsPage {

	WebDriver driver;
	
	
	@FindBy(xpath = "//header[@class = 'd-flex align-items-center justify-content-between ng-star-inserted']/div/h1")
	WebElement formatname;
	
	@FindBy(xpath = "//div[@class = ' col-12 format-with-info']/pi-form-field/label")
	WebElement formatexplabel;
	
	@FindBy(xpath = "//*[@class = 'w-100 row ng-untouched ng-pristine ng-valid']/div[2]/pi-form-field/div/pi-select/label")
	WebElement globalformatlabel;
	
	@FindBy(xpath = "//*[@class = 'w-100 row ng-untouched ng-pristine ng-valid']/div[4]/pi-form-field/label")
	WebElement formatlabel;
	
	@FindBy(xpath = "//*[@class = 'w-100 row ng-untouched ng-pristine ng-valid']/div[5]/pi-form-field/label")
	WebElement translationlabel;
	
	@FindBy(xpath = "//*[@class = 'w-100 row ng-untouched ng-pristine ng-valid']/div[6]/pi-form-field/div/pi-select/label")
	WebElement cutofflabel;
	
	@FindBy(xpath = "//*[@class = 'w-100 row ng-untouched ng-pristine ng-valid']/div[7]/pi-form-field/label")
	WebElement baserolllabel;
	
	@FindBy(xpath = "//*[@class = 'w-100 row ng-untouched ng-pristine ng-valid']/div[8]/pi-form-field/label")
	WebElement noteslabel;
	
	@FindBy(xpath = "//*[@class = 'w-100 row ng-untouched ng-pristine ng-valid']/div[9]/pi-form-field/div/pi-select/label")
	WebElement statuslabel;
	
	
	@FindBy(xpath = "(//*[@formcontrolname='name'])")
	WebElement formatexpfield;
	
	@FindBy(xpath = "(//*[@formcontrolname='global_formats_classes_id'])")
	WebElement globalformatfield;
	
	@FindBy(xpath = "(//input[@formcontrolname = 'media_name'])")
	WebElement formatlabelfield;
	
	@FindBy(xpath = "(//input[@formcontrolname = 'translation'])")
	WebElement translationfield;
	
	@FindBy(xpath = "(//*[@formcontrolname='press_cutoff_id'])")
	WebElement cutofffield;
	
	@FindBy(xpath = "(//input[@formcontrolname = 'base_roll_width'])")
	WebElement baserollfield;
	
	@FindBy(xpath = "(//input[@formcontrolname = 'description'])")
	WebElement notesfield;
	
	@FindBy(xpath = "//div[9]//pi-form-field[1]//div[1]//pi-select[1]//div[1]//div[1]//div[1]//input[1]")
	WebElement statusfield;
	
	@FindBy(css = "button.text-button.m-r-15.format-cancel")
	WebElement cancelbtn;
	
	@FindBy(xpath = "//*[@formcontrolname = 'name']/following-sibling::div/mat-error")
	WebElement formatexpval;
	
	@FindBy(xpath = "//*[@formcontrolname = 'global_formats_classes_id']/following-sibling::div/mat-error")
	WebElement globalformatval;
	
	@FindBy(xpath = "//*[@formcontrolname = 'media_name']/following-sibling::div/mat-error")
	WebElement formatlabelval;
	
	@FindBy(xpath = "//*[@formcontrolname = 'translation']/following-sibling::div/mat-error")
	WebElement translationval;
	
	@FindBy(xpath = "//*[@formcontrolname = 'press_cutoff_id']/following-sibling::div/mat-error")
	WebElement cutoffval;
	
	@FindBy(xpath = "//*[@formcontrolname = 'base_roll_width']/following-sibling::div/mat-error")
	WebElement baserollval;
	
	@FindBy(xpath = "//*[@class = 'mat-tab-links']/a[2]")
	WebElement pagestab;
	
	
	
	public FormatDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
         PageFactory.initElements(driver, this);
	}
	
	
	public String getFormatName()
	{
		return formatname.getText();
	}
	
	public List<String> checkMandatoryFieldsInDetailsPage() throws InterruptedException 
	{
//		Actions a = new Actions(driver);
//		a.moveToElement(addformaticon).click().build().perform();
		//addformaticon.click();
		List<WebElement> detaillist = new LinkedList<WebElement>();
		List<String> mandatory = new ArrayList<>();
		detaillist.add(formatexplabel);
		detaillist.add(globalformatlabel);
		detaillist.add(formatlabel);
		detaillist.add(translationlabel);
		detaillist.add(cutofflabel);
		detaillist.add(baserolllabel);
		detaillist.add(noteslabel);
		detaillist.add(statuslabel);
		
		for(WebElement detailfieldlabel : detaillist)
		{
			if(detailfieldlabel.getText().endsWith("*"))
			{
				mandatory.add(detailfieldlabel.getText());
				//System.out.println(mandatoryfield);
			}
		}
		return mandatory;
	}
	
	public Boolean[] editFormatDetails() throws InterruptedException
	{
		Boolean cancelstatusbefore = cancelbtn.isEnabled();
		Actions a = new Actions(driver);
		Thread.sleep(2000);
		formatexpfield.click();
		a.sendKeys(formatexpfield, Keys.SHIFT).build().perform();
		a.sendKeys(Keys.ARROW_UP).build().perform();
		a.sendKeys(Keys.BACK_SPACE).build().perform();
		
		globalformatfield.click();
		a.sendKeys(globalformatfield, Keys.BACK_SPACE).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		
		
		Thread.sleep(2000);
		formatlabelfield.click();
		
		Thread.sleep(2000);
		formatlabelfield.sendKeys("abc");
		a.sendKeys(formatlabelfield, Keys.SHIFT).build().perform();
		a.sendKeys(Keys.ARROW_UP).build().perform();
		a.sendKeys(Keys.BACK_SPACE).build().perform();
		
		a.sendKeys(formatlabelfield, Keys.DELETE).build().perform();
	
		
		Thread.sleep(3000);
		translationfield.sendKeys("abs");
		a.sendKeys(translationfield, Keys.SHIFT).build().perform();
		a.sendKeys(Keys.ARROW_UP).build().perform();
		a.sendKeys(Keys.DELETE).build().perform();
		
		Thread.sleep(2000);
		a.sendKeys(cutofffield, Keys.BACK_SPACE).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		
		baserollfield.clear();
		Thread.sleep(3000);
		notesfield.clear();
		Thread.sleep(2000);
		statusfield.click();
		a.sendKeys(statusfield, Keys.BACK_SPACE).build().perform();
		Boolean cancelstatusafter = cancelbtn.isEnabled();
		
		return new Boolean[] {cancelstatusbefore,cancelstatusafter };
	}
	
	public List<String>  checkFieldValidationMessages() throws InterruptedException
	{
		List<WebElement> fieldsval = new LinkedList<WebElement>();
		List<String> values = new ArrayList<>();
		fieldsval.add(formatexpval);
		fieldsval.add(globalformatval);
		fieldsval.add(formatlabelval);
		fieldsval.add(translationval);
		fieldsval.add(cutoffval);
		fieldsval.add(baserollval);
		
		for(WebElement value : fieldsval)
		{
			values.add(value.getText());
		}
		
		return values;
		
	}
	
	public FormatPagesTabPage clickOnPagesTab()
	{
		pagestab.click();
		return new FormatPagesTabPage(driver);
		
	}
	
	
	
}
