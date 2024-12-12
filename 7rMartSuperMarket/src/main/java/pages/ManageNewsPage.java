package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.PageUtility;
import utility.WaitUtility;

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
	public ManageNewsPage manageNewsButton() {
         WaitUtility wait=new WaitUtility();
         wait.waitForElementVisible(driver, manageNewsButton);
		
		manageNewsButton.click();
		return this;

	}
	public ManageNewsPage clickNewButton() {
		clickOnNewButton.click();
		return this;
	}
	public ManageNewsPage enterTheNews(String text) {
		enternewsElement.sendKeys(text);
		return this;
	}
	public ManageNewsPage clickOnSave() {
		saveButton.click();
		return this;
		
	}
	public boolean alerIstDisplayed() {
	boolean isAlertShown=alertDisplayed.isDisplayed();
		return isAlertShown;
		
	}

}
