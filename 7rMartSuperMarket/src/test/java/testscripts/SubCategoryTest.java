package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.SubCategoryPage;
import utility.ExcelUtility;

public class SubCategoryTest extends Base {
	LoginPage loginpage;
	SubCategoryPage subcategorypage;
	@Test(description="to verify user able to edit and view sub category",groups= {"smoke"})
	public void verifyUserAbleToEditAndViewOnSubCategoryList() {

		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String categoryElement=ExcelUtility.getString(1, 1, "LoginPage");
		String enterSubCategory=ExcelUtility.getString(12, 1, "LoginPage");				
		String filePath=Constants.CALCULATOR;
		loginpage = new LoginPage(driver);
		subcategorypage=loginpage.enterUserNameOnUserNameField(username).enterpassWordOnPasswordField(password).signInClickOn().clickOnSubCategoryButton().clickOnSearchButton().selectDropDown().enterTheSubcategory(categoryElement).clickOnSubCategorySearch().clickOnNewButton().enterTheSubCategoryElements(enterSubCategory).dropDown1().imageUploading(filePath).scrollDown().saveNewAddCategory();
		subcategorypage.isCategoryDisplayed();	
		boolean navigatedToAlert = subcategorypage.isAlertDisplayed();
		Assert.assertTrue(navigatedToAlert, " new sub category is not added");
		
	}
}
