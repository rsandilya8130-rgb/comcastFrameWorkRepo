package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * @author Rahul
 * 
 * Contains Login Page Elements and Business Library like Login
 * 
 */
public class LoginPage  {
	// Rule 1 create a separate java class
	// Rule 2 object Creation
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement username;

	@FindBy(name = "user_password")
	private WebElement password;

	@FindBy(id = "submitButton")
	private WebElement LoginBtn;

	// Rule 3 Object Initialization

	// Rule 4 Encapsulation of object
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	/**
	 * login to application based on username , password , url argument
	 * @param url
	 * @param username
	 * @param password
	 */
	// Provide Action
	public void loginToapp(String url,String username, String password) {
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginBtn().click();
	}

}
