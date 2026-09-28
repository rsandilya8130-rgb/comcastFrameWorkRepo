package DDT_extra;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetDataFromJsonFile {

	public static  void main(String[] args) throws IOException, ParseException {  
		
	//  Step1> Create the java representative object of the physical file
		FileReader fr = new FileReader("./src/test/resources/commandata.json");
		
		// Step 2 parse it to java Object ...
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		
		// Step 3 downcast it to JSONObject
		JSONObject jobj = (JSONObject) obj;
		
		// Step 4 by using get() and passing key, get the value and convert to string 
		String browser = jobj.get("bro").toString();
		String URL = jobj.get("url").toString();		String UserName = jobj.get("un").toString();		String Password = jobj.get("pwd").toString();
		
		
		System.out.println(browser);
		System.out.println(URL);
		System.out.println(UserName);
		System.out.println(Password);
	}

}
