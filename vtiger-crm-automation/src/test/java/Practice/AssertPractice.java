package Practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {

	@Test
	public void AssertPracticeTest() {

		Reporter.log("==Step-1==",true);
		Reporter.log("==Step-2==",true);
		Reporter.log("==Step-3==",true);
		Assert.assertEquals("Home", "Home");
		Reporter.log("==Step-4==",true);
		Reporter.log("==Step-5==",true);
		Reporter.log("==Step-6==",true);

	}

	@Test
	public void assertpractice1() {
		Reporter.log("==Step-1==");
		Reporter.log("==Step-2==");
		Reporter.log("==Step-3==");
		Assert.assertTrue(true);
		Reporter.log("==Step-4==");
		Reporter.log("==Step-5==");
		Reporter.log("==Step-6==");

	}

	@Test
	public void SoftAssertPracticeTest() {

		SoftAssert sf = new SoftAssert();
		System.out.println("==Step-1==");
		System.out.println("==Step-2==");
		System.out.println("==Step-3==");
		sf.assertEquals("Home", "Home");
		System.out.println("==Step-4==");
		System.out.println("==Step-5==");
		System.out.println("==Step-6==");

		sf.assertAll();
	}
}
