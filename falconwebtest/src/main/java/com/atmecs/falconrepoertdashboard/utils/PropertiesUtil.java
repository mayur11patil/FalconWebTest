package com.atmecs.falconrepoertdashboard.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	static Report report = new Report();
	
	public static Properties loadProperty(String propertiesFilePath) {
		Properties properties = new Properties();
		PropertyParser propertyParser = new PropertyParser();

		try {
			properties = propertyParser.loadProperty(propertiesFilePath);
		} catch (IOException ioException) {
			System.out.println("IOException occured as " + ioException.getMessage());
			report.info("IOException occured as " + ioException.getMessage());
			return null;
		}

		return properties;
	}
}
