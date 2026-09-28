package com.concast.crm.orgTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/**
 * @author RAHUL
 */
@Listeners(com.comcast.crm.listenerUtility.ListenerImpleClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "Smoke")
	public void CreateOrgTest() throws InterruptedException, IOException {

		UtilityClassObject.getTest().log(Status.INFO, "Read Data from Excel");
		// Read TestScript data from Excel File
		String OrgName = EU.getDataFromExcelFile("Sheets", 2, 2) + ju.getRandomNum();

		// step 2 navigate to Organization module..
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");
		HomePage hp = new HomePage(driver);
		hp.getOrganization().click();

		// step 3 Click on "careate Org"..
		UtilityClassObject.getTest().log(Status.INFO, "Click on Create Org ");
		OrganizationsPage Op = new OrganizationsPage(driver);
		Op.getCreateOrg().click();

		// Step 4 enter all the details and create new org...
		UtilityClassObject.getTest().log(Status.INFO, "Create a Org...");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(OrgName);

		UtilityClassObject.getTest().log(Status.INFO, OrgName + " Create a new Org ");
		// Verify Header msg Expected Result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String ActualOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, ActualOrgName.contains(OrgName));

		String ConfirmOrgName = oip.getConOrgName().getText();
		Assert.assertEquals(ConfirmOrgName, OrgName);
		System.out.println("Org Name is matched");

	}

	@Test(groups = "Regression")
	public void CreateOrgWithIndTest() throws InterruptedException, IOException {

		String OrgName = EU.getDataFromExcelFile("Sheets", 2, 2) + ju.getRandomNum();
		String Industry = EU.getDataFromExcelFile("Sheets", 1, 3);
		String Type = EU.getDataFromExcelFile("Sheets", 1, 4);

		// CreateOrg...
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

		WebElement OrgInput = driver.findElement(By.name("accountname"));
		OrgInput.sendKeys(OrgName);

		WebElement industryDD = driver.findElement(By.name("industry"));
		Select sel1 = new Select(industryDD);
		sel1.selectByVisibleText(Industry);

		WebElement TypeDD = driver.findElement(By.name("accounttype"));
		Select sel2 = new Select(TypeDD);
		sel2.selectByValue(Type);

		driver.findElement(By.cssSelector(".save")).click();

		// Verify the industries and type
		String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();

		Assert.assertEquals(actIndustries, Industry);

		String actType = driver.findElement(By.id("dtlview_Type")).getText();

		Assert.assertEquals(actType, Type);

	}

	@Test(groups = "Regression")
	public void CreateOrgWithPhoneNumberTest() throws InterruptedException, IOException {

		// Generate Random Number
		Random random = new Random();
		int randomInt = random.nextInt(1000);

		String orgName = EU.getDataFromExcelFile("Sheets", 2, 2) + randomInt;
		String PhoneNumber = EU.getDataFromExcelFile("Sheets", 2, 5);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// CreateOrg...
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

		WebElement OrgInput = driver.findElement(By.name("accountname"));
		OrgInput.sendKeys(orgName);

		WebElement PhoneNo = driver.findElement(By.id("phone"));
		PhoneNo.sendKeys(PhoneNumber);
		driver.findElement(By.cssSelector(".save")).click();

		// Verify Header msg Expected Result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " Is created");
		} else {
			System.out.println(orgName + " is not available ===Fail===");
		}

		// Verify header orgName info
		String Input = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (Input.equals(orgName)) {
			System.out.println(orgName + " is matching ===Correct===");
		} else {
			System.out.println(orgName + " is not matching ===Fail====");
		}

		// Verify PhoneNumber
		String Number = driver.findElement(By.id("dtlview_Phone")).getText();
		if (Number.equals(PhoneNumber)) {
			System.out.println(PhoneNumber + " is matching ===Correct===");
		} else {
			System.out.println(PhoneNumber + " is not matching ===Fail====");
		}

	}

}
