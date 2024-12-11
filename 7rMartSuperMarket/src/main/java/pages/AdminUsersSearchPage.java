package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;
import utility.RandomUtility;

public class AdminUsersSearchPage {
	public WebDriver driver;

	public AdminUsersSearchPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	PageUtility pageutility = new PageUtility(driver);
	RandomUtility randomutility = new RandomUtility();
	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[1]")
	private WebElement adminMoreInfoIcon;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchIconElement;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement newUserNameElement;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement dropDown;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement searchButton;
	@FindBy(xpath = "//th[text()='Username']")
	private WebElement searchShown;
	public void clickonAdminUserMoreInfoIcon() {
		adminMoreInfoIcon.click();
	}

	public void clickSearchIcon() {
		searchIconElement.click();
	}
	public void enterUserName(String adminUser)
	{
		newUserNameElement.sendKeys(adminUser);
	}
	public void selectDropDown()
	{
		PageUtility pageutility=new PageUtility(driver);
		pageutility.selectDropdownByIndex(dropDown, 2);
	}
	public void clickSearchButton()
	{
		searchButton.click();;
	}
	public void scrollDown() {
		PageUtility pageutility = new PageUtility(driver);		
		pageutility.javaScriptExecutorScrolledFromTopToBottom(driver);
	}
	public boolean isSearchDisplayed()
	{
		boolean searchCorrectlyShown=searchShown.isDisplayed();
		return searchCorrectlyShown;
	}

}
