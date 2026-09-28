package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	WebDriver driver;
	Actions act;
	WebDriverWait wait;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void minimizeWindow() {
		driver.manage().window().minimize();
	}

	public void loadForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForElementClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void select(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	public void hover(WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void rightClick(WebElement element) {
		act.contextClick(element).build().perform();
	}

	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollByOffset(int x, int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public void clearAndSendKeys(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void sendKeyboardKey(WebElement element, Keys key) {
		element.sendKeys(key);
	}
	
	public void handleAlert() {
		Alert ali = driver.switchTo().alert();
		ali.accept();
	}

}
