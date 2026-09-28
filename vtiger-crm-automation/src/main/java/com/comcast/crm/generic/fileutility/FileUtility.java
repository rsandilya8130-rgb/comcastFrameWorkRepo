package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties poj = new Properties();
		poj.load(fis);
		String data = poj.getProperty(key);
		return data;

	}
}
