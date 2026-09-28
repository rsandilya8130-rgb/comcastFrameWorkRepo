package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;

	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement CreateOrg;

	@FindBy(className = "txtBox")
	private WebElement SearchBox;

	@FindBy(id="bas_searchfield")
	private WebElement SearchDD;
	
	@FindBy(name = "submit")
	private WebElement SearchBtn;
	
	public WebElement getCreateOrg() {
		return CreateOrg;
	}
	
	public WebElement getSearchBox() {
		return SearchBox;
	}
	
	public WebElement getSearchDD() {
		return SearchDD;
	}
	
	public WebElement getSearchBtn() {
		return SearchBtn;
	}

}
