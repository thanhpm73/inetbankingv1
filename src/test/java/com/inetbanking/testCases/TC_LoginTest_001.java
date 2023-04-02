package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException
	{
		//driver.get(baseUrl);
		logger.info("Url is opened");
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Enter username");
		
		lp.setPassWord(password);
		logger.info("Enter password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver, "login Test");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	
			
	}

}
