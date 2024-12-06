package testscripts;

import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.LoginPage;
import utility.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test(groups= {"smoke"})
	public void verifyUserAbleToEditAndViewOnAdminUserList() {

		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");				
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterpassWordOnPasswordField(password);
		loginpage.signInClickOn();
		AdminUsersPage adminuserspage=new AdminUsersPage (driver);
		adminuserspage.clickonAdminUserMoreInfoIcon();		
		adminuserspage.clickonNewIcon();
		adminuserspage.enterNewUserName();
		adminuserspage.selectDropdown();
		adminuserspage.enterNewPassword();
		adminuserspage.clickonSaveButton();
		adminuserspage.alertSuccessDisplayed();
		
	}
}
