package adv_report_listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
	@Listeners(adv_report_listeners.List_Imp.class)
public class SauceDemoTest {
	
	ExtentReports report;
	
	
	
	@Test
	public void login() throws InterruptedException  {
		
		WebDriver driver = new EdgeDriver();
		driver.get("http://www.saucedemo.com/");
		Thread.sleep(3000);
		driver.quit();
		
		
	}
	@Test
	public void logout() throws InterruptedException {
		Assert.assertTrue(false);
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		driver.quit();
		
	}
	


}
