package com.falcon.falconwebtest.constants;



public class UiResourcePath extends FalconProjectPath {
	
	public static String getTestDataFilePath() {
		String CS_TEST_DATA_FILE;
		CS_TEST_DATA_FILE = TESTDATA_HOME + ".xlsx";
		return CS_TEST_DATA_FILE;
	}
	
	/**
	 * properties file paths
	 */

	public static final String DASHBOARD_HOME = LOCATORS_HOME + "dashboard_home.properties";
	public static final String LOGIN_PAGE = LOCATORS_HOME + "";
	public static final String DASHBOARD_PAGE = LOCATORS_HOME + "";
	
	
	/**
	 * Excel File Path
	 */
	
	public static final String TEST_DATA_ADMIN_SHEET="";
	
}
