package Dolibarr_Login;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Login_PageXmlTest {

	@Test
	public  void logintest(XmlTest test) throws InterruptedException, IOException {

		
		String URL = test.getParameter("url");
		String BROWSER = test.getParameter("browser");
		String USERNAME = test.getParameter("username");
		String PASSWORD = test.getParameter("password");

		WebDriver driver;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(URL);

		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD );
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		Thread.sleep(3000);
		driver.quit();

	}

}
