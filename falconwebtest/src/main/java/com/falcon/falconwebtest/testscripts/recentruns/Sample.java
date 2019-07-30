package com.falcon.falconwebtest.testscripts.recentruns;


import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.falcon.falconwebtest.helpers.DashboardHomeHelper;
import com.falcon.falconwebtest.helpers.LoginHelpers;
import com.falcon.falconwebtest.utils.PropertyParser;
import com.falcon.falconwebtest.utils.Reporter;
import com.falcon.falconwebtest.verifyresult.VerificationManager;
import com.falcon.falconwetest.testsuite.TestSuiteBase;

public class Sample extends TestSuiteBase {
	
		Reporter report = new Reporter();
		String sheetName="";
		LoginHelpers loginhelper = new LoginHelpers(sheetName);
		DashboardHomeHelper dashboardHelper = new DashboardHomeHelper();
		VerificationManager verification = new VerificationManager();
		
		
		@BeforeTest
		public void preSetup() {
			String webURL=PropertyParser.readEnvOrConfigProperty("application_url");
			driver = loginhelper.launchURL(webURL, browserName);		
		}
		
		@Test
		public void test() {
			verification.verifyTrue(dashboardHelper.navigateToRecentRuns(driver), "Verify Recent run page appears");
			dashboardHelper.cpageIn(driver);
			dashboardHelper.getAll(driver);
		}
		
		@AfterMethod
		public void tearDown() {
			//driver.quit();
		}
		
}
