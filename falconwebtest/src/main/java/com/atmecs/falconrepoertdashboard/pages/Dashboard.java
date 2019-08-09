package com.atmecs.falconrepoertdashboard.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.atmecs.falconrepoertdashboard.constants.TimeOuts;
import com.atmecs.falconrepoertdashboard.constants.ResourcePath;
import com.atmecs.falconrepoertdashboard.uiaction.PageObjectActions;
import com.atmecs.falconrepoertdashboard.uiaction.enums.LocatorType;
import com.atmecs.falconrepoertdashboard.utils.CommanUtils;
import com.atmecs.falconrepoertdashboard.utils.PropertiesUtil;
import com.atmecs.falconrepoertdashboard.utils.Report;


public class Dashboard {
	
	Report report = new Report();
	CommanUtils commanutil = new CommanUtils();
	
	
	static Properties dashBoard = PropertiesUtil.loadProperty(ResourcePath.DASHBOARD_HOME);
	static Properties recentRunsProps = PropertiesUtil.loadProperty(ResourcePath.RECENT_RUNS_PAGE);
	PageObjectActions action = new PageObjectActions();
	
	/* All getters to get the xpath of particular object
	 *  
	 */
	public String getFalconLogoIcon() {
		return recentRunsProps.getProperty("falcon_logo");
	}
	public String getMainMenuLinks(String menuName) {
		return dashBoard.getProperty("main_menu_link").replace("xxxxx", menuName);
	}
	public String getNextIconOfPageIntion() {
		return recentRunsProps.getProperty("next_icon_pagintion");
	}
	public String getLastNoOfPageIntion() {
		return recentRunsProps.getProperty("last_no_of_pageintion");
	}
	public String getListOfAllProductName() {
		return recentRunsProps.getProperty("list_of_all_productname");
	}
	public String getHeader(String headername) {
		return recentRunsProps.getProperty("header_name").replace("xxxxx", headername);
	}
	public String getFirstPage() {
		return recentRunsProps.getProperty("first_page_no");
	}
	public String getProductnameByName(String productName) {
		return recentRunsProps.getProperty("productname_by_name").replace("xxxxx", productName);
	}
	public String getRecentRunPageHeading() {
		return recentRunsProps.getProperty("recentrun_page");
	}
	public String getPreloader() {
		return recentRunsProps.getProperty("preloader_div");
	}
		
	
	/* All page actions
	 * 
	 */
	
	//All click actions
	public boolean clickOnFalconLogo(WebDriver driver) {
		boolean isclicked = false;
		if(commanutil.isElementPresentAndClickable(driver, getFalconLogoIcon())) {
			isclicked = action.click(driver, LocatorType.XPATH, getFalconLogoIcon(), 10);
		}
		return isclicked;
	}
	
	public boolean clickOnMenuLinks(WebDriver driver,String menuName) {
		boolean isClick = false;
		if(commanutil.invisibilityOfElement(driver, getPreloader())) {
		isClick = commanutil.ignoreClickInterceptAndClickOnElement(driver, getMainMenuLinks(menuName));}
		report.info("click on menu link "+menuName +" :"+isClick);
		return isClick;
	}
	
	
	public boolean clickOnNextPageInition(WebDriver driver) {
		boolean isclicked = false;
		if(commanutil.isElementPresentAndClickable(driver, getNextIconOfPageIntion())) {
			isclicked = action.click(driver, LocatorType.XPATH, getNextIconOfPageIntion(), 10);
		}
		return isclicked;
	}
	
	public List<String> clickNextPageAndGetListOfAllProduct(WebDriver driver) {	
		List<WebElement> list= new ArrayList<WebElement>();
		List<WebElement> listOfWebelementOnfirstPage=null;
		List<String> listOfAllFromAllPages = new ArrayList<String>();
		
		WebElement element;
		
		int totalNoOfPages;
		String totalInString = driver.findElement(By.xpath(getLastNoOfPageIntion())).getText();
		totalNoOfPages  = Integer.parseInt(totalInString);
		int counter = 0;
		
		do{
			listOfWebelementOnfirstPage = driver.findElements(By.xpath(getListOfAllProductName()));
			for(int i=1; i<=listOfWebelementOnfirstPage.size(); i++) {

				String productNameXpath=(String) "(//td[1])[xxxx]".replace("xxxx", Integer.toString(i));
				element = driver.findElement(By.xpath(productNameXpath));
				
				//list.add(element);
				listOfAllFromAllPages.add(element.getText());
				
			}counter++;
			if(commanutil.isElementPresentAndClickable(driver, getNextIconOfPageIntion())) {
				action.click(driver, LocatorType.XPATH, getNextIconOfPageIntion(), 10);
			}
		}while(counter<totalNoOfPages);
		return listOfAllFromAllPages;
	}
	
		
	public void clickSortHeader(WebDriver driver, String headerName) { //partially it is asc
		commanutil.scrollIntoView(driver, false, driver.findElement(By.xpath(getHeader(headerName))));
		action.click(driver, LocatorType.XPATH, getHeader(headerName), 10);
	}
	
	public void clickOnFirstPage(WebDriver driver) {
		action.click(driver, LocatorType.XPATH, getFirstPage(), 10);
	}
	
	public boolean clicOnkProductByName(WebDriver driver, String productName) {
		boolean isclicked = false;
		if(commanutil.invisibilityOfElement(driver, getPreloader())) {
		isclicked = action.click(driver, LocatorType.XPATH, getProductnameByName(productName), 10);}
		System.out.println("clicked on product "+productName+" :"+isclicked);
		return isclicked;
	}
	
	//isdisplay
	public boolean isRecentRunPageDispaly(WebDriver driver) {
		boolean isDisplay = false;
		
		if(commanutil.invisibilityOfElement(driver, getPreloader())) {
		isDisplay = commanutil.isElementVisible(driver, getRecentRunPageHeading());}
		report.info("Recent runs page appears :"+isDisplay);
		return isDisplay;
	}

	
}
