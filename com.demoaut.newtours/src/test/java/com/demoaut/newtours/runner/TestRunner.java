package com.demoaut.newtours.runner;

import java.io.*;
import org.junit.runner.RunWith;
import org.junit.AfterClass;
import cucumber.api.junit.Cucumber;

import com.demoaut.newtours.managers.*;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests/FlightBooking.feature"
		,glue={"com.demoaut.newtours.stepDefinitions"}
		//*** to generate normal cucumber reports //***
//		,plugin = { "pretty", "html:target/cucumber-reports"
//				    "json:target/cucumber-reports/Cucumber.json",
//				    "junit:target/cucumber-reports/Cucumber.xml",
//		}
		//*** to generate extent cucumber reports //***
		 ,plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		,monochrome = true
		)
public class TestRunner  {
	@AfterClass
	public static void writeExtentReport() {		
			
			Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		 	Reporter.setSystemInfo("User Name", "Debasish Damodar");
		    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		    Reporter.setSystemInfo("Machine", 	"Windows 7 " + "64 Bit");
		    Reporter.setSystemInfo("Selenium", "3.10.0");
		    Reporter.setSystemInfo("Maven", "3.7.0");
		    Reporter.setSystemInfo("Java Version", "1.8");
		
	}
}