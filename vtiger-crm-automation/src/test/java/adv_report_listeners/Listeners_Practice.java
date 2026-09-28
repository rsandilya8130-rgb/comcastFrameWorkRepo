package adv_report_listeners;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(adv_report_listeners.List_Imp.class)
public class Listeners_Practice {
	
	@Test
	public void Case1() {
		System.out.println("It is Case one ....");
	}
	
	@Test(dependsOnMethods = "Case1")
	public void Case2() {
		Assert.assertTrue(false);
		System.out.println("It is Case two....");
	}
	
	@Test(dependsOnMethods = "Case2")
	public void Case3() {
		System.out.println("It is Case three....");
	}

}
