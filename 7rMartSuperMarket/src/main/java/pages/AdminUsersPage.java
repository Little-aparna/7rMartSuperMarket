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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PageUtility;
import utility.RandomUtility;
import utility.WaitUtility;
//import utility.WaitUtility;

public class AdminUsersPage {

	public WebDriver driver;

	public AdminUsersPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	PageUtility pageutility = new PageUtility(driver);
	RandomUtility randomutility = new RandomUtility();
	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[1]")
	private WebElement adminMoreInfoIcon;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newIconElement;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement newUserNameElement;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement newPasswordElement;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement dropDownElement;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertSuccess;

	
	
	
	public void clickonAdminUserMoreInfoIcon() {
		adminMoreInfoIcon.click();
	}

	public void clickonNewIcon() {
		newIconElement.click();
	}
	
	public void enterNewUserName() {
		String randomUserName1=randomutility.createaRandomName();
		newUserNameElement.sendKeys(randomUserName1);
	}

	public void enterNewPassword() {
		String randomPassword1=randomutility.createARandomPassword();
		newPasswordElement.sendKeys(randomPassword1);
	}

	public void selectDropdown() {
		PageUtility pagautility = new PageUtility(driver);
		//pagautility.selectClickByVisibleText(dropDownElement, "Partner");
		pagautility.selectDropdownByVisibleText(dropDownElement, "Partner");
	}

	public void clickonSaveButton() {
		saveField.click();
	}

	public String alertAvailable() {
		String text = alertSuccess.getText();
		String alertTextIs = text.substring(9);
		return alertTextIs;
	}

	public boolean alertSuccessDisplayed() {
		boolean isAlertSuccessDisplayed=alertSuccess.isDisplayed();
		return isAlertSuccessDisplayed;
	}


	
	// table[@class='table table-bordered table-hover table-sm']//tr//th
}
