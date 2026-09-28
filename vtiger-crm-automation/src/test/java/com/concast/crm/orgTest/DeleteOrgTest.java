package com.concast.crm.orgTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Create Object
		FileUtility Fut = new FileUtility();
		ExcelUtility EU = new ExcelUtility();
		JavaUtility ju = new JavaUtility();

		// Read common data from Properties File
		String Browser = Fut.getDataFromPropertiesFile("bro");
		String url = Fut.getDataFromPropertiesFile("url");
		String UserName = Fut.getDataFromPropertiesFile("un");
		String Password = Fut.getDataFromPropertiesFile("pwd");

		// Read TestScript data from Excel File
		String OrgName = EU.getDataFromExcelFile("Sheets", 3, 2) + ju.getRandomNum();

		// Open a Browser....
		WebDriver driver = null;
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else
			driver = new ChromeDriver();

		// Create webdriverutility Object..
	    	WebDriverUtility wdu = new WebDriverUtility(driver);
		
		// step 1 login to app..
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(url ,UserName, Password);

		// step 2 navigate to Organization module..
		HomePage hp = new HomePage(driver);
		hp.getOrganization().click();

		// step 3 Click on "careate Org"..
		OrganizationsPage Op = new OrganizationsPage(driver);
		Op.getCreateOrg().click();

		// Step 4 enter all the details and create new org...
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(OrgName);

		// Verify Header msg Expected Result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String ActualOrgName = oip.getHeaderMsg().getText();
		if(ActualOrgName.contains(OrgName)) {
			System.out.println(OrgName+" is Verified == Pass");
		}
		else {
			System.out.println(OrgName+" is Failed");
		}
		
		// GoBack to the Org Page...
		hp.getOrganization().click();
		
		//Search for Organization...
		Op.getSearchBox().sendKeys(OrgName);
		wdu.select("Organization Name",Op.getSearchDD() );
		Op.getSearchBtn().click();
		
		//Delete Org....
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']/../..//a[text()='del']")).click();
		Thread.sleep(2000);
		
		wdu.handleAlert();
		System.out.println("Alert Handled successfully...");
		
		// SignOut
		hp.LogOut();

		
		driver.quit();
	}
}
