package com.alist.qa.locators;

import java.awt.AWTException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FormatsPage {
	
	WebDriver driver;
	public String mandatoryfield;
	
	@FindBy(xpath = "//div[@class='actions d-flex justify-content-end']")
	WebElement addformaticon;
	
	@FindBy(xpath = "//div[@class = 'col-12 format-with-info p-0']/pi-form-field/label")
	 WebElement formatexpressionlabel;
	
	@FindBy(xpath = "//*[@class = 'mat-dialog-content d-flex flex-column w-100 ']/form/pi-form-field[1]/div"
			+ "/pi-select/label")
	 WebElement globalformatclasslabel;
	
	@FindBy(xpath = "//*[@class = 'mat-dialog-content d-flex flex-column w-100 ']/form/pi-form-field[2]/label")
	 WebElement formatlabel;
	
	@FindBy(xpath = "//*[@class = 'mat-dialog-content d-flex flex-column w-100 ']/form/pi-form-field[3]/label")
	 WebElement translationlabel;
	
	@FindBy(xpath = "//*[@class = 'mat-dialog-content d-flex flex-column w-100 ']/form/pi-form-field[4]/div"  
						+ "/pi-select/label")
	 WebElement presscutofflabel;
	
	@FindBy(xpath = "//*[@class = 'mat-dialog-content d-flex flex-column w-100 ']/form/pi-form-field[5]/label")
	 WebElement baserollwidthlabel;
	
	@FindBy(xpath = "//*[@class = 'mat-dialog-content d-flex flex-column w-100 ']/form/pi-form-field[6]/label")
	 WebElement noteslabel;
	
	@FindBy(xpath = "//*[@class = 'mat-dialog-content d-flex flex-column w-100 ']/form/pi-form-field[7]/div/"
			+ "pi-select/label")
	 WebElement statuslabel;
	
	@FindBy(xpath = "(//*[@formcontrolname='name'])[2]")
	WebElement formatexpressionfield;
	
	@FindBy(xpath = "(//*[@formcontrolname='global_formats_classes_id'])[2]")
	WebElement globalformatclassfield;
	
	@FindBy(xpath = "(//input[@formcontrolname = 'media_name'])[2]")
	WebElement formatlabelfield;
	
	@FindBy(xpath = "(//input[@formcontrolname = 'translation'])[2]")
	WebElement translationfield;
	
	@FindBy(xpath = "(//*[@formcontrolname='press_cutoff_id'])[2]")
	WebElement presscutofffield;
	
	@FindBy(xpath = "(//input[@formcontrolname = 'base_roll_width'])[2]")
	WebElement baserollwidthfield;
	
	@FindBy(xpath = "(//input[@formcontrolname = 'description'])[2]")
	WebElement notesfield;
	
	@FindBy(xpath = "//*[@class='pi-select-input single']/div[1]/input[1]")
	WebElement statusfield;
	
	@FindBy(xpath = "//*[@formcontrolname = 'name']/following-sibling::div/mat-error")
	WebElement formatexpressionval;
	
	@FindBy(xpath = "//*[@formcontrolname = 'global_formats_classes_id']/following-sibling::div/mat-error")
	WebElement globalformatclassval;
	
	@FindBy(xpath = "//*[@formcontrolname = 'media_name']/following-sibling::div/mat-error")
	WebElement formatlabelval;
	
	@FindBy(xpath = "//*[@formcontrolname = 'translation']/following-sibling::div/mat-error")
	WebElement translationval;
	
	@FindBy(xpath = "//*[@formcontrolname = 'press_cutoff_id']/following-sibling::div/mat-error")
	WebElement presscutoffval;
	
	@FindBy(xpath = "//*[@formcontrolname = 'base_roll_width']/following-sibling::div/mat-error")
	WebElement baserollwidthval;
	
	@FindBy(xpath  = "//*[@class = 'dialog-footer-actions structure-dialog-actions']/div[2]/button[1]")
	WebElement cancelbutton;
	
	@FindBy(xpath ="//div[@class = 'ag-center-cols-container']//h5")
	List<WebElement> formatslist;
	
//	@FindBy(xpath ="//div[@class = 'ag-center-cols-container']")
//	List<WebElement> clickonformat;
	
	@FindBy(css = "a.mat-tab-link.mat-tab-label-active.ng-star-inserted")
	WebElement detailstab;
	
	
	public FormatsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver = driver;
         PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public List<String> checkAddFormatMandatoryFields() throws InterruptedException 
	{
		Actions a = new Actions(driver);
		a.moveToElement(addformaticon).click().build().perform();
		//addformaticon.click();
		List<WebElement> adform = new LinkedList<WebElement>();
		List<String> str = new ArrayList<>();
		adform.add(formatexpressionlabel);
		adform.add(globalformatclasslabel);
		adform.add(formatlabel);
		adform.add(translationlabel);
		adform.add(presscutofflabel);
		adform.add(baserollwidthlabel);
		adform.add(noteslabel);
		adform.add(statuslabel);
		
		for(WebElement fieldlabel : adform)
		{
			if(fieldlabel.getText().endsWith("*"))
			{
				str.add(fieldlabel.getText());
				//System.out.println(mandatoryfield);
			}
		}
		return str;
	}
	
	public void checkAddFormatFields(String format, String formatlabel, String translation, String baseroll, String notes ) throws AWTException, InterruptedException
	{
		
		formatexpressionfield.sendKeys(format);
		globalformatclassfield.click();
		Actions a = new Actions(driver);
		Thread.sleep(1000);
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
		formatlabelfield.sendKeys(formatlabel);
		translationfield.sendKeys(translation);
		presscutofffield.click();
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		baserollwidthfield.sendKeys(baseroll);
		notesfield.sendKeys(notes);
		Thread.sleep(1000);
		a.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
		//statusfield.click();
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(3000);
		cancelbutton.click();
		
	}
	public List<String> checkAddFormatValidations() throws InterruptedException
	{
		Actions a = new Actions(driver);
		a.moveToElement(addformaticon).click().build().perform();
		a.moveToElement(addformaticon).click().build().perform();
		formatexpressionfield.click();
		globalformatclassfield.click();
		Thread.sleep(1000);
		globalformatclassfield.click();
		formatlabelfield.click();
		translationfield.click();
		presscutofffield.click();
		Thread.sleep(1000);
		presscutofffield.click();
		baserollwidthfield.click();
		notesfield.click();
		a.sendKeys(statusfield, Keys.BACK_SPACE).build().perform();
		
		List<WebElement> vallist = new LinkedList<WebElement>();
		List<String> string = new ArrayList<>();
		vallist.add(formatexpressionval);
		vallist.add(globalformatclassval);
		vallist.add(formatlabelval);
		vallist.add(translationval);
		vallist.add(presscutoffval);
		vallist.add(baserollwidthval);
		
		for(WebElement fieldval : vallist)
		{
			string.add(fieldval.getText());
		}
		
		return string;
		
	}
	
	public FormatDetailsPage goToFormatDetailsTab(String FormatName) throws InterruptedException 
	{
		for( WebElement selectedformat : formatslist)
			{
			Thread.sleep(2000);
			System.out.println(selectedformat.getText());
				if(selectedformat.getText().equalsIgnoreCase(FormatName))
				{
					Thread.sleep(3000);
					selectedformat.click();
					detailstab.click();
				}
				}
		
		return new FormatDetailsPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
