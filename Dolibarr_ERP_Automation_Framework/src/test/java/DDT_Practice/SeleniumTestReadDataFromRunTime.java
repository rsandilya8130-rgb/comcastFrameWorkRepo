package DDT_Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRunTime {

	@Test
	public void seleniumTest() throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream("C:\\Users\\YINFO\\OneDrive\\Desktop\\PropertiesData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);

		String browser = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String UserName = pObj.getProperty("un");
		String Password = pObj.getProperty("pwd");
		
		
		WebDriver driver;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(URL);

		driver.findElement(By.id("username")).sendKeys(UserName);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		Thread.sleep(3000);
		driver.quit();
	}

}
