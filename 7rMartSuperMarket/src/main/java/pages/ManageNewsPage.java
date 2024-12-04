package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.PageUtility;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	PageUtility pageutility = new PageUtility(driver);

	@FindBy(xpath = "(//p[text()='Manage News'])[1]")private WebElement manageNewsButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")	private WebElement clickOnNewButton;
	@FindBy(xpath="//textarea[@id='news']")private WebElement enternewsElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertDisplayed;
	public void manageNewsButton() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(manageNewsButton));
		manageNewsButton.click();

	}
	public void clickNewButton() {
		clickOnNewButton.click();
	}
	public void enterTheNews(String text) {
		enternewsElement.sendKeys(text);
	}
	public void clickOnSave() {
		saveButton.click();
		
	}
	public boolean alerIstDisplayed() {
	boolean isAlertShown=alertDisplayed.isDisplayed();
		return isAlertShown;
		
	}

}
