package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	private WebDriver driver;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAndHoldOnElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).perform();
	}

	public void actionClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	public void doubleClickElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void sendText(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void rightClickAndHoldOnElement(WebElement element, WebDriver driver, String text) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, text).perform();
	}

	public void sendTexttoUppercase(WebElement element, WebDriver driver, String text) {
		Actions actions = new Actions(driver);
		actions.keyDown(element, Keys.SHIFT).sendKeys(text).perform();
	}


	public void navigateToURL(String url) {
		driver.navigate().to(url);
	}

	public void sendKeys(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
		Select select = new Select(dropdownElement);
		select.selectByVisibleText(visibleText);
	}

	public void selectDropdownByValue(WebElement dropdownElement, String value) {
		Select select = new Select(dropdownElement);
		select.selectByValue(value);
	}

	public void selectDropdownByIndex(WebElement dropdownElement, int index) {
		Select select = new Select(dropdownElement);
		select.selectByIndex(index);
	}

	public String getElementText(WebElement element) {
		return element.getText();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	// Scrolling
	public void javaScriptExecutorScrolledFromTopToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");// scrolled from top to bottom
	}

	public void javaScriptExecutorClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void javaScriptExecutorScrolledFromBottomToTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");// scrolled from bottom to top
	}

	public void javaScriptExecutorScrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void javaScriptExecutorScrolledToTheEnd(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)"); // scrolled to the end
	}

}
