package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;
import utility.WaitUtility;

public class ManageProductPage {
	public WebDriver driver;

	public ManageProductPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "(//i[@class='fas fa-arrow-circle-right'])[8]")
	private WebElement moreInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchIcon;
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private WebElement titleElement;
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private WebElement searchButton;
	@FindBy(xpath = "(//h4[@class='card-title'])[2]")
	private WebElement searchResult;
	public void scrollDown() {
		PageUtility pageutility = new PageUtility(driver);		
		pageutility.javaScriptExecutorScrolledFromTopToBottom(driver);
	}

	public void clickonMoreInfoButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToBeClickable(driver, moreInfo);
		moreInfo.click();
	}
	public void clickonsearchIcon() {
		searchIcon.click();
	}
	public void enterTitleElement(String searchItem) {
		titleElement.sendKeys(searchItem);
	}
	public void clickonSearchButton() {
		searchButton.click();
	}
	public void scrollDown1() {
		PageUtility pageutility = new PageUtility(driver);		
		pageutility.javaScriptExecutorScrolledFromTopToBottom(driver);
	}
	public boolean isSearchDisplayed()
	{
		boolean searchCorrectlyShown=searchResult.isDisplayed();
		return searchCorrectlyShown;
	}
	
}
