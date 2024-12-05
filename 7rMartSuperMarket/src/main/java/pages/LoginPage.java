package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@type='text']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashBoardDisplayed;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertDisplayed;

	public void enterUserNameOnUserNameField(String username)

	{
		userNameField.sendKeys(username);
	}

	public void enterpassWordOnPasswordField(String password)

	{
		passwordField.sendKeys(password);
	}

	public void signInClickOn()

	{
		signInButton.click();
	}

	public boolean isDashBoardDisplayed()

	{
		boolean isHomepageAvailable = dashBoardDisplayed.isDisplayed();
		return isHomepageAvailable;
	}

	public boolean isAlertDisplayed()

	{
		boolean isAlertShown = alertDisplayed.isDisplayed();
		return isAlertShown;
	}

}