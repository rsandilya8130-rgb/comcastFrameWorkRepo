package com.crm.generic.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class baseClass {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("==Connect to Database==");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("===Launch The Browser===");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("===Login===");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("===LogOut===");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("===Close The Browser===");
	}
	
	@AfterSuite
	public void afterSuit() {
		System.out.println("==Close The Database==");
	}
}
