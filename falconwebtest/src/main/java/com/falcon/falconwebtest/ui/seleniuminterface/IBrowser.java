package com.falcon.falconwebtest.ui.seleniuminterface;

import org.openqa.selenium.WebDriver;

public interface IBrowser {
	
	public boolean openUrl(String url, WebDriver driver);
	
	public boolean closeBrowser();
	
	public boolean quitBrowser();

}
