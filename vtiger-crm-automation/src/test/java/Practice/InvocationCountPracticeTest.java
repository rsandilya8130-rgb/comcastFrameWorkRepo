package Practice;

import org.testng.annotations.Test;

public class InvocationCountPracticeTest {
	
	@Test(invocationCount = 10)
	public void CreateOrg() {
		String Org = "Org is created ====Pass===";
		System.out.println(Org);
	}
	
	
	

}
