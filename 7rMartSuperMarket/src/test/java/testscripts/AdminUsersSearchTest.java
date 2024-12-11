package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersSearchPage;
import pages.LoginPage;
import utility.ExcelUtility;

public class AdminUsersSearchTest extends Base {
	@Test(description="user able to search in admin users list",groups= {"smoke"})
	public void verifyUserAbleToSearchOnAdminUserList() {

		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");	
		String adminUser=ExcelUtility.getString(11, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterpassWordOnPasswordField(password).signInClickOn();		
		AdminUsersSearchPage adminuserssearch=new AdminUsersSearchPage(driver);
		adminuserssearch.clickonAdminUserMoreInfoIcon();
		adminuserssearch.clickSearchIcon();
		adminuserssearch.enterUserName(adminUser);
		adminuserssearch.selectDropDown();
		adminuserssearch.clickSearchButton();
		adminuserssearch.scrollDown();
		boolean navigatedToSearch=adminuserssearch.isSearchDisplayed();
		Assert.assertTrue(navigatedToSearch, "search not correctly displayed");
		
	}

}
