package com.atmecs.falconrepoertdashboard.uiaction;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.atmecs.falconrepoertdashboard.constants.ProjectPath;
import com.atmecs.falconrepoertdashboard.constants.ResourcePath;
import com.atmecs.falconrepoertdashboard.uiaction.enums.BrowserType;
import com.atmecs.falconrepoertdashboard.utils.Report;



public class ManageDriver {
	
	Report report = new Report();
	WebDriver driver;
	
	
	/**
	 * this method will set browser as per parameter passed.
	 * chrome, firefox or internet explorer
	 * @param browser
	 */
	public ManageDriver(String browser) {
		System.out.println("in run local mode");
		try
		{
		switch (BrowserType.valueOf(browser)) {
		case CHROME:{
				System.out.println("in chrome set");
				this.driver = setChromeDriver();
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

		//set download dir
		ChromeOptions options = setChromeOPtions();
		return new ChromeDriver(options);
	}
	
	private WebDriver setFirefoxDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.gecko.driver", currentdir + "geckodriver.exe");
		
		//set download dir
		FirefoxOptions options = setFirefoxOPtions();
		return new FirefoxDriver(options);
	}
	
	public WebDriver setInterExplorerDriver() {
		String currentdir = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
		System.setProperty("webdriver.ie.driver", currentdir + "IEDriverServer.exe");
		
		return new InternetExplorerDriver();
	}

	public ChromeOptions setChromeOPtions() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePref = new HashMap<>();
		chromePref.put("download.default_directory", System.getProperty("user.dir")+File.separator+"downloads") ;
		options.setExperimentalOption("prefs", chromePref);
		
		return options;
	}
	public FirefoxOptions setFirefoxOPtions() {
		// Creating firefox profile
        FirefoxProfile profile = new FirefoxProfile();
 
        // Instructing firefox to use custom download location
        /**
         * Default Value: 0
		 * This can be set to either 0, 1, or 2. When set to 0, Firefox will save all files on the user’s desktop. 
		 * 1 saves the files in the Downloads folder and 
		 * 2 saves file at the location specified for the most recent download.
         */
        profile.setPreference("browser.download.folderList", 2);
 
        // Setting custom download directory
        profile.setPreference("browser.download.dir", ProjectPath.DOWNLOAD_HOME);
 
        // Skipping Save As dialog box for types of files with their MIME
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/java-archive, application/x-msexcel,application/excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
 
        //profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        
        // Creating FirefoxOptions to set profile
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);

		return options;
	}
	

}
