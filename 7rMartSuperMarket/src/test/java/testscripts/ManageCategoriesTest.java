package testscripts;

import java.sql.Driver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ManageCategoriesPage;
import utility.ExcelUtility;
import pages.LoginPage;

public class ManageCategoriesTest extends Base {
	@Test
	public void verifyUserAbleToEditAndViewOnManageCategories() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String categoryNameValue = ExcelUtility.getString(8, 1, "LoginPage");
		ManageCategoriesPage managecategoriespage = new ManageCategoriesPage(driver);
		managecategoriespage.enterUserNameOnUserNameField(username);
		managecategoriespage.enterpassWordOnPasswordField(password);
		managecategoriespage.signInClickOn();
		managecategoriespage.clickOnManageCategory();
		managecategoriespage.isListCategoryVisible();
		managecategoriespage.clickOnSearchButton();
		managecategoriespage.searchListCategory(categoryNameValue);
		boolean categorySearchCorrectly = managecategoriespage.clickOnCategorySearchButton();
		Assert.assertTrue(categorySearchCorrectly, "category search not correctly displayed");
	}
}
