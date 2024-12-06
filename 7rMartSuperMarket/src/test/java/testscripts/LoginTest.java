package testscripts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base{
	@Test(description="this is for successfull login",groups= {"smoke","regression"},priority=1)
	public void verifyUserAbleToLoginWithValidUsernameAndValidPassword()
	{
		
		String username=ExcelUtility.getString(0, 1, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterpassWordOnPasswordField(password);
		loginpage.signInClickOn();
		boolean isNavigatedToDashBoard=loginpage.isDashBoardDisplayed();
		
		Assert.assertTrue(isNavigatedToDashBoard, "unable to login with valid credentials");
		
	}
	@Test(description="for invalid user name",groups= {"smoke"},priority=2)
	public void verifyUserAbleTologinWithInvalidUsername()
	{
		String username=ExcelUtility.getString(2, 0,"LoginPage");
		String password=ExcelUtility.getString(2, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterpassWordOnPasswordField(password);
		loginpage.signInClickOn();
	    boolean isAlertVisibleDisplayed =loginpage.isAlertDisplayed();
	    Assert.assertTrue(isAlertVisibleDisplayed, "user able to login with invalid credentials");
	 }
	@Test(description="for invalid password",groups= {"regression"},priority=3)
	public void userAbleToLoginWithInvalidPassword()
	{
		
		String username=ExcelUtility.getString(3, 0, "LoginPage");
		String password=ExcelUtility.getString(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterpassWordOnPasswordField(password);
		loginpage.signInClickOn();
	    boolean isAlertVisibleDisplayed =loginpage.isAlertDisplayed();
	    Assert.assertTrue(isAlertVisibleDisplayed, "user able to login with invalid credentials");
	 }	
		
	@Test(description="for invalid user name and password",dataProvider="InvalidLoginData")
	public void verifyUserAbleToLoginWithInvalidUsernameAndInvalidPassword(String username,String password)
	{
		
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterpassWordOnPasswordField(password);
		loginpage.signInClickOn();
	    boolean isAlertVisibleDisplayed =loginpage.isAlertDisplayed();
	    Assert.assertTrue(isAlertVisibleDisplayed, "user able to login with invalid credentials");
	
	}
	@DataProvider(name="InvalidLoginData")
     public Object[][] getDataFromDataProvider()
     {
    	 return new Object[][] {  
    		 
    	new Object[] {"abc","abc"}	 ,
    	new Object[] {"123","123"}		 
    	 };
     }
}
