package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;

public class JsonUtility {

	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader fr = new FileReader("./configAppData/commanData.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		JsonObject Jobj = (JsonObject) obj;
		String data = Jobj.get(key).toString();
		return data;
	}
}
