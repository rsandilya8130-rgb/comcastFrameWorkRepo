package com.comcast.crm.contactTest;

import java.io.IOException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class CreateContactWithSupportDateTest extends BaseClass {
	@Test(groups = "Smoke")
	public void CreateContactWthSupportDateTest() throws IOException, InterruptedException {

		String FirstName = EU.getDataFromExcelFile("contact", 1, 0);
		String LastName = EU.getDataFromExcelFile("contact", 1, 1);

		// Create Contact
		driver.findElement(By.xpath("//a[text()='Contacts'][1]")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();

		WebElement Drop = driver.findElement(By.cssSelector("select[name='salutationtype']"));
		Select sel = new Select(Drop);
		Thread.sleep(2000);
		sel.selectByIndex(1);

		WebElement Fname = driver.findElement(By.cssSelector("input[name='firstname']"));
		Fname.sendKeys(FirstName);

		WebElement Lname = driver.findElement(By.cssSelector("input[name='lastname']"));
		Lname.sendKeys(LastName);

		String startDate = ju.getSystemDateYYYYDDMM();
		String endDate = ju.getRequiredDateyyyyMMdd(25);

		driver.findElement(By.xpath("//input[@name='support_start_date']")).clear();
		driver.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(startDate);

		driver.findElement(By.xpath("//input[@name='support_end_date']")).clear();
		driver.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(endDate);
		driver.findElement(By.cssSelector(".save")).click();
		String NameFill = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (NameFill.equals(LastName)) {
			System.out.println("Name is Matched");
		} else
			System.out.println("Name not Matched");

	}

	@Test(groups = "Regression")
	public void CreateContactWithOrgTest() throws InterruptedException, IOException {

		// Generate Random Number
		Random random = new Random();
		int randomInt = random.nextInt(1000);

		String orgName = EU.getDataFromExcelFile("contact", 1, 2) + randomInt;
		String FirstName = EU.getDataFromExcelFile("contact", 1, 0);
		String LastName = EU.getDataFromExcelFile("contact", 1, 1);
		// CreateOrg...
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

		WebElement OrgInput = driver.findElement(By.name("accountname"));

		OrgInput.sendKeys(orgName);
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

		// navigate to contact module
		// Create Contact
		driver.findElement(By.xpath("//a[text()='Contacts'][1]")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();

		WebElement Drop = driver.findElement(By.cssSelector("select[name='salutationtype']"));
		Select sel = new Select(Drop);
		Thread.sleep(2000);
		sel.selectByIndex(1);

		WebElement Fname = driver.findElement(By.cssSelector("input[name='firstname']"));
		Fname.sendKeys(FirstName);

		WebElement Lname = driver.findElement(By.cssSelector("input[name='lastname']"));
		Lname.sendKeys(LastName);

		String PID = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		Set<String> CID = driver.getWindowHandles();
		for (String i : CID) {
			driver.switchTo().window(i);
			if (driver.getCurrentUrl().contains("module=Accounts")) {
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		// dynamic Xpath....
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		driver.switchTo().window(PID);

		driver.findElement(By.cssSelector(".save")).click();
		String NameFill = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (NameFill.equals(LastName)) {
			System.out.println("Name is Matched");
		} else
			System.out.println("Name not Matched");

	}

}
