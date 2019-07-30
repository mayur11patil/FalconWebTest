package com.falcon.falconwebtest.ui.selenium;

import org.openqa.selenium.WebDriver;

import com.falcon.falconwebtest.ui.seleniuminterface.IBrowser;

public class Browser implements IBrowser {
	
	WebDriver driver;
	
	/**
	 * this method will open url 
	 * @param url : to be open
	 * @param browser
	 * @return boolean value
	 */
	public boolean openURL(String url, String browser) {
		boolean isOpenURL = false;
		
		RunModeLocal runMode = new RunModeLocal(browser);
		this.driver = runMode.getDriver();
		System.out.println("2nd "+driver);
		isOpenURL = validateURL(url);

		return isOpenURL;
	}

	public boolean validateURL(String url) {
		driver.get(url);
		return true;
	}
	public boolean closeBrowser() {
		driver.close();
		return false;
	}

	public boolean quitBrowser() {
		System.out.println("3 quit "+driver);
		driver.quit();
		System.out.println("quit browser called");
		return false;
	}

	public boolean openUrl(String url, WebDriver driver) {
		
		driver.get(url);
		return true;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
