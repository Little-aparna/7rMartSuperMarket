package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	 public WebDriver driver;
	   public CategoryPage(WebDriver driver)

	  {
	             this.driver=driver;	
	             PageFactory.initElements(driver, this);

	   }
	   @FindBy(xpath="(//p[text()='Category'])[1]") private WebElement categoryButton;
	   @FindBy(xpath="//h1[@class='m-0 text-dark']") private WebElement listCategoriesElement;
	   @FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") private WebElement searchButton;
	   @FindBy(xpath="//input[@class='form-control']") private WebElement searchElement;
	   @FindBy(xpath="//button[@type='submit']") private WebElement categorySearchButton;
	   @FindBy(xpath="//th[text()='Title']") private WebElement categorySearchAvailable;
	   public void clickOnCategoryButton()
	   {
		   categoryButton.click();
		   
		
	   }
	   public boolean isListcategoryDisplayed()
	   {
		  
		   boolean isListcategorydisplayed=listCategoriesElement.isDisplayed();
		   return isListcategorydisplayed;
	   }
	  
	   public void clickOnSearch()
	   {
		    searchButton.click();
	   }
	   public boolean isSearchDisplayed()
	   {
		   boolean isSearchAvailable=searchElement.isDisplayed();
		   return isSearchAvailable;
	   }
	   public void enterCategoryTextOnCategoryField(String categoryName)
	   {
		   searchElement.sendKeys(categoryName);
	   }
	   public void clickOnCategorySearch()
	   {
		   categorySearchButton.click();
	   }
	   public boolean isCategoryCorrectlyShown()
	   {
		   boolean isCategorySearchedDisplayed=categorySearchAvailable.isDisplayed();
		   return isCategorySearchedDisplayed;
	   }
	   
}
