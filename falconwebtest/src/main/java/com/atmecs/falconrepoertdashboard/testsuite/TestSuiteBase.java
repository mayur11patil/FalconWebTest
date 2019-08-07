package com.atmecs.falconrepoertdashboard.testsuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.atmecs.falconrepoertdashboard.uiaction.Browser;
import com.atmecs.falconrepoertdashboard.utils.PropertyParser;
import com.beust.jcommander.Parameter;


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
