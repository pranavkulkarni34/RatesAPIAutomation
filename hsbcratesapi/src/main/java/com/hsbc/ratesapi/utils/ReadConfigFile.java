package com.hsbc.ratesapi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static com.hsbc.ratesapi.utils.Constants.PROPERTIESPATH;

public class ReadConfigFile {
	
	public static Properties properties = null;

	public ReadConfigFile() {
		
		if(properties == null) {
			
			try {
				
				properties = new Properties();
				
				properties.load(new FileInputStream(new File(PROPERTIESPATH)));
				
			}catch(IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public String getProperty(String key) {
		
		return properties.getProperty(key);
		
	}

}
