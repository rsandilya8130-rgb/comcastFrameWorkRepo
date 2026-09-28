package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice2 {

	@DataProvider
	public Object[][] getData() {
		Object[][] ObjArr = new Object[3][3];
		ObjArr[0][0] = "Rahul";
		ObjArr[0][1] = "Thakur";
		ObjArr[0][2] = 8076874453l;
		ObjArr[1][0] = "Bittu";
		ObjArr[1][1] = "Sandilya";
		ObjArr[1][2] = 8130434677l;
		ObjArr[2][0] = "Divyam";
		ObjArr[2][1] = "Thakur";
		ObjArr[2][2] = 8076874453l;

		return ObjArr;
	}

	@Test(dataProvider = "getData")
	public void CreateContactWithPhoneTest(String firstname, String lastname,long phoneNo) {

		System.out.println("FirstName " + firstname + " LastName " + lastname +" PhoneNo "+ phoneNo);
	}

}
