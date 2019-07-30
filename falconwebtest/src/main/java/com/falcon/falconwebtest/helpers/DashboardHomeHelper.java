package com.falcon.falconwebtest.helpers;

import org.openqa.selenium.WebDriver;

import com.falcon.falconwebtest.pages.DashboardHome;

public class DashboardHomeHelper {
	
	DashboardHome dashboard = new DashboardHome();
	
	public boolean navigateToRecentRuns(WebDriver driver) {
		 dashboard.clickOnMenuLinks(driver,"Recent Runs");
		 return dashboard.isRecentRunPageDispaly(driver);
	}
	
	public boolean cpageIn(WebDriver driver) {
		dashboard.clickOnPageIntion(driver);
		return true;
	}
	
	public void getAll(WebDriver driver) {
		System.out.println(dashboard.clickNextPageAndGetListOfAllProduct(driver).size());
	}

	
}
