package com.falcon.falconwetest.testsuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.falcon.falconwebtest.ui.selenium.Browser;
import com.falcon.falconwebtest.utils.PropertyParser;


public class TestSuiteBase {
	
	protected WebDriver driver;
	protected Browser browser;

	//setting all browser property
	protected String browserName = PropertyParser.readEnvOrConfigProperty("browserName");
	
	@BeforeSuite
    public void preSetup() {
        browser = new Browser();
    }


}
