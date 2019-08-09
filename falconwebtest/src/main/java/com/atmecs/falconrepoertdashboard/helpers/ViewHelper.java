package com.atmecs.falconrepoertdashboard.helpers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.falconrepoertdashboard.constants.ResourcePath;
import com.atmecs.falconrepoertdashboard.pages.ViewPage;
import com.atmecs.falconrepoertdashboard.utils.XlsReader;

public class ViewHelper {
	
	ViewPage viewPage = new ViewPage();
	XlsReader xlsReader = new XlsReader();
	
	/*
	 * below method checks that file is download or not 
	 */
	public boolean verifyFileDownload(WebDriver driver) {
		viewPage.clickOnkDownloadLink(driver);
		viewPage.verifyFileDownloaded(driver, ResourcePath.DOWNLOAD_FILE_PATH);
		return true;
	}
	
	/*
	 *  below method checks the test result from application and downloaded file matching or not
	 */
	public boolean verifyTestResultFromFile(WebDriver driver) {
		int totalTestRuns;
		int totalTestPass;
		int totalTestFail;
		
		int actualtotalTestCount = Integer.parseInt(xlsReader.getData(ResourcePath.DOWNLOAD_FILE_PATH, "Test Report", 8, 1));
		int actualtotalTestPassCount = Integer.parseInt(xlsReader.getData(ResourcePath.DOWNLOAD_FILE_PATH, "Test Report", 9, 1));
		int actualtotalTestFailCount = Integer.parseInt(xlsReader.getData(ResourcePath.DOWNLOAD_FILE_PATH, "Test Report", 10, 1));
		System.out.println("count "+actualtotalTestCount);
		
		totalTestRuns = viewPage.getTotalTestCount(driver);
		totalTestPass = viewPage.getPassTestStatusCount(driver);
		totalTestFail = viewPage.getFailTestStatusCount(driver);
		
		if(actualtotalTestPassCount == totalTestPass && actualtotalTestFailCount == totalTestFail && actualtotalTestCount == totalTestRuns) {
		return true;}
		else {
			return false;
		}
	}

}
