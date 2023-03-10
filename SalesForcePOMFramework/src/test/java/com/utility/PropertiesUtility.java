package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	private FileInputStream stream= null;
	private Properties propertyFile = null;

	public static String readPropertyData(String key) throws IOException {
		String curDir = System.getProperty("user.dir");
		System.out.println(curDir);
		FileInputStream fis = new FileInputStream(new File(curDir + "/src/test/resources/data.properties"));
		Properties ob = new Properties();
		ob.load(fis);
		String value = ob.getProperty(key);
		return value;
	}
	
	public Properties loadFile(String filename) {
		propertyFile = new Properties();
		String propertiesFilePath = null;
		switch(filename) {
		case "dataProperties":
			propertiesFilePath = Constants.DATA_PROPERTIES;
			break;
		}
		
			try {
				stream=new FileInputStream(propertiesFilePath);
				} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				propertyFile.load(stream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return propertyFile;
	}
	
	public String getPropertyValue(String key) {
		//propertyFile = new Properties();
		String value = propertyFile.getProperty(key);
		System.out.println("Property we got from the file : " + value);
		try {
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}
}
