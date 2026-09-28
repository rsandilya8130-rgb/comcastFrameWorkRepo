package Practice;

import org.testng.annotations.Test;

import com.crm.generic.baseutility.baseClass;

public class SimpleTest extends baseClass {
	
	@Test
	public void contectTest() {
		System.out.println("contact created");
	}
	
	@Test
	public void OrgTest() {
		System.out.println("Org created");
	}
	
	@Test
	public void OrgWithIndTest() {
		System.out.println("OrgWithIndTest is created");
	}

}
