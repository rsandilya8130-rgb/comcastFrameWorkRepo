package adv_report_listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class List_Imp implements ISuiteListener ,ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("It will executer before  the @BeforeSuite....");
		long time=System.currentTimeMillis();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./Adv_report/"+time+".html");
		spark.config().setDocumentTitle("sauce demo login");
		spark.config().setReportName("login report");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("ATE", "Rahul");
		report.setSystemInfo("Browser", "edge");
		report.setSystemInfo("Window", "11");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+" is passed..");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, MethodName+" is failed...");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+" is Skipped...");
	}
	
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("It will executer after the @AfterSuite....");
		report.flush();
	}
}
