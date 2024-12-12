package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;
import utility.RandomUtility;
import utility.WaitUtility;

public class ManageFootertextPage {
	public WebDriver driver;

	public ManageFootertextPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[10]")
	private WebElement moreInfo;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
	private WebElement editIcon;
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement addressField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumberField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public ManageFootertextPage scrollDown() {
		PageUtility pageutility = new PageUtility(driver);		
		pageutility.javaScriptExecutorScrolledFromTopToBottom(driver);
		return this;
	}

	public ManageFootertextPage clickonMoreInfoButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, moreInfo);
		moreInfo.click();
		return this;
	}

	public ManageFootertextPage clickonEditIcon() {
		editIcon.click();
		return this;
	}

	public ManageFootertextPage enterAddressonAddressField() {
		addressField.clear();
		RandomUtility randomutility = new RandomUtility();
		String address = randomutility.createARandomAddress();
		addressField.sendKeys(address);
		return this;
	}

	public ManageFootertextPage entereEmailonEmailField() {
		emailField.clear();
		RandomUtility randomutility = new RandomUtility();
		String email = randomutility.createARandomEmail();
		emailField.sendKeys(email);
		return this;
	}

	public ManageFootertextPage entereNumberonPhoneNumberField() {
		phoneNumberField.clear();
		RandomUtility randomutility = new RandomUtility();
		String phoneNumber = randomutility.createARandomPhoneNumber();
		phoneNumberField.sendKeys(phoneNumber);
		return this;
	}

	public ManageFootertextPage clickonSubmitButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, submitField);
		submitField.click();
		return this;
	}
	public boolean isAlertavailable() {
		boolean isAlertSuccessMessageDisplayed = alert.isDisplayed();
		return isAlertSuccessMessageDisplayed;
	}


	
}
   
