package com.atmecs.falconrepoertdashboard.main;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import com.atmecs.falconrepoertdashboard.constants.ResourcePath;

public class Runner {

	public static void main(String[] args) {
		// Create object of TestNG Class
		System.out.println("In Runner class to run :");
		TestNG runner=new TestNG();

		// Create a list of String 
		List<String> suitefiles=new ArrayList<String>();

		// Add xml file which you have to execute
		suitefiles.add(ResourcePath.TESTNG_XML_PATH);

		// now set xml file for execution
		runner.setTestSuites(suitefiles);

		// finally execute the runner using run method
		//runner.run();
	}
}
