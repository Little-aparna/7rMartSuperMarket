package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utility.ExcelUtility;

public class CategoryTest extends Base {
	@Test(description="to verify user able to edit and view category ",groups= {"smoke"})
	public void verifyUserAbleToEditAndViewCategory() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		
		String categoryName = ExcelUtility.getString(7, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterpassWordOnPasswordField(password);
		loginpage.signInClickOn();

		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickOnCategoryButton();

		categorypage.isListcategoryDisplayed();

		categorypage.clickOnSearch();
		categorypage.isSearchDisplayed();
		categorypage.enterCategoryTextOnCategoryField(categoryName);
		categorypage.clickOnCategorySearch();
		boolean isNavigatedToCategoryItem = categorypage.isCategoryCorrectlyShown();
		Assert.assertTrue(isNavigatedToCategoryItem, "Searched category not displayed");

	}

}
