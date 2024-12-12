package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFootertextPage;
import pages.ManageProductPage;
import utility.ExcelUtility;

public class ManageProductTest extends Base {
	@Test(description="to verify user able to view manage Product page",groups= {"smoke"})
	public void verifyUserAbleViewOnManageFooterList() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String searchItem = ExcelUtility.getString(10, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterpassWordOnPasswordField(password).signInClickOn();		
		ManageProductPage manageproductpage = new ManageProductPage(driver);
		manageproductpage.scrollDown().clickonMoreInfoButton().clickonsearchIcon().enterTitleElement(searchItem).clickonSearchButton().scrollDown1();		
		boolean searchdisplayed=manageproductpage.isSearchDisplayed();
		Assert.assertTrue(searchdisplayed, "Search is not correctly shown");
	
		
	}
}
