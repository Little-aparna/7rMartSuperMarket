package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.SubCategoryPage;
import utility.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test(description="to verify user able to edit and view sub category",groups= {"smoke"})
	public void verifyUserAbleToEditAndViewOnSubCategoryList() {

		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");		
		String enterSubCategory=ExcelUtility.getString(6, 0, "LoginPage");				
		String filePath=Constants.CALCULATOR;
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterpassWordOnPasswordField(password);
		loginpage.signInClickOn();
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickOnSubCategoryButton();
		subcategorypage.isCategoryDisplayed();
		subcategorypage.isSearchListAvailable();
		subcategorypage.clickOnSearchButton();
		subcategorypage.isCategorySearchListAvailable();
		subcategorypage.selectDropDown();
		subcategorypage.clickOnSubCategorySearch();
		subcategorypage.clickOnNewButton();
		subcategorypage.enterTheSubCategoryElements(enterSubCategory);
		subcategorypage.dropDown1();
		subcategorypage.imageUploading(filePath);
		subcategorypage.saveNewAddCategory();
		boolean navigatedToAlert = subcategorypage.isAlertDisplayed();
		Assert.assertTrue(navigatedToAlert, " new sub category is not added");
	}
}
