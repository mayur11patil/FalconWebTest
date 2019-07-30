package com.falcon.falconwebtest.ui.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.falcon.falconwebtest.ui.selenium.enums.LocatorType;
import com.falcon.falconwebtest.utils.CommanUtils;
import com.falcon.falconwebtest.utils.Reporter;

public class PageObjectActions {
	
	Reporter report = new Reporter();
	CommanUtils commanUtil = new CommanUtils();
	//WebDriver driver;
	
	
	/*public PageObjectActions(WebDriver  driver) {
		this.driver = driver;
	}*/

	public boolean click(WebDriver driver, LocatorType locator, String locatorValue,long timeOutInSeconds) {

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean isClicked = true;

		try {
			switch (locator) {
			case CLASSNAME:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
				driver.findElement(By.className(locatorValue)).click();
				break;
			case CSSSELECTOR:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
				driver.findElement(By.cssSelector(locatorValue)).click();
				break;
			case ID:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
				driver.findElement(By.id(locatorValue)).click();
				break;
			case LINKTEXT:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
				driver.findElement(By.linkText(locatorValue)).click();
				break;
			case NAME:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
				driver.findElement(By.name(locatorValue)).click();
				break;
			case PARTIALLINKTEXT:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
				driver.findElement(By.partialLinkText(locatorValue)).click();
				break;
			case TAGNAME:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
				driver.findElement(By.tagName(locatorValue)).click();
				break;
			case XPATH:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
				driver.findElement(By.xpath(locatorValue)).click();
				break;
			default:
				break;
			}
		} catch (IllegalArgumentException illegalArgumentException) {
			isClicked = false;
			report.info("Locator type doesn't exist" + illegalArgumentException.getCause());
		} catch (NullPointerException nullPointerException) {
			isClicked = false;
			report.info("Locator type doesn't exist " + nullPointerException.getCause());
		}
		catch(Exception e) {
			isClicked = false;
		}
		
		return isClicked;

	}

}
