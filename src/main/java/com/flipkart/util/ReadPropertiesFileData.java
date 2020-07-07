package com.flipkart.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFileData {
	InputStream inputStream;
	static ReadPropertiesFileData readData=new ReadPropertiesFileData();
	
	//Reading data from property file.
	public String getPropValue(String key,String propertiesFileName) throws Exception {
		String result = "";

		try {
			if (key != null && propertiesFileName != null) {
				Properties prop = new Properties();
				inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
				if (inputStream != null) {
					prop.load(inputStream);
					result = prop.getProperty(key);
				} else {
					throw new FileNotFoundException(
							"Property file '" + propertiesFileName + "'not found in the classpath.");
				}
			}
			else {
				throw new Exception("File Name or key is missing!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(inputStream!=null)
			inputStream.close();
		}

		return result;

	}
	
	//Read device details from property file
	public static String readDeviceDetails(String key) {
		String deviceDetails="";
		try {
		String propertiesFileName = "app-details.properties";
		deviceDetails=readData.getPropValue(key, propertiesFileName);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return deviceDetails;
	}
	
	//Reading locater value from property file.
	public static String readLocater(String key) {
		String locaterValue="";
		try {
			String propertiesFileName = "app-locater.properties";
			locaterValue=readData.getPropValue(key, propertiesFileName);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return locaterValue;
	}

}
