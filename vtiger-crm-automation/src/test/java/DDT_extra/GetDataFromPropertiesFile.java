package DDT_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//  Step1> Create the java representative object of the physical file
		
		FileInputStream fle = new FileInputStream("./src/test/resources/commondata.properties");
		
		// Step2> By using load(), Load all the keys...
		Properties Pobj = new Properties();
		Pobj.load(fle);
		
		// Step3>  by using getProperty() and passing the key, get the value
	    String s=	Pobj.getProperty("bro");
		System.out.println(s);

	}

}
