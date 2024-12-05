package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test
	public void verifyUserAbleToEditAndViewOnManageNewsList()
	{
	String username = ExcelUtility.getString(1, 0, "LoginPage");
	String password = ExcelUtility.getString(1, 1, "LoginPage");	
	String text=ExcelUtility.getString(9, 1, "LoginPage")	;
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(username);
	loginpage.enterpassWordOnPasswordField(password);
	loginpage.signInClickOn();
	ManageNewsPage managenewspage=new ManageNewsPage(driver);
	managenewspage.manageNewsButton();
	managenewspage.clickNewButton();
	managenewspage.enterTheNews(text);
	managenewspage.clickOnSave();
	boolean isNavigatedToAlert=managenewspage.alerIstDisplayed();
	Assert.assertTrue(isNavigatedToAlert, "New news cannot be added");
	
	
	}
	
}