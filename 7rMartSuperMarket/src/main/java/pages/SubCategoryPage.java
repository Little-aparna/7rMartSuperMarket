package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	private WebElement dropDown;
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement subCategoryText;
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

	public SubCategoryPage clickOnSubCategoryButton() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(subCategoryButton));
		subCategoryButton.click();
		return this;

	}

	public boolean isCategoryDisplayed() {
		boolean isSubCategoryPageDisplayed = subCategoryButton.isDisplayed();
		return isSubCategoryPageDisplayed;
	}

	public boolean isSearchListAvailable() {
		boolean isSubCategoryListAvailable = listSubCategoriesElement.isDisplayed();
		return isSubCategoryListAvailable;
	}

	public SubCategoryPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	public boolean isCategorySearchListAvailable() {
		boolean isSearchPageDisplayed = subCategoryText.isDisplayed();
		return isSearchPageDisplayed;
	}

	public SubCategoryPage selectDropDown() {

		pageutility.selectDropdownByIndex(dropDown, 1);
		return this;

	}
	public SubCategoryPage enterTheSubcategory(String categoryElement)
	{
		subCategoryText.sendKeys(categoryElement);
		return this;
	}

	public SubCategoryPage clickOnSubCategorySearch() {
		subCategorySearch.click();
		return this;
	}

	public SubCategoryPage clickOnNewButton() {
		newButton.click();
		return this;
	}

	public SubCategoryPage enterTheSubCategoryElements(String enterSubCategory) {
		RandomUtility randomutility = new RandomUtility();
		String sub_category_name = randomutility.createaRandomName();
		subCategoryElement.sendKeys(sub_category_name);
		return this;
	}

	public SubCategoryPage dropDown1() {

		pageutility.selectDropdownByIndex(dropDown1, 1);
		return this;
	}

	public SubCategoryPage imageUploading(String filePath) {
		FileUploadUtility fileuploadutility = new FileUploadUtility();		
		fileuploadutility.verifyFileUploadusingSendKeys(chooseImage, filePath);
		return this;
		
	}
	public SubCategoryPage scrollDown() {
		PageUtility pageutility = new PageUtility(driver);		
		pageutility.javaScriptExecutorScrolledFromTopToBottom(driver);
		return this;
	}


	public SubCategoryPage saveNewAddCategory() {
		saveAddSubCategoryElement.click();
		return this;

	}

	public boolean isAlertDisplayed()

	{
		boolean isAlertShown = alertDisplayed.isDisplayed();
		return isAlertShown;
	}
}
