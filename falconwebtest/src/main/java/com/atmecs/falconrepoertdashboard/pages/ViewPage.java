package com.atmecs.falconrepoertdashboard.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.falconrepoertdashboard.constants.ResourcePath;
import com.atmecs.falconrepoertdashboard.uiaction.PageObjectActions;
import com.atmecs.falconrepoertdashboard.uiaction.enums.LocatorType;
import com.atmecs.falconrepoertdashboard.utils.CommanUtils;
import com.atmecs.falconrepoertdashboard.utils.PropertiesUtil;
import com.atmecs.falconrepoertdashboard.utils.Report;

public class ViewPage {
	
	Report report = new Report();
	CommanUtils commanutil = new CommanUtils();
	
	static Properties viewPageProps = PropertiesUtil.loadProperty(ResourcePath.VIEW_PAGE);
	PageObjectActions action = new PageObjectActions();
	
	/** All getters
	 * 
	 */
	public String getDownloadLink() {
		return viewPageProps.getProperty("download_link");
	}

	public String getTotalPassLink() {
		return viewPageProps.getProperty("pass_test_links");
	}
	public String getTotalFailLink() {
		return viewPageProps.getProperty("fail_test_links");
	}
	public String getTotalTestLink() {
		return viewPageProps.getProperty("total_test_links");
	}
	public String getPreloader() {
		return viewPageProps.getProperty("preloader_div");
	}
	
	/** all actions
	 * 
	 */
	public boolean clickOnkDownloadLink(WebDriver driver) {
		boolean isClick = false;
		if(commanutil.invisibilityOfElement(driver, getPreloader())) {
		isClick = action.click(driver, LocatorType.XPATH, getDownloadLink(), 10);}
		report.info("CLick on download link :"+isClick);
		return isClick;
	}
	
	
	/**
	 * verify method
	 */
	
	public boolean verifyFileDownloaded(WebDriver driver, String filePath) {
		return commanutil.verifyFileDownload(driver, filePath);
	}
	
	//get element count
	public int getPassTestStatusCount(WebDriver driver) {
		int testCount=0;
		List<WebElement> listOfElement = driver.findElements(By.xpath(getTotalPassLink()));
		testCount = listOfElement.size();
		return testCount;
	}
	public int getFailTestStatusCount(WebDriver driver) {
		int testCount=0;
		List<WebElement> listOfElement = driver.findElements(By.xpath(getTotalFailLink()));
		testCount = listOfElement.size();
		return testCount;
	}
	public int getTotalTestCount(WebDriver driver) {
		int testCount=0;
		List<WebElement> listOfElement = driver.findElements(By.xpath(getTotalTestLink()));
		testCount = listOfElement.size();
		return testCount;
	}

}
