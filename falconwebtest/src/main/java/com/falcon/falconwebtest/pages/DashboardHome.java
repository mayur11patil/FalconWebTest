package com.falcon.falconwebtest.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.falcon.falconwebtest.constants.TimeOuts;
import com.falcon.falconwebtest.constants.UiResourcePath;
import com.falcon.falconwebtest.ui.selenium.PageObjectActions;
import com.falcon.falconwebtest.ui.selenium.enums.LocatorType;
import com.falcon.falconwebtest.utils.CommanUtils;
import com.falcon.falconwebtest.utils.PropertiesUtil;
import com.falcon.falconwebtest.utils.Reporter;


public class DashboardHome {
	
	Reporter report = new Reporter();
	CommanUtils commanutil = new CommanUtils();
	
	//WebDriver driver;
	
	/*public DashboardHome(WebDriver driver) {
		this.driver = driver;
	}*/
	
	static Properties dashBoard = PropertiesUtil.loadProperty(UiResourcePath.DASHBOARD_HOME);
	PageObjectActions action = new PageObjectActions();
	
	/* All getters
	 * 
	 */
	public String getMainMenuLinks(String menuName) {
		return dashBoard.getProperty("main_menu_link").replace("xxxxx", menuName);
	}
	
	
	
	
	
	/* All page actions
	 * 
	 */
	
	//All click actions
	public boolean clickOnMenuLinks(WebDriver driver,String menuName) {
		boolean isClick = false;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		isClick = action.click(driver,LocatorType.XPATH, getMainMenuLinks(menuName), TimeOuts.WEDRIVER_WAIT_IN_SEC);
		report.info("click on menu link "+menuName +" :"+isClick);
		return isClick;
	}
	
	public boolean clickOnPageIntion(WebDriver driver) {
		boolean isclicked=false;
		isclicked = action.click(driver, LocatorType.XPATH, "(//a/span[contains(text(),'1')])[1]", 2);
		System.out.println("is clicked 1 +"+isclicked);
		return isclicked;
	}
	
	public boolean clickOnNextPageInition(WebDriver driver) {
		boolean isclicked = false;
		if(commanutil.isElementPresentAndClickable(driver, "//a[@ng-switch-when='next']")) {
			isclicked = action.click(driver, LocatorType.XPATH, "//a[@ng-switch-when='next']", 10);
		}
		return isclicked;
	}
	
	public List<WebElement> clickNextPageAndGetListOfAllProduct(WebDriver driver) {
		List<WebElement> list=null;
		List<WebElement> all=null;
		WebElement element;
		
		do{
			all = driver.findElements(By.xpath("//td[1]"));
			for(int i=1; i<=all.size(); i++) {
				System.out.println("size "+all.size());
				String a=(String) "(//td[1])[xxxx]".replace("xxxx", Integer.toString(i));
				//System.out.println(a);
				element = driver.findElement(By.xpath(a));
				//System.out.println(element);
				//list.add(element);
			}
			if(commanutil.isElementPresentAndClickable(driver, "//a[@ng-switch-when='next']")) {
				action.click(driver, LocatorType.XPATH, "//a[@ng-switch-when='next']", 10);
			}
		}while(commanutil.isElementPresentAndClickable(driver, "//a[@ng-switch-when='next']"));
			
			//list.add(driver.findElement(By.xpath("(//td[1])[1]")));	
		return list;
	}
	
	//isdisplay
	public boolean isRecentRunPageDispaly(WebDriver driver) {
		boolean isDisplay;
		isDisplay = commanutil.isElementVisible(driver, "//div/h3");
		report.info("Recent runs page appears+ "+isDisplay);
		return isDisplay;
	}

	
}
