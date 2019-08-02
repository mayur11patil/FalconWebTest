package com.atmecs.falconrepoertdashboard.report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Platform;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	private static Platform platform;
	private static String reportFileName = "Falcon_Report_dashboard.html";
	private static String macPath = System.getProperty("user.dir") + File.separator + "TestReport";
	private static String windowsPath = System.getProperty("user.dir") + File.separator + "ExtentReport";
	private static String macReportFileLoc = macPath + File.separator + reportFileName;
	private static String winReportFileLoc = windowsPath + File.separator + reportFileName;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	private static String getTimeStamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		return dateFormat.format(new Date()).replaceAll(" ", "_");
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {
		platform = getCurrentPlatform();
		String fileName = getReportFileLocation(platform);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		// htmlReporter.loadXMLConfig(System.getProperty("user.dir")+File.separator+"ExtentReport"+File.separator+"extent-config.xml");

		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss a");
		htmlReporter.config().setDocumentTitle("Web Automation Results");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Web Automation Report");
		htmlReporter.config()
				.setCSS("#step-filters.right{display : none;}" + "#charts-row .card-panel {\r\n"
						+ "    border-top: 1px solid #ddd;\r\n" + "    border-bottom: 1px solid #eee;\r\n"
						+ "    border-right: 1px solid #eee;\r\n" + "    height: 180px;\r\n" + "width: 1296px;" + "}"
						+ ".tooltipped{ font-size : 15px }" + ".text-small{ font-size : 18px }");
		extent = new ExtentReports();
		// class view:
		extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
		extent.setSystemInfo("OS", "windows");
		extent.setSystemInfo("Regression", "falcon");
		extent.setSystemInfo("URL", "falcondashboard");
		extent.attachReporter(htmlReporter);
		return extent;
	}

	// Select the extent report file location based on platform
	private static String getReportFileLocation(Platform platform) {
		String reportFileLocation = null;
		switch (platform) {
		case MAC:
			reportFileLocation = macReportFileLoc;
			createReportPath(macPath);
			break;
		case WINDOWS:
			reportFileLocation = winReportFileLoc;
			createReportPath(windowsPath);
			break;
		default:
			System.out.println("ExtentReport path has not been set! There is a problem!\n");
			break;
		}
		return reportFileLocation;
	}

	// Create the report path if it does not exist
	private static void createReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!");
			} else {
				// System.out.println("Failed to create directory: " + path);
			}
		} else {
			// System.out.println("Directory already exists: " + path);
		}
	}

	// Get current platform
	private static Platform getCurrentPlatform() {
		if (platform == null) {
			String operSys = System.getProperty("os.name").toLowerCase();
			if (operSys.contains("win")) {
				platform = Platform.WINDOWS;
			} else if (operSys.contains("nix") || operSys.contains("nux") || operSys.contains("aix")) {
				platform = Platform.LINUX;
			} else if (operSys.contains("mac")) {
				platform = Platform.MAC;
			}
		}
		return platform;
	}
}