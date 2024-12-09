package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WaitUtility;

public class ManageCategoriesPage {
	public WebDriver driver;

	public ManageCategoriesPage(WebDriver driver)

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
	@FindBy(xpath = "//p[text()='Manage Category']")
	private WebElement manageCategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement categoryText;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement categorysearch;

	

	public boolean isDashBoardDisplayed()

	{
		boolean isHomepageAvailable = dashBoardDisplayed.isDisplayed();
		return isHomepageAvailable;
	}

	public void clickOnManageCategory() {
		
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementVisible(driver, manageCategory);
        manageCategory.click();

	}

	public boolean isListCategoryVisible() {
		boolean isListCategoryShown = manageCategory.isDisplayed();
		return isListCategoryShown;
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void searchListCategory(String categoryNameValue) {
		categoryText.sendKeys(categoryNameValue);
	}

	public boolean clickOnCategorySearchButton() {
		categorysearch.click();
		boolean shownCorrectCategory = categorysearch.isDisplayed();
		return shownCorrectCategory;
	}
}
