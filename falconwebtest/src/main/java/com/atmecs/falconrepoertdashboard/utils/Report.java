package com.atmecs.falconrepoertdashboard.utils;


import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import com.atmecs.falconrepoertdashboard.constants.ResourcePath;

public class Report {
	
	Logger logger = null;
	
	public Report() {
		getlogger();
		logger = Logger.getLogger(Report.class.getName());
	}
	
	public void getlogger() {
		PropertyConfigurator.configure(ResourcePath.LOG4J_PROPERTIES_FILE);	
	}

	public void info(String message){
		logger.info(message);
	}
	
	public void debug(String message){
		
	}
}
