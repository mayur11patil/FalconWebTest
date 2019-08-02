package com.atmecs.falconrepoertdashboard.uiaction;

import org.openqa.selenium.WebDriver;


public class Browser {
	
	WebDriver driver;
	
	/**
	 * this method will open url 
	 * @param url : to be open
	 * @param browser
	 * @return boolean value
	 */
	public boolean openURL(String url, String browser) {
		boolean isOpenURL = false;
		
		CreateDriver createObj = new CreateDriver(browser);
		this.driver = createObj.getDriver();
		isOpenURL = getUrl(url);

		return isOpenURL;
	}
	
	public boolean getUrl(String url) {
		driver.get(url);
		return true;
	}
	public boolean closeBrowser() {
		driver.close();
		return false;
	}

	public boolean quitBrowser() {
		driver.quit();
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
