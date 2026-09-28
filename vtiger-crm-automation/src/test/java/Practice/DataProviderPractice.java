package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@DataProvider
	public Object[][] getData() {
		Object[][] ObjArr = new Object[3][2];
		ObjArr[0][0] = "Rahul";
		ObjArr[0][1] = "Thakur";
		ObjArr[1][0] = "Bittu";
		ObjArr[1][1] = "Sandilya";
		ObjArr[2][0] = "Divyam";
		ObjArr[2][1] = "Thakur";

		return ObjArr;
	}

	@Test(dataProvider = "getData")
	public void CreateContactTest(String firstname, String lastname) {

		System.out.println("FirstName " + firstname + " LastName " + lastname);
	}

}
