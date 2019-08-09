package com.atmecs.falconrepoertdashboard.helpers;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.atmecs.falconrepoertdashboard.pages.Dashboard;

public class DashboardHelper {
	
	Dashboard dashboard = new Dashboard();
	/*
	 * below method navigate to the recent runs page from main page of application.
	 */
	public boolean navigateToRecentRuns(WebDriver driver) {
		 dashboard.clickOnMenuLinks(driver,"Recent Runs");
		 return dashboard.isRecentRunPageDispaly(driver);
	}
	/*
	 * below method checks wheather after click on productname header it will sort the, 
	 * product name in ascending order or not
	 */
	public boolean verifyHeaderSorting(WebDriver driver) {
		
		List<String> originalList = dashboard.clickNextPageAndGetListOfAllProduct(driver);
		
		List<String> expAscList = originalList;
		Collections.sort(expAscList);
		
		List<String> expDesclist = originalList;
		Collections.sort(expDesclist, Collections.reverseOrder());
		
		dashboard.clickOnFirstPage(driver);
		
		dashboard.clickSortHeader(driver, "Product Name");
		List<String> actualDescList = dashboard.clickNextPageAndGetListOfAllProduct(driver);
		
		return actualDescList.equals(expDesclist);
		
	}
	/*
	 * below method checks whether after click on particylar product it goes,
	 * to the view page or not
	 */
	public boolean verifyProductNameOnViewPage(WebDriver driver) {
		String productName = "REST API TEST RESULT";
		
		return dashboard.clicOnkProductByName(driver, productName);
	}

}
