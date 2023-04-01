package com.inetbanking.testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassWord(password);
		
		logger.info("Password is provided");
		
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust= new AddCustomerPage(driver);
		addcust.ClickAddNewCustomer();
		
		logger.info("Providing customer details...");
		addcust.custName("Thanhnew");
		addcust.custGender("male");
		addcust.custdob("10","10","20");
		
		Thread.sleep(3000);
		addcust.custAddress("QuangBinh");
		addcust.custCity("Quang ");
		addcust.custState("Phuong");
		addcust.custPino("123456");
		addcust.custPhone("0123456777");
		String email= randomestring()+"@gmail.com";
		addcust.custEmail(email);
		
		addcust.custPass("1111");
		addcust.custSubmit(email);
		
		Thread.sleep(5000);
		
		logger.info("Validation started...");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(false);
			logger.info("Test case passed....");
		}
		else
		{
			logger.info("Test case Failed");
			captureScreen(driver, "addnewcustomer");
			Assert.assertTrue(false);
			
		}
	}


}
