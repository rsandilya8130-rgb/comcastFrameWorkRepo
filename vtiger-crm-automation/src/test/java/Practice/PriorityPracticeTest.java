package Practice;

import org.testng.annotations.Test;

public class PriorityPracticeTest {

	@Test
	public void createcontectTest() {
		System.out.println("contact created");
	}
	
	@Test(priority = 1)
	public void modifyContactTest() {
  		System.out.println("Contact Modifyed");
	}
	
	@Test(priority = 2)
	public void DeleteContactTest() {
		System.out.println("Contact Deleted");
	}
}
