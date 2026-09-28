package Dolibarr_Login;

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

public class Login_PageTest {
	@Test
	public  void logintest() throws InterruptedException, IOException {

		// Properties pObj = new Properties();
		// FileInputStream fis = new
		// FileInputStream("C:\\Users\\YINFO\\OneDrive\\Desktop\\PropertiesData.properties");
		// pObj.load(fis);

		// String browser = pObj.getProperty("bro");
		// String URL = pObj.getProperty("url");
		// String UserName = pObj.getProperty("un");
		//	String Password = pObj.getProperty("pwd");
		
		//Instead of getting data from properties file get the data from command line .....
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");

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
