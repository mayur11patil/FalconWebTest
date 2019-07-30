package com.falcon.falconwebtest.verifyresult;

import org.testng.Assert;

import com.falcon.falconwebtest.utils.Reporter;

public class VerificationManager {

	Reporter report = new Reporter();

	public boolean verifyBoolean(boolean actual, boolean expected, String message) {
		try {
			Assert.assertEquals(actual, expected);
			report.info("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
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
			result = true;
		} catch (AssertionError assertionError) {

			result = false;
		}
		return result;

	}


}
