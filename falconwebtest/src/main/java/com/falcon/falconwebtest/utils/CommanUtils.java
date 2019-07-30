package com.falcon.falconwebtest.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommanUtils {

	
	public static XlsReader getXlsReader(String testDataFile) {
		XlsReader xlsReader = new XlsReader();

		try {
			xlsReader.setPath(testDataFile);
			System.out.println("excel path set");
		} catch (IOException ioException) {
			return null;
		}
		return xlsReader;
	}
	
	public boolean isElementVisible(WebDriver driver, String xpath, long shortWaitTimeInSec) {

		WebDriverWait wait = new WebDriverWait(driver, shortWaitTimeInSec);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {
			
			return false;
		}
		return true;
	}
	
	public boolean isElementVisible(WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {
			
			return false;
		}
		return true;
	}

	public boolean isElementPresentAndClickable(WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

		} catch (Exception exception) {
			return false;
		}
		return true;
	}

	public void acceptAlertIfPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			//if(wait.until(ExpectedConditions.alertIsPresent())!=null)
				driver.switchTo().alert().accept();
		} catch (Exception exception) {
			
		}
	}
	
	public static boolean isDisplayed(WebDriver driver, String XPathIsDisplayed ) {
		boolean isDisplayed = false;
		try {
			isDisplayed = driver.findElement(By.xpath(XPathIsDisplayed)).isDisplayed();
		}catch(Exception e) {
			isDisplayed = false;
		}
		return isDisplayed;
	}
	
	public void selectByVisibleText(WebDriver driver, String locatorValue, String value) {
		Select dropdown;
		WebElement element;
			element=driver.findElement(By.xpath(locatorValue));
			dropdown=new Select(element);
			dropdown.selectByVisibleText(value);
	}
	
	public boolean waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectationComplete = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {

				
				if(driver.findElement(By.xpath("//div[@class='ph']")).isDisplayed()) {
					return true;
				}
				else {
					return false;
				}
			}
		};
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);

			wait.until(expectationComplete);
		} catch (Throwable error) {

			return false;
		}
		return true;
	}

	public List<WebElement> getListOfWebElement(WebDriver  driver,String locatorvalue){
		 List<WebElement> list = driver.findElements(By.xpath(locatorvalue));
		 return list;
	}
	
	public List<String> convertListFromWebElement(WebDriver driver, List<WebElement> list){
		List<String> textList = new ArrayList<String>();
		if(list.size()>0) {
			for(WebElement element:list) {
				textList.add(element.getText());
			}
		}
		return textList;
	}

}
