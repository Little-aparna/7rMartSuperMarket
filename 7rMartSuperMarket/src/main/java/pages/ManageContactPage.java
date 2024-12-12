package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WaitUtility;

public class ManageContactPage {
	public WebDriver driver;

	public ManageContactPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "(//p[text()='Manage Contact'])[1]")
	private WebElement manageContact;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr//th")
	private List<WebElement >tableOption;
	@FindBy(xpath = "//h4[text()='Contact Us']")
	private WebElement manageContactPageVisible;

	public ManageContactPage clickOnManageContactPage() {

		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementVisible(driver, manageContact);
		manageContact.click();
		return this;

	}
	
	 public ManageContactPage getTableOptions()
	  {  
		  
	     
		  WebDriverWait wait = new	WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfAllElements(tableOption));
	  List<String>l1=new ArrayList<>(); 
	  for(WebElement option:tableOption)
	  {
	  String headerText=option.getText(); 
	  l1.add(headerText);
	  if(headerText .equals("Action"))
	  {
		  break;
	  }
	  
	  }
	  return this;
	  }
	 public boolean isManageContactPageVisible()
	 {
		boolean manageContactPageShown= manageContactPageVisible.isDisplayed();
		return manageContactPageShown;
	 }
}

