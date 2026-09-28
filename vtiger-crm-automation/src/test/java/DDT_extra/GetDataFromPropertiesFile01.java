package DDT_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile01 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\YINFO\\OneDrive\\Desktop\\PropertiesData.properties");
		
		Properties pObj = new Properties();
		
		pObj.load(fis);
		
		String url = pObj.getProperty("url");
		String Uname = pObj.getProperty("un");
		String PWD = pObj.getProperty("pwd");
		
		System.out.println(url);
		System.out.println(Uname);
		System.out.println(PWD);

	}

}
