package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;
@Test(description="to verify user able to view manage contact",groups= {"smoke"})
public class ManageContactTest extends Base{
	public void verifyUserAbleViewOnManageContactList()
	{
	String username = ExcelUtility.getString(1, 0, "LoginPage");
	String password = ExcelUtility.getString(1, 1, "LoginPage");	
	String text=ExcelUtility.getString(9, 1, "LoginPage")	;
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username).enterpassWordOnPasswordField(password).signInClickOn();	
	ManageContactPage managecontactpage=new ManageContactPage(driver);
	managecontactpage.clickOnManageContactPage().getTableOptions();
	
	boolean navigatedToManageContactPage=managecontactpage.isManageContactPageVisible();
	Assert.assertTrue(navigatedToManageContactPage, "Not navigated to Manage contact page");
   
	}
}
