package com.comcast.hms.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromPropertiesFile(String key) throws Throwable
	{
		//Read the data from Property File
		FileInputStream fis=new FileInputStream("src/test/resources/commondata.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String	data = pObj.getProperty(key);
		return data;
				
	}

	public String getRandomEmail() {
		// TODO Auto-generated method stub
		return getRandomEmail();
	}

}
