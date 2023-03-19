package com.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Reusable.BaseClass;

public class TestEventListenersUtility implements ITestListener {
	protected static ExtendReportUtility extentreport = null;
	protected WebDriver driver;
	
	@Override
	//result of each test method in ITestResult. this also from testng
	public void onTestStart(ITestResult result) {
		
		extentreport.startSingleTestReport(result.getMethod().getMethodName());
	}

	@Override
	//repeats for every test when succeed
	public void onTestSuccess(ITestResult result) {
		//will return the name of method
		extentreport.logTestPassed(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentreport.logTestFailed(result.getMethod().getMethodName());
		BaseClass ob=new BaseClass();
		driver = ob.returnDriverInstance();
		String path = ob.getScreenshotOfThePage(driver);
		System.out.println(" Screen shot path==> "+path);
		//extentreport.logTestFailedWithException(result.getThrowable()); have to chk this mwthod
		extentreport.logTestScreenshot(path);
	}

	@Override
	//ITestContext contains overall methods for whole test
	public void onStart(ITestContext context) {
		extentreport = ExtendReportUtility.getInstance();
		extentreport.startExtendReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.endReport();
	}

}
