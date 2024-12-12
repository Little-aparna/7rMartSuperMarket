package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFootertextPage;
import utility.ExcelUtility;

public class ManageFootertextTest extends Base {
	@Test(description="to verify user able to view manage contact",groups= {"smoke"})
	public void verifyUserAbleViewOnManageFooterList() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterpassWordOnPasswordField(password).signInClickOn();		
		ManageFootertextPage managefootertextpage = new ManageFootertextPage(driver);
		managefootertextpage.scrollDown().clickonMoreInfoButton().clickonEditIcon().enterAddressonAddressField().entereEmailonEmailField().entereNumberonPhoneNumberField().clickonSubmitButton();		
		boolean navigatedToAlert=managefootertextpage.isAlertavailable();
		Assert.assertTrue(navigatedToAlert, "footer Text not updated successfully");
		
	}
}
