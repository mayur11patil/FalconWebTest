package com.falcon.falconwebtest.constants;

import java.io.File;

public class FalconProjectPath {
	
	/**
	 * File.separator: Platform dependent default name-separator character as String. For windows, 
	 * it’s ‘\’ and for unix it’s ‘/’.
	 */
	public static final String USER_HOME = System.getProperty("user.dir") + File.separator;
	public static final String RESOURCES_HOME = USER_HOME + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator;
	
	public static final String TESTDATA_HOME =  RESOURCES_HOME + "testdata" + File.separator;
	
	public static final String LOCATORS_HOME = RESOURCES_HOME + File.separator + "locators" + File.separator;

}
