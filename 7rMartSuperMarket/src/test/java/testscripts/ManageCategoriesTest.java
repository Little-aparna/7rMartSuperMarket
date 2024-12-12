package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageCategoriesPage;
import utility.ExcelUtility;
import pages.LoginPage;

public class ManageCategoriesTest extends Base {
	@Test(description="to verify user able to view and edit manage category",groups= {"smoke"})
	public void verifyUserAbleToEditAndViewOnManageCategories() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String categoryNameValue = ExcelUtility.getString(8, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterpassWordOnPasswordField(password).signInClickOn();
		ManageCategoriesPage managecategoriespage = new ManageCategoriesPage(driver);		
		managecategoriespage.clickOnManageCategory().clickOnSearchButton().searchListCategory(categoryNameValue);
		managecategoriespage.isListCategoryVisible();		
		boolean categorySearchCorrectly = managecategoriespage.clickOnCategorySearchButton();
		Assert.assertTrue(categorySearchCorrectly, "category search not correctly displayed");
	}
}
