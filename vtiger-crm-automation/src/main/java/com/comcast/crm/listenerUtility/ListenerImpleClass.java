package com.comcast.crm.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImpleClass implements ITestListener, ISuiteListener {

	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		// Spark report config
		spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add environment information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-11");
		report.setSystemInfo("Browser", "Chrome");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report BackUP");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("======>" + result.getMethod().getMethodName() + "<===START===");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "==>Started<==");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("=====>" + result.getMethod().getMethodName() + "<===END===");
		test.log(Status.PASS, result.getMethod().getMethodName() + "==>Completed<==");
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		// String testName = result.getMethod().getMethodName();
		TakesScreenshot tks = (TakesScreenshot) BaseClass.sdriver;
		String filepath = tks.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "==>Failed<==");
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName() + "==>Skipped<==");
	}

}
