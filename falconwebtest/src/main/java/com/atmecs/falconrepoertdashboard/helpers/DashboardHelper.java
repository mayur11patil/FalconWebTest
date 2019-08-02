package com.atmecs.falconrepoertdashboard.helpers;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.atmecs.falconrepoertdashboard.pages.Dashboard;

public class DashboardHelper {
	
	Dashboard dashboard = new Dashboard();
	
	public boolean navigateToRecentRuns(WebDriver driver) {
		 dashboard.clickOnMenuLinks(driver,"Recent Runs");
		 return dashboard.isRecentRunPageDispaly(driver);
	}
	
	public boolean cpageIn(WebDriver driver) {
		dashboard.clickOnPageIntion(driver);
		return true;
	}
	
	public void getAll(WebDriver driver) {
		dashboard.clickNextPageAndGetListOfAllProduct(driver);
		System.out.println(dashboard.clickNextPageAndGetListOfAllProduct(driver).size());
	}
	
	public boolean verifyHeaderSorting(WebDriver driver) {
		
		List<String> originalList = dashboard.clickNextPageAndGetListOfAllProduct(driver);
		System.out.println("original "+originalList.toString());
		List<String> expAscList = originalList;
		Collections.sort(expAscList);
		System.out.println("expect "+expAscList.toString());
		
		List<String> expDesclist = originalList;
		Collections.sort(expDesclist, Collections.reverseOrder());
		System.out.println("expdesc "+expDesclist.toString());
		
		dashboard.clickOnFirstPage(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dashboard.clickSortHeader(driver, "Product Name");
		List<String> actualDescList = dashboard.clickNextPageAndGetListOfAllProduct(driver);
		System.out.println("actual desc"+actualDescList.toString());
		
		return actualDescList.equals(expDesclist);
		
	}
	
	
	public boolean verifyProductNameOnViewPage(WebDriver driver) {
		String productName = "REST API TEST RESULT";
		dashboard.clicOnkProductByName(driver, productName);
		return true;
	}

	
}
