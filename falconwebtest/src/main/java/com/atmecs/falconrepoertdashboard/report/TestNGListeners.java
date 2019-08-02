package com.atmecs.falconrepoertdashboard.report;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.atmecs.falconrepoertdashboard.testsuite.TestSuiteBase;
import com.atmecs.falconrepoertdashboard.uiaction.Browser;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;



public class TestNGListeners extends TestSuiteBase implements ITestListener {

	// Extent Report Declarations
	private ExtentReports extent = ExtentManager.createInstance();
	private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public synchronized void onStart(ITestContext context) {
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		test.set(extentTest);
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		for (String details : Reporter.getOutput(result)) {
			if (details.contains("PASS"))
				test.get().log(Status.INFO, "<strong style=\"color:green;\">" + details + "</strong>");
			else if (details.contains("FAIL"))
				test.get().log(Status.INFO, "<strong style=\"color:red;\">" + details + "</strong>");
			else
				test.get().log(Status.INFO, "<strong style=\"color:black;\">" + details + "</strong>");
		}
		test.get().pass("TEST PASSED : " + result.getMethod().getConstructorOrMethod().getName());
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		for (String details : Reporter.getOutput(result)) {
			if (details.contains("PASS"))
				test.get().log(Status.INFO, "<strong style=\"color:green;\">" + details + "</strong>");
			else if (details.contains("FAIL"))
				test.get().log(Status.INFO, "<strong style=\"color:red;\">" + details + "</strong>");
			else
				test.get().log(Status.INFO, "<strong style=\"color:black;\">" + details + "</strong>");
		}
		MediaEntityModelProvider mediaModel;
		try {
			mediaModel = MediaEntityBuilder
					.createScreenCaptureFromPath(takesScreenShot(result.getMethod().getMethodName())).build();
			test.get().fail(result.getThrowable(), mediaModel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		for (String details : Reporter.getOutput(result)) {
			if (details.contains("PASS"))
				test.get().log(Status.INFO, "<strong style=\"color:green;\">" + details + "</strong>");
			else if (details.contains("FAIL"))
				test.get().log(Status.INFO, "<strong style=\"color:red;\">" + details + "</strong>");
			else
				test.get().log(Status.INFO, "<strong style=\"color:black;\">" + details + "</strong>");
		}
		test.get().skip("<br><h6>Method Name : " + result.getMethod().getConstructorOrMethod().getName()
				+ "</h6><br><h6>STACKTRACE<br><p>" + result.getThrowable() + "</h6></p>");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		for (String details : Reporter.getOutput(result)) {
			if (details.contains("PASS"))
				test.get().log(Status.INFO, "<strong style=\"color:green;\">" + details + "</strong>");
			else if (details.contains("FAIL"))
				test.get().log(Status.INFO, "<strong style=\"color:red;\">" + details + "</strong>");
			else
				test.get().log(Status.INFO, "<strong style=\"color:black;\">" + details + "</strong>");
		}
		MediaEntityModelProvider mediaModel;
		try {
			mediaModel = MediaEntityBuilder
					.createScreenCaptureFromPath(takesScreenShot(result.getMethod().getMethodName())).build();
			test.get().fail(result.getThrowable(), mediaModel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * @param This method takes current instance method Name
	 * @return Returns the path where you want to store the particular file.
	 */
	public String takesScreenShot(String methodName) {
	  final String filePath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
		//System.out.println(filePath);
		WebDriver driver = browser.getDriver();
	  //AppiumDriver<MobileElement> driver = ThreadPool.getDriverInfo().getDriver();
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imagePath = filePath + methodName + ".png";
		//System.out.println(imagePath);
		try {
			FileUtils.copyFile(srcFile, new File(imagePath));
		} catch (IOException e) {
			System.err.println("Error in capturing screenshot");
			e.printStackTrace();
		}
		return imagePath;
	}
	
	
	
}