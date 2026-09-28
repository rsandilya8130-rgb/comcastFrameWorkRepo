package Practice;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethodPracticeTest {
	
	@Test
	public void Login() {
		System.out.println("Login Completed");
		//Assert.fail();
	}
	
	@Test(dependsOnMethods = "Login")
	public void ClickOnOrg() {
		Assert.fail();
		System.out.println("Clicked on Org....Completed");
		
	}
	
	@Test(dependsOnMethods = "ClickOnOrg")
	public void CreateOrg() {
		System.out.println("Org Created....Completed");
	}
	@Test(dependsOnMethods = "Login")
	public void LogOut() {
		Reporter.log("Logout Completed",true);
	}

}
