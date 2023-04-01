package com.inetbanking.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.SimpleDate;
import com.aventstack.extentreports.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.internal.annotations.ITest;
public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="Test-Report-"+timeStamp+ ".html";
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		//ẽ.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		//htmlReporter.loadConfig(System.getProperty("user.dir")+"/extent-config.xml");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Enviroment", "QA");
		extent.setSystemInfo("user", "pavan");

		htmlReporter.config().setDocumentTitle("InetBanking");
		htmlReporter.config().setReportName("Function Test Report");
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.Top);
		htmlReporter.config().setTheme(Theme.DARK);

	}
	public void onTestSuccess(ITestResult tr)
	{
		logger= extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr)
	{
		logger= extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

//		String ScreenshotPath= System.getProperty("user.dir")+"\\Screenshort\\"+tr.getName()+".png";

//		File f= new File(ScreenshotPath);
//
//		if(f.exists())
//		{
//			logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(ScreenshotPath));
//		}
	}
	
	public void onTestSkiped(ITestResult tr)
	{
		logger= extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	public void onFinish (ITestResult testContext)
	{
		extent.flush();
	}

}



