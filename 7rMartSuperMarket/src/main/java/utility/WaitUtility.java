package utility;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 5;

	public static final long EXPLICIT_WAIT = 5;

	public void waitForElementVisible(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}

	public void waitForElementVVisibilityByXpath(WebDriver driver, String target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target)));
	}

	public void waitForPresenceOfElementLocatedByXpath(WebDriver driver, String target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(target)));
	}

	public void waitForElementToBeSelected(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeSelected(target));

	}

	public void waitForAlertIsPresent(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

	}

	public void implicitWaitDurationOfHour(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofHours(IMPLICIT_WAIT));

	}

	public void FluentWait(WebDriver driver, WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(target));

	}

	public void FluentWaitAlertIsPresent(WebDriver driver, WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());

	}

	public void FluentWaitVisibilityOfTarget(WebDriver driver, WebElement target) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(target));

	}

}
