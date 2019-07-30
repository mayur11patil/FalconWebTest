package com.falcon.falconwebtest.helpers;

import org.openqa.selenium.WebDriver;

import com.falcon.falconwebtest.ui.selenium.Browser;


public class LoginHelpers {

	WebDriver driver;
	Browser browser = new Browser();
	
	String sheetName="";
	
	public LoginHelpers(String sheetName) {
		this.sheetName=sheetName;
	}
	
	
	public WebDriver launchURL(String webURL, String browserName) {
		
		browser.openURL(webURL, browserName);
		browser.getDriver().manage().window().maximize();
		
		return browser.getDriver();
	}
	
}
