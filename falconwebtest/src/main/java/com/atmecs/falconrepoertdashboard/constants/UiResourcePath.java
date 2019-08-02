package com.atmecs.falconrepoertdashboard.constants;



public class UiResourcePath extends ProjectPath {
	
	public static String getTestDataFilePath() {
		String CS_TEST_DATA_FILE;
		CS_TEST_DATA_FILE = TESTDATA_HOME + ".xlsx";
		return CS_TEST_DATA_FILE;
	}
	
	/**
	 * download file path
	 */
	public static final String DOWNLOAD_FILE_PATH = DOWNLOAD_HOME + "TestReport-REST API TEST RESULT-Web Services-08-02-2019.xlsx";
	
	/**
	 * properties file paths
	 */

	public static final String DASHBOARD_HOME = LOCATORS_HOME + "dashboard_home.properties";
	public static final String VIEW_PAGE = LOCATORS_HOME + "view.properties";
	public static final String RECENT_RUNS_PAGE = LOCATORS_HOME + "recentruns.properties";
	
	
	/**
	 * Excel File Path
	 */
	
	public static final String TEST_DATA_ADMIN_SHEET="";
	
	/**
	 * TestNG xml path
	 */
	public static final String TESTNG_XML_PATH = USER_HOME + "testng.xml";
}
