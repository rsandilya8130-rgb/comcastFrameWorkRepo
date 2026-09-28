package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class SuiteExecuteonlyFailedTest  extends BaseClass{
	@Test
	public void createInvoiceTest() {
		System.out.println("execute createIncoiceTest");
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "Home");
		System.out.println("===Step-1===");
		System.out.println("===Step-2===");
		System.out.println("===Step-3===");
		System.out.println("===Step-4===");
	}

	@Test
	public void createInvoicewithcontacttest() {
		System.out.println("execute createInvoicewithContactTest");
		System.out.println("===Step-1===");
		System.out.println("===Step-2===");
		System.out.println("===Step-3===");
		System.out.println("===Step-4===");
	}

}
