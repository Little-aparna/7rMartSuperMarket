package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import utility.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test(description="user able to edit and view admin users list",groups= {"smoke"})
	public void verifyUserAbleToEditAndViewOnAdminUserList() {

		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");				
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterpassWordOnPasswordField(password).signInClickOn();		
		AdminUsersPage adminuserspage=new AdminUsersPage (driver);
		adminuserspage.clickonAdminUserMoreInfoIcon();		
		adminuserspage.clickonNewIcon();
		adminuserspage.enterNewUserName();
		adminuserspage.selectDropdown();
		adminuserspage.enterNewPassword();
		adminuserspage.clickonSaveButton();
		boolean isAlertDisplayed=adminuserspage.alertSuccessDisplayed();
		Assert.assertTrue(isAlertDisplayed, "cannot add new user");
		
	}
}
