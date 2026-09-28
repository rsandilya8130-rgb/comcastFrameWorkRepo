package com.comcast.crm.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public FileUtility fu = new FileUtility();
	public ExcelUtility EU = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();

	@BeforeSuite(groups = { "Smoke", "Regression" })
	public void beforeSuite() {
		System.out.println("==Connect to Database==");

	}

	@Parameters("Browser")
	@BeforeClass(groups = { "Smoke", "Regression" })
	public void beforeClass() throws IOException {
		System.out.println("===Launch The Browser===");
		String Browser = fu.getDataFromPropertiesFile("bro");

		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else
			driver = new ChromeDriver();

		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "Smoke", "Regression" })
	public void beforeMethod() throws IOException {
		System.out.println("===Login===");
		String Url = fu.getDataFromPropertiesFile("url");
		LoginPage lp = new LoginPage(driver);
		String UserName = fu.getDataFromPropertiesFile("un");
		String Password = fu.getDataFromPropertiesFile("pwd");
		lp.loginToapp(Url, UserName, Password);
	}

	@AfterMethod(groups = { "Smoke", "Regression" })
	public void afterMethod() {
		System.out.println("===LogOut===");
		HomePage hp = new HomePage(driver);
		hp.LogOut();
	}

	@AfterClass(groups = { "Smoke", "Regression" })
	public void afterClass() {
		System.out.println("===Close The Browser===");
		driver.quit();
	}

	@AfterSuite(groups = { "Smoke", "Regression" })
	public void afterSuit() {
		System.out.println("==Close The Database==");

	}

}
