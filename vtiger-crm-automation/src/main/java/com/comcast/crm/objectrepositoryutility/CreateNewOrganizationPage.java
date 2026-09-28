package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	WebDriver driver;

	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement OrgNameEdt;

	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement SaveBtn;

	@FindBy(name = "industry")
	private WebElement industryDD;

	public WebElement getOrgName() {
		return OrgNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public void createOrg(String orgName) {
		OrgNameEdt.sendKeys(orgName);
		SaveBtn.click();
	}

	public void createOrg(String orgName, String industry) {
		OrgNameEdt.sendKeys(orgName);
		Select sel = new Select(industryDD);
		sel.selectByVisibleText(industry);
		SaveBtn.click();
	}
}
