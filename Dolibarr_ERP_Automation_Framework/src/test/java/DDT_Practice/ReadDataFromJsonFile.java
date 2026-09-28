package DDT_Practice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
	//	FileReader fr = new FileReader("./src/test/resources/JSONData.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./src/test/resources/JSONData.json"));
		JSONObject jobj = (JSONObject) obj;
		
		String Name = jobj.get("Name").toString();
		String Timeout = jobj.get("TimeOut").toString();
		String browser = jobj.get("Browser").toString();
		String Url = jobj.get("URL").toString();
		System.out.println(Timeout);
		System.out.println(Name);
	//	System.out.println(browser);
	//	System.out.println(Url);
		System.out.println(jobj.get("Browser"));
		System.out.println(jobj.get("URL"));

	}

}
