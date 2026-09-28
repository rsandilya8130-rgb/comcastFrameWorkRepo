package Practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenShotTest {

	@Test
	public void ScreenShotPracticeTest() throws IOException, InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://flipkart.com");

		// Create an Object to EventFiring Webdriver
		// EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		// this is out dated and not available in selenium new version....

		TakesScreenshot tks = (TakesScreenshot) driver;

		File source = tks.getScreenshotAs(OutputType.FILE);

		File destination = new File("./ScreenShot/flipkart.png");

		FileHandler.copy(source, destination);

		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		
		
		
		
	}
}
