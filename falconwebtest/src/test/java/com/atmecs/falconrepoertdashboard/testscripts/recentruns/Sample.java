package com.atmecs.falconrepoertdashboard.testscripts.recentruns;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.falconrepoertdashboard.helpers.DashboardHelper;
import com.atmecs.falconrepoertdashboard.helpers.LoginHelpers;
import com.atmecs.falconrepoertdashboard.testsuite.TestSuiteBase;
import com.atmecs.falconrepoertdashboard.utils.PropertyParser;
import com.atmecs.falconrepoertdashboard.utils.Reporter;
import com.atmecs.falconrepoertdashboard.verifyresult.VerifyResult;

public class Sample extends TestSuiteBase {
	
		Reporter report = new Reporter();
		String sheetName="";
		LoginHelpers loginhelper = new LoginHelpers(sheetName);
		DashboardHelper dashboardHelper = new DashboardHelper();
		VerifyResult verification = new VerifyResult();
		
		
		@BeforeTest
		public void preSetup() {
			String webURL=PropertyParser.readEnvOrConfigProperty("application_url");
			driver = loginhelper.launchURL(webURL, browserName);		
		}
		
		@Test
		public void test() {
			verification.verifyTrue(dashboardHelper.navigateToRecentRuns(driver), "Verify Recent run page appears");
			//dashboardHelper.cpageIn(driver);
			//dashboardHelper.getAll(driver);
			verification.verifyTrue(dashboardHelper.verifyHeaderSorting(driver), "sort work");
			//Assert.assertTrue(dashboardHelper.verifyHeaderSorting(driver));
			System.out.println("workingggggg");
		}
		@Test
		public void test2() {
			
		}
		
		@AfterMethod
		public void tearDown() {
			//driver.quit();
		}
		
}
