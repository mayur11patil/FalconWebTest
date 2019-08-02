package com.atmecs.falconrepoertdashboard.utils;


import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

public class Reporter {
	
	Logger logger = null;
	
	public Reporter() {
		getlogger();
		logger = Logger.getLogger(Reporter.class.getName());
	}
	
	public void getlogger() {
		PropertyConfigurator.configure("D:\\codepractice\\falconwebtest\\src\\main\\resources\\log4j.properties");
	}

	public void info(String message){
		logger.info(message);
	}
	
	public void debug(String message){
		
	}
}
