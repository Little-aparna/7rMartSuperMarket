package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.FileUploadUtility;

import utility.PageUtility;
import utility.RandomUtility;

public class SubCategoryPage {
	public WebDriver driver;

	public SubCategoryPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	PageUtility pageutility = new PageUtility(driver);

	@FindBy(xpath = "//p[text()='Sub Category']//parent::a")
	private WebElement subCategoryButton;
	@FindBy(xpath = "//h4[text()='List Sub Categories']")
	private WebElement listSubCategoriesElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement CategoryElement;
	@FindBy(id = "un")
	private WebElement dropDown;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement subCategorySearch;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement subCategoryElement;
	@FindBy(id = "cat_id")
	private WebElement dropDown1;
	@FindBy(xpath = "//input[@type='file']")
	private WebElement chooseImage;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveAddSubCategoryElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertDisplayed;

	public void clickOnSubCategoryButton() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(subCategoryButton));
		subCategoryButton.click();

	}

	public boolean isCategoryDisplayed() {
		boolean isSubCategoryPageDisplayed = subCategoryButton.isDisplayed();
		return isSubCategoryPageDisplayed;
	}

	public boolean isSearchListAvailable() {
		boolean isSubCategoryListAvailable = listSubCategoriesElement.isDisplayed();
		return isSubCategoryListAvailable;
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public boolean isCategorySearchListAvailable() {
		boolean isSearchPageDisplayed = CategoryElement.isDisplayed();
		return isSearchPageDisplayed;
	}

	public void selectDropDown() {

		pageutility.selectDropdownByIndex(dropDown1, 1);

	}

	public void clickOnSubCategorySearch() {
		subCategorySearch.click();
	}

	public void clickOnNewButton() {
		newButton.click();
	}

	public void enterTheSubCategoryElements(String enterSubCategory) {
		RandomUtility randomutility = new RandomUtility();
		String sub_category_name = randomutility.createaRandomName();
		subCategoryElement.sendKeys(sub_category_name);
	}

	public void dropDown1() {

		pageutility.selectDropdownByIndex(dropDown1, 1);
	}

	public void imageUploading(String filePath) {
		FileUploadUtility fileuploadutility = new FileUploadUtility();		
		fileuploadutility.verifyFileUploadusingSendKeys(chooseImage, filePath);
		
	}
	public void scrollDown() {
		PageUtility pageutility = new PageUtility(driver);		
		pageutility.javaScriptExecutorScrolledFromTopToBottom(driver);
	}


	public void saveNewAddCategory() {
		saveAddSubCategoryElement.click();

	}

	public boolean isAlertDisplayed()

	{
		boolean isAlertShown = alertDisplayed.isDisplayed();
		return isAlertShown;
	}
}
