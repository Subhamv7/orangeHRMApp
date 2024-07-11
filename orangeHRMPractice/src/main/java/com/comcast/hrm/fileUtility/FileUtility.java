package com.comcast.hrm.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromFile(String key) throws IOException {
	
	FileInputStream fis = new FileInputStream("./commonData/config_data.properties");
	Properties pObj = new Properties();
	pObj.load(fis);
	String data = pObj.getProperty(key);
	return data;
	
	}
	
}
