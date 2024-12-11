package testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utility.ScreenShotUtility;

public class Base {

	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		Properties prop=new Properties();
		FileInputStream fs=new FileInputStream(Constants.CONFIGFILE);
		prop.load(fs);
		
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("FireFox"))

		{
			driver = new FirefoxDriver();
		}

		else {
			throw new Exception("Invalid Browser");
		}
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility sc = new ScreenShotUtility();
			sc.getScreenShot(driver, iTestResult.getName());
		}
		driver.quit();
	}

}
