package com.atmecs.falconrepoertdashboard.verifyresult;

import org.testng.Assert;
import org.testng.Reporter;

import com.atmecs.falconrepoertdashboard.utils.Report;

public class VerifyResult {

	Report report = new Report();

	public boolean verifyBoolean(boolean actual, boolean expected, String message) {
		try {
			Assert.assertEquals(actual, expected);
			report.info("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
			Reporter.log("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
			return true;
		} catch (AssertionError assertionError) {
			return false;
		}
	}

	public boolean verifyTrue(boolean condition, String message) {
		boolean result = true;
		try {
			Assert.assertTrue(condition);
			report.info("PASS : " + message);
			Reporter.log("PASS : " + message);
			result = true;
		} catch (AssertionError assertionError) {

			result = false;
		}
		return result;

	}


}
