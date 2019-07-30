package com.falcon.falconwebtest.ui.selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.falcon.falconwebtest.ui.selenium.enums.BrowserType;
import com.falcon.falconwebtest.utils.Reporter;



public class RunModeLocal {
	
	Reporter report = new Reporter();
	WebDriver driver;
	
	
	/**
	 * this method will set browser as per parameter passed.
	 * chrome, firefox or internet explorer
	 * @param browser
	 */
	public RunModeLocal(String browser) {
		System.out.println("in run local mode");
		try
		{
		switch (BrowserType.valueOf(browser)) {
		case CHROME:{
				System.out.println("in chrome set");
				this.driver = setChromeDriver();
				System.out.println("1 st"+driver);
				report.info("Chrome driver set :"+driver);
				break;
			}
		case FIREFOX:
				this.driver = setFirefoxDriver();
				report.info("Firefox driver set: "+driver);
				break;
			
		case IE:
				this.driver = setInterExplorerDriver();
				report.info("Internet driver set "+driver);
		default:
			break;
			}
		}
		catch(NullPointerException ne) {
			System.out.println("browser is null");
		}
		catch(Exception e) {
			
		}
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	private WebDriver setChromeDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.chrome.driver", currentdir + "chromedriver.exe");
		
		return new ChromeDriver();
	}
	
	private WebDriver setFirefoxDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.gecko.driver", currentdir + "geckodriver.exe");
		
		return new FirefoxDriver();
	}
	
	public WebDriver setInterExplorerDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.ie.driver", currentdir + "IEDriverServer.exe");
		
		return new InternetExplorerDriver();
	}


}
