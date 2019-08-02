package com.atmecs.falconrepoertdashboard.testscripts.recentruns;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.atmecs.falconrepoertdashboard.helpers.DashboardHelper;
import com.atmecs.falconrepoertdashboard.helpers.LoginHelpers;
import com.atmecs.falconrepoertdashboard.testsuite.TestSuiteBase;
import com.atmecs.falconrepoertdashboard.utils.PropertyParser;
import com.atmecs.falconrepoertdashboard.utils.Reporter;
import com.atmecs.falconrepoertdashboard.verifyresult.VerifyResult;

public class TestRecentRunJob extends TestSuiteBase {

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
	public void testRecentRunsJob() {
		verification.verifyTrue(dashboardHelper.navigateToRecentRuns(driver), "Verify Recent run page appears");
		verification.verifyTrue(dashboardHelper.verifyProductNameOnViewPage(driver), "verify after click on product it goes on view page");	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
