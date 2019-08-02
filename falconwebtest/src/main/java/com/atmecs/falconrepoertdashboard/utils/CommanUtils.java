package com.atmecs.falconrepoertdashboard.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

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

	public boolean scrollIntoView(WebDriver driver,Boolean value,WebElement element)//mayur
	{
		boolean scrolledintoview=false;
		
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView("+value+");", element);
			scrolledintoview=true;
		}catch(Exception exception) {
			
		}
		
		return scrolledintoview;
	}
	
	public boolean verifyFileDownload(WebDriver driver, String filePath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
				
		File file = new File(filePath);
		if (file.exists()) 
		    file.delete(); //it will delete old file
		// Start downloading here.
		wait.until((ExpectedCondition<Boolean>) webDriver -> file.exists());
		if(file.exists()) {
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean ignoreClickInterceptAndClickOnElement(WebDriver driver,final String xpath) {
		FluentWait<WebDriver> fluentWait =  new FluentWait<WebDriver>( driver)
		.ignoring(ElementClickInterceptedException.class)
		.pollingEvery(1, TimeUnit.SECONDS)
		.withTimeout(30,TimeUnit.SECONDS);

		fluentWait.until(new Function<WebDriver, Boolean>() {
		public Boolean apply(WebDriver driver) {
		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
		return true;
		}
		});
		return true;
}
	
	public boolean invisibilityOfElement(WebDriver driver, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));

		} catch (Exception exception) {
			return false;
		}
		return true;
		
	}
}