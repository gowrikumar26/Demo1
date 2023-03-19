package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportUtility {
	
	public static ExtentReports report;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest testLogger;
	private static ExtendReportUtility extendObject = null;
	
	//Singletone method
	private ExtendReportUtility() {
		
	}
	
	public static ExtendReportUtility getInstance() {
		if(extendObject == null) {
			extendObject = new ExtendReportUtility();
		}
		return extendObject;
	}
	
	public void startExtendReport() {
		sparkReporter = new ExtentSparkReporter(Constants.SPARKS_HTML_REPORTS_PATH);
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		
		report.setSystemInfo("HostName", "Salesforce");
		report.setSystemInfo("Environment", "Automation Testing");
		report.setSystemInfo("User Name", "Gowri");
		
		sparkReporter.config().setDocumentTitle("Test Excution Report");
		sparkReporter.config().setReportName("Regression tests");
		sparkReporter.config().setTheme(Theme.DARK);
	}
	
	public void startSingleTestReport(String testScript_Name) {
		testLogger = report.createTest(testScript_Name);
	}
	
	public void logTestInfo(String text) {
		//testLogger.log(Status.INFO,text ); can write this way or the way below. both r correct way.
		testLogger.info(text);
	}
	
	public void logTestPassed(String testcaseName) {
		testLogger.pass(MarkupHelper.createLabel(testcaseName + " is passTest", ExtentColor.GREEN));
	}
	
	public void logTestFailed(String testcaseName) {
		testLogger.fail(MarkupHelper.createLabel(testcaseName + "is FailTest", ExtentColor.RED));
	}
	
	public void logTestFailedWithException(Exception e) {
		testLogger.log(Status.FAIL, e);
	}
	
	public void logTestScreenshot(String path) {
		testLogger.addScreenCaptureFromPath(path);
	}
	
	public void endReport() {
		report.flush();
	}
}
